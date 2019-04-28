package Application;

import java.util.HashMap;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gnu.prolog.database.PrologTextLoaderError;
import gnu.prolog.demo.mentalarithmetic.NoAnswerException;
import gnu.prolog.term.Term;
import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.Interpreter.Goal;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

public class ExpertSystem {
	
	final static private int NBCRITERIA = 12; 
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private String[][] knowledge;
	private Environment env;
	private Interpreter interpreter;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public ExpertSystem() {
		this.knowledge = new String[][]{{
			"kindOfOrganisation", 
			"kindOfProduct", 
			"headOfficeInEU", 
			"weight", 
			"standardPart", 
			"mainResponsabilities", 
			"typeCertificate", 
			"requestModification", 
			"nextTarget", 
			"modificationRequestOrNexProgram",
			"privilegeFromEASA",
			"operationalConditionsMightBeRestricted"},
			{"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}};
	}
	
	/* * * * * S E T T E R * * * * */
	
	/**
	 * Modify the knowledge according to the parameters
	 */
    public void setKnowledge(String name, String value) 
	{ 
    	for(int i = 0; i < NBCRITERIA; i++) {
    		if(this.knowledge[0][i].equals(name)) 
    		{
    			this.knowledge[1][i] = value;
    		}
    	 }
 	}

	/* * * * * M E T H O D S * * * * */
	
	/**
	 * Write the knowledge in a Prolog file.
	 */
    private void writeKnowledge() 
	{ 
		String file = ExpertSystem.class.getResource("knowledge.pl").getFile(); 
		try { 
		   	FileWriter fw = new FileWriter(file, false); 
		  	BufferedWriter output = new BufferedWriter(fw); 
		  	System.out.println("[DEBUG] Writing in knowledge.pl : ");
		  	for(int i = 0; i < NBCRITERIA; i++) {
		  		output.write(this.knowledge[0][i] + "(" + this.knowledge[1][i] + ").\n");
		  		System.out.println("\t" + this.knowledge[0][i] + "(" + this.knowledge[1][i] + ").");
	    	 }
		  	output.flush(); 
		  	output.close(); 
	  	} catch(IOException ioe)
		{ 
			System.out.print("[ERROR] "); ioe.printStackTrace();
		} 
 	}

	/**
	 * Ensure that we have an environment and have loaded the prolog code and have
	 * an interpreter to use.
	 */
	private synchronized void setup()
	{
		// Construct the environment
		this.env = new Environment();

		// Get the prolog files to use
		this.env.ensureLoaded(AtomTerm.get(ExpertSystem.class.getResource("knowledge.pl").getFile()));
		this.env.ensureLoaded(AtomTerm.get(ExpertSystem.class.getResource("rules.pl").getFile()));

		// Get the interpreter.
		
		this.interpreter = this.env.createInterpreter();
		// Run the initialization
		this.env.runInitialization(this.interpreter);
	}
	
	/**
	 * Collect debugging information if something has gone wrong
	 */
	private void debug()
	{
		List<PrologTextLoaderError> errors = this.env.getLoadingErrors();
		for (PrologTextLoaderError error : errors)
		{
			error.printStackTrace();
		}
	}
	
	/**
	 * Return the first answer of the predicate.
	 */
	private String reason(String predicate) throws PrologException, NoAnswerException
	{
		this.writeKnowledge();
		this.setup();
		// // Construct the question.
		// Create variable terms so that we can pull the answers out later
		VariableTerm answerTerm = new VariableTerm("Answer");
		// Create the arguments to the compound term which is the question
		Term[] args = { answerTerm };
		// Construct the question
		CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get(predicate), args);
		// Create the answer
		String answer = null;

		synchronized (interpreter)// so that this class is thread safe.
		{
			// Print out any errors
			this.debug();
			
			// Execute the goal and return the answer.
			Goal goal = interpreter.prepareGoal(goalTerm);
			int rc = interpreter.execute(goal);

			// If it succeeded.
			if (rc == PrologCode.SUCCESS || rc == PrologCode.SUCCESS_LAST)
			{
				// Get hold of the actual Terms which the variable terms point to
				Term value = answerTerm.dereference();
				if (value != null)
				{
					answer = value.toString();
				}
				if (rc == PrologCode.SUCCESS)
				{
					interpreter.stop(goal);
				}
			} else 
			{
				throw new NoAnswerException("[ERROR] reason() - Problem in tree architecture.");
			}
		}
		System.out.println("[DEBUG] reason() - Result : " + answer);
		return answer;
	}

	/* * * * * M A I N * * * * */
	
	public static void main(String[] args)
	{
		ExpertSystem expertSystem = new ExpertSystem();
		HashMap<String, Question> questions = Question.getQuestions();
		try
		{	
			// Exemple de raisonnement de ExpertSystem
			// // Au début, il faut poser la q° sur kindOfOrganisation
			String reasoning = expertSystem.reason("reasoner");
			// If reasoning matches the regex [0-9]
			boolean scenarioFound = reasoning.matches("\\d");
			if(scenarioFound) {
				// resultView
				int scenario = Integer.parseInt(reasoning);
				System.out.println("[DEBUG] We find the perfect scenario  : " + scenario);
			} else {
				// questionView
				Question currentQuestion = questions.get(reasoning);
				System.out.println("[DEBUG] We need to ask an other question : " + currentQuestion.getTitle());
			}
			
			// Exemple de traitement d'une réponse de l'utilisateur
			// // Si l'utilisateur répond oem à la 1ère question
			// // La vue renvoie la clé de la réponse choisie
			String keyUserAnswer = "oem";
			expertSystem.setKnowledge("kindOfOrganisation", keyUserAnswer);
			// // Pour vérifier que ça s'est bien mis à jour : 
			expertSystem.writeKnowledge();
			
		} // Something went wrong: tell the user.
		catch (PrologException e)
		{
			System.err.println(e.toString());
		}
		catch (NoAnswerException e)
		{
			System.err.println(e.toString());
		}
	}
}

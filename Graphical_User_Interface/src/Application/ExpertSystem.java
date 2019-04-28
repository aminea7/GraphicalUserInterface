package Application;

import java.util.List;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	
	private static String[][] knowledge;
	
	/**
	 * Whether we have done {@link #setup()} or not.
	 */
	private static boolean issetup = false;

	/**
	 * The {@link Environment} we are using.
	 * 
	 * @see #setup() for creation
	 * @see #reason() for usage
	 */
	private static Environment env;
	/**
	 * The {@link Interpreter} we are using.
	 * 
	 * @see #setup() for creation
	 * @see #reason() for usage
	 */
	private static Interpreter interpreter;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public ExpertSystem() {
		knowledge = new String[][]{{
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

	/* * * * * M E T H O D S * * * * */
	
	/**
	 * Write the knowledge in a Prolog file.
	 */
	private void writeKnowledge()
	{
		DataOutputStream dos;
	     try {
	    	 dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("knowledge.txt"))));
	    	 for(int i = 0; i < NBCRITERIA; i++) {
				dos.writeChars(knowledge[i][0] + "(" + knowledge[i][1] + ").\n");
	    	 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Ensure that we have an environment and have loaded the prolog code and have
	 * an interpreter to use.
	 */
	private synchronized static void setup()
	{
		if (issetup)
		{
			return;// don't setup more than once
		}

		// Construct the environment
		env = new Environment();

		// Get the prolog files to use
		env.ensureLoaded(AtomTerm.get(ExpertSystem.class.getResource("knowledge.pl").getFile()));
		env.ensureLoaded(AtomTerm.get(ExpertSystem.class.getResource("rules.pl").getFile()));

		// Get the interpreter.
		
		interpreter = env.createInterpreter();
		// Run the initialization
		env.runInitialization(interpreter);

		// So that we don't repeat ourselves
		issetup = true;
	}
	
	/**
	 * Collect debugging information if something has gone wrong
	 */
	private static void debug()
	{
		List<PrologTextLoaderError> errors = env.getLoadingErrors();
		for (PrologTextLoaderError error : errors)
		{
			error.printStackTrace();
		}
	}
	
	public static String reason() throws PrologException, NoAnswerException
	{
		// // Construct the question.
		// Create variable terms so that we can pull the answers out later
		VariableTerm answerTerm = new VariableTerm("Answer");
		// Create the arguments to the compound term which is the question
		Term[] args = { answerTerm };
		// Construct the question
		CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("reasoner"), args);
		// Create the answer
		String answer = null;

		synchronized (interpreter)// so that this class is thread safe.
		{
			// Print out any errors
			debug();
			
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
				throw new NoAnswerException("[ERROR] Problem in tree architecture.");
			}
		}
		return answer;
	}
	
	/* * * * * M A I N * * * * */
	
	public static void main(String[] args)
	{
		try
		{
			writeKnowledge();
			setup();
			String answer = reason();
			System.out.println("Result : " + answer);

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

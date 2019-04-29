package Application;

import java.util.HashMap;

public class Question {
	
	private static boolean firstTime = true;
	private static HashMap<String, Question> questions; 
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private String title;
	private HashMap<String, String> answers;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	private Question (String pTitle, HashMap<String, String> pAnswers) {
		this.title = pTitle;
		this.answers = pAnswers;
	}
	
	/* * * * * M E T H O D S * * * * */
	
	/**
	 * Create the questions that can be asked to the user
	 */
	private static void createQuestions() {
		questions = new HashMap<String, Question>();
		HashMap<String, String> answers = new HashMap<String, String>();
		
		// Question 1
		answers.put("oem", "An OEM");
		answers.put("motorist", "A Motorist");
		answers.put("tier", "A Tier-1, 2 or 3");
		questions.put("kindOfOrganisation", new Question("What kind of organisation is concerned by the Certification Process ?", answers));
		
		// Question 2
		answers.clear();
		answers.put("aircraft", "An Aircraft");
		answers.put("motorOrPropulsionSystem", "A Motor or Propulsion system");
		answers.put("appliance", "An Appliance");
		answers.put("part", "A Part");
		questions.put("kindOfProduct", new Question("What kind of product is concerned by the Certification Process ?", answers));
		
		// Question 3
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("headOfficeInEu", new Question("Is the head office of the organisation in the EU or in one of these countries : Iceland, Liechtenstein, Norway or Swiss ?", answers));
		
		// Question 4
		answers.clear();
		answers.put("moreThan2T", "More than 2T");
		answers.put("lessThan2T", "Less than 2T");
		questions.put("weight", new Question("What is the weight of the aircraft concerned by the Certification Process ?", answers));
		
		// Question 5
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("standardPart", new Question("Is it a standard part ?", answers));
		
		// Question 6
		answers.clear();
		answers.put("design", "Design");
		answers.put("production", "Production");
		answers.put("both", "Both");
		questions.put("mainResponsabilities", new Question("What will be the main responsabilities of the organisation ?", answers));
		
		// There is no question 7
		
		// Question 8
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("typeCertificate", new Question("Does the organisation hold already a type certificate ?", answers));
		
		// Question 9
		answers.clear();
		answers.put("newProgram", "New program");
		answers.put("modificationRequest", "Modification request");
		questions.put("modificationRequestOrNewProgram", new Question("Does the organisation want to request a modification for an already held TC or does the certification process concern a nex program ?", answers));
		
		// Question 10
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("requestModification", new Question("Does the organisation want to request a modification for the current certification process ?", answers));
		
		// Question 11
		answers.clear();
		answers.put("en9100", "EN 9100");
		answers.put("designApproval", "Design approval");
		answers.put("productionApproval", "Production approval");
		answers.put("tcAndCoA", "TC and CoA");
		questions.put("nextTarget", new Question("What is the next target for the Organisation ?", answers));
		
		// Question 12
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("privilefeFromEASA", new Question("Does the organisation have any privilege from EASA ?", answers));
		
		// Question 13
		answers.clear();
		answers.put("yes", "Yes");
		answers.put("no", "No");
		questions.put("operationalConditionsMightBeRestricted", new Question("Do you think the operational conditions might be restricted ?", answers));	
		
	}
	
	public static HashMap<String, Question> getQuestions() {
		if (firstTime) 
		{
			firstTime = false;
			createQuestions();
		}
		return questions;
	}

	public String getTitle() {
		return title;
	}

	public HashMap<String, String> getAnswers() {
		return answers;
	}
}

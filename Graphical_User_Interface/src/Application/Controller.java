package Application;

import java.util.HashMap;

import gnu.prolog.demo.mentalarithmetic.NoAnswerException;
import gnu.prolog.vm.PrologException;

public class Controller {
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private ExpertSystem expertSystem;
	
	private HashMap<String, Question> questions;
	private String keyCurrentQuestion;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public Controller() {
		expertSystem = new ExpertSystem();
		
		questions = Question.getQuestions();
		keyCurrentQuestion = null;
	}
	
	/* * * * * M E T H O D S * * * * */
	
	public Question button_start() {
		Question firstQuestion = null;
		try {
			String result = expertSystem.reason();
			firstQuestion = questions.get(result);
			keyCurrentQuestion = result;
			// TODO: Fermer WelcomeView
			// TODO : Lancer QuestionView
		} catch (PrologException | NoAnswerException e) {
			e.printStackTrace();
		}
		return firstQuestion;
	}
	
	public Question button_next(String keyAnswer) {
		Question nextQuestion = null;
		try {
			expertSystem.setKnowledge(keyCurrentQuestion, keyAnswer);
			String result = expertSystem.reason();
			boolean scenarioFound = result.matches("\\d+");
			if(scenarioFound) {
				int scenario = Integer.parseInt(result);
				// TODO: Lancer ResultView
			} else {
				nextQuestion = questions.get(result);
				keyCurrentQuestion = result;
				// TODO: Fermer QuestionView
			}
		} catch (PrologException | NoAnswerException e) {
			e.printStackTrace();
		}
		return nextQuestion;
	}
	
	public Question button_previous() {
		Question previousQuestion = null;
		try {
			expertSystem.setKnowledge(keyCurrentQuestion, "_");
			String result = expertSystem.reason();
			previousQuestion = questions.get(result);
			keyCurrentQuestion = result;
		} catch (PrologException | NoAnswerException e) {
			e.printStackTrace();
		}
		return previousQuestion;
	}
	
	public void button_home() {
		// TODO: Fermer la currentView
		// TODO: Lancer HomeView
		expertSystem.resetKnowledge();
	}

}
























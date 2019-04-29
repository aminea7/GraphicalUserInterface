package Application;

import java.util.HashMap;

import gnu.prolog.demo.mentalarithmetic.NoAnswerException;
import gnu.prolog.vm.PrologException;

enum Language {FR,EN};
enum View {Welcome, Question, Result, Resources};

public class Controller {
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private ExpertSystem expertSystem;
	
	private HashMap<String, Question> questions;
	private String keyCurrentQuestion;
	
	private WelcomeView welcomeView;
	private QuestionView questionView;
	private ResultView resultView;
	private ResourcesView resourcesView;
	private View currentView;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public Controller() {
		expertSystem = new ExpertSystem();
		welcomeView = new WelcomeView();
		questionView = new QuestionView();
		resultView = new ResultView();
		resourcesView = new ResourcesView();
		questions = Question.getQuestions();
		keyCurrentQuestion = null;
		welcomeView.startWelcomeView();
		currentView = View.Welcome;
	}
	
	/* * * * * M E T H O D S * * * * */
	
	//Used to start the questionnaire from the welcome view
	public void startQuestionnaire() {
		Question firstQuestion = null;
		try {
			//Gets the first question (root of the questionnaire
			String result = expertSystem.reason();
			firstQuestion = questions.get(result);
			keyCurrentQuestion = result;
			//Closes the welcome view and replaces it with the question view displaying the first question
			welcomeView.closeWelcomeView();
			questionView.startQuestionView(firstQuestion);
			currentView = View.Question;
		} catch (PrologException | NoAnswerException e) {
			e.printStackTrace();
		}
	}
	
	//Used by the questionnaire to get the next question and refresh the view to display it
	public Question nextQuestion(String keyAnswer) {
		Question nextQuestion = null;
		try {
			expertSystem.setKnowledge(keyCurrentQuestion, keyAnswer);
			String result = expertSystem.reason();
			boolean scenarioFound = result.matches("\\d+");
			if(scenarioFound) {
				int scenario = Integer.parseInt(result);
				// TODO: R�cup�rer les docs du scenario dans Model
				// TODO: Lancer ResultView
				resultView.startResultView();
				currentView = View.Result;
			} else {
				nextQuestion = questions.get(result);
				keyCurrentQuestion = result;
			}
		} catch (PrologException | NoAnswerException e) {
			e.printStackTrace();
		}
		return nextQuestion;
	}
	
	//Used by the questionnaire to get the previous question and refresh the view to display it
	public Question previousQuestion() {
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
	
	public void displayHome() {
		switch (currentView) {
		case Question:
			questionView.closeQuestionView();
			break;
		case Result:
			resultView.closeResultView();
			break;
		case Resources:
			resourcesView.closeResourcesView();
			break;
		}
		welcomeView.startWelcomeView();
		currentView = View.Welcome;
		expertSystem.resetKnowledge();
	}
	
	public void changeLanguage() {
		//TODO
	}

}
























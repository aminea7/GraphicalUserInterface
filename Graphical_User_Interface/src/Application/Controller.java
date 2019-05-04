package Application;

import java.util.HashMap;

import gnu.prolog.demo.mentalarithmetic.NoAnswerException;
import gnu.prolog.vm.PrologException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.explorer.ProjectFilePanel;

enum Language {FR,EN};
enum View {Welcome, Question, Result, Resources};
enum Resource {Schedule, Chart, ReqList, ReqModel, ProcModel};
int NUMBER_OF_RESOURCES = 5;

public class Controller {
	
	/* * * * * A T T R I B U T E S * * * * */
	
	//The list of all available questions
	private HashMap<String, Question> questions;
	//All the answers provided until now, the key is the key of the question that they correspond to
	private HashMap<String, String> answers;
	private String keyCurrentQuestion;
	//Contains the representation of the resources to be displayed on resultView
	//To be changed when the format of the resources is settled
	private String[] resources;
	private ProjectFile schedule;
	private ExpertSystem expertSystem;
	private WelcomeView welcomeView;
	private QuestionView questionView;
	private ResultView resultView;
	private ResourcesView resourcesView;
	private Model model;
	private View currentView;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public Controller() {
		expertSystem = new ExpertSystem();
		welcomeView = new WelcomeView();
		questionView = new QuestionView();
		resultView = new ResultView();
		resourcesView = new ResourcesView();
		model = new Model();
		answers = new HashMap<String,String>();
		resources = new String[NUMBER_OF_RESOURCES];
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
			//Gets the first question (root of the questionnaire)
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
		//Saves the answer to the previous question
		answers.put(keyCurrentQuestion, keyAnswer);
		try {
			expertSystem.setKnowledge(keyCurrentQuestion, keyAnswer);
			String result = expertSystem.reason();
			boolean scenarioFound = result.matches("\\d+");
			//When the questionnaire is finished
			if(scenarioFound) {
				int scenario = Integer.parseInt(result);
				//Retrieving the resources
				//Can be displayed using :
				//http://www.mpxj.org/apidocs/net/sf/mpxj/explorer/ProjectFilePanel.html
				schedule = Model.getSchedule(scenario);
				//Displaying resultView
				questionView.closeQuestionView();
				resultView.startResultView();
				currentView = View.Result;
			//Otherwise, we proceed to next question
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
		//Closes the current view
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
		//Opens welcome view and resets questionnaire
		welcomeView.startWelcomeView();
		currentView = View.Welcome;
		expertSystem.resetKnowledge();
	}
	
	//Called upon clicking on an answer in the list of previous questions displayed during the questionnaire
	public Question editAnswer(String keyQuestion) {
		keyCurrentQuestion = keyQuestion;
		return questions.get(keyQuestion);
	}
	
	public void changeLanguage() {
		//TODO
	}
	
	//Used when clicking save on the results view, allows the user to specify
	//a place where the project has to be saved.
	//Creates a specific file taht contains the data of the ExpertSystem
	public void saveResults() {
		//TODO
	}
	
	//Used when clicking on download on the results view
	//Downloads all resources in a zip archive
	public void downloadResources() {
		ProjectFilePanel panelSchedule = new ProjectFilePanel(schedule);
		panelSchedule.saveFile(schedule, "mpp");
	}
	
	//Used from the results view to redo the questionnaire
		public void redoQuestionnaire() {
			editAnswer("kindOfOrganisation");
		}
	
	//Used by result view when choosing to display one of the resources
	public String displayResource(Resource r) {
		String ret = "";
		switch (r) {
		case Schedule:
			ret = resources[0];
			break;
		case Chart:
			ret = resources[1];
			break;
		case ReqList:
			ret = resources[2];
			break;
		case ReqModel:
			ret = resources[3];
			break;
		case ProcModel:
			ret = resources[4];
			break;
		}
		return ret;
	}
	
	public void backToResults() {
		resourcesView.closeResourcesView();
		resultView.startResultView();
		currentView = View.Result;
	}
}
























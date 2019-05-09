package Application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Application.Resource.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import java.awt.Font;

public class QuestionView extends JFrame {
	static final long serialVersionUID = 1L;
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private JPanel panel;
	private SpringLayout layout;
	
	private JPanel previousQuestionsPanel;
	private BoxLayout previousQuestionsLayout;
	private JScrollPane previousQuestionsScroll;

	private JPanel answersPanel;
	private BoxLayout answersLayout;
	private JScrollPane answersScroll;
	
	public Controller controller;
	public Question currentQuestion;
	private HashMap<String, String> listQA;
	
	private String currentAnswer;
	
	private JLabel questionLabel;
	private JLabel lblQuestionItself;
	private JLabel lblYourPreviousAnswers;
	private JButton btnPreviousQuestion;
	private JButton btnNextQuestion;
	private JButton btnHome;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public QuestionView(Controller c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.controller = c;
		
		panel = new JPanel();
		layout = new SpringLayout();
		
		previousQuestionsPanel = new JPanel();
		previousQuestionsScroll = new JScrollPane(previousQuestionsPanel);
		layout.putConstraint(SpringLayout.WEST, previousQuestionsScroll, 479, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, previousQuestionsScroll, -79, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, previousQuestionsScroll, -10, SpringLayout.EAST, panel);
		previousQuestionsLayout = new BoxLayout(previousQuestionsPanel, BoxLayout.Y_AXIS);
		
		answersPanel = new JPanel();
		answersScroll = new JScrollPane(answersPanel);
		layout.putConstraint(SpringLayout.WEST, answersScroll, 40, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, answersScroll, -148, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, answersScroll, -40, SpringLayout.WEST, previousQuestionsScroll);
		answersLayout = new BoxLayout(answersPanel, BoxLayout.Y_AXIS);
		
		this.setSize(1000,600);
		//setUpFrame();

	}
	private void setUpFrame() {
		/* General things to do. */
		setContentPane(panel);
		// Set the pan with its layout
		panel.setLayout(layout);
		previousQuestionsPanel.setLayout(previousQuestionsLayout);
		answersPanel.setLayout(answersLayout);

		
		panel.add(previousQuestionsScroll);
		panel.add(answersScroll);
		
		questionLabel = new JLabel("Question number ?");
		layout.putConstraint(SpringLayout.NORTH, questionLabel, 34, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, questionLabel, 40, SpringLayout.WEST, panel);
		questionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		panel.add(questionLabel);
		
		lblQuestionItself = new JLabel(currentQuestion.getTitle());
		layout.putConstraint(SpringLayout.NORTH, lblQuestionItself, 23, SpringLayout.SOUTH, questionLabel);
		layout.putConstraint(SpringLayout.SOUTH, lblQuestionItself, -379, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.NORTH, answersScroll, 25, SpringLayout.SOUTH, lblQuestionItself);
		layout.putConstraint(SpringLayout.WEST, lblQuestionItself, 40, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, lblQuestionItself, -60, SpringLayout.WEST, previousQuestionsScroll);
		panel.add(lblQuestionItself);
		
		lblYourPreviousAnswers = new JLabel("Your previous answers :");
		layout.putConstraint(SpringLayout.WEST, lblYourPreviousAnswers, 272, SpringLayout.EAST, questionLabel);
		lblYourPreviousAnswers.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		layout.putConstraint(SpringLayout.SOUTH, lblYourPreviousAnswers, -539, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.NORTH, previousQuestionsScroll, 6, SpringLayout.SOUTH, lblYourPreviousAnswers);
		panel.add(lblYourPreviousAnswers);
		
		btnPreviousQuestion = new JButton("Previous question");
		layout.putConstraint(SpringLayout.NORTH, btnPreviousQuestion, 55, SpringLayout.SOUTH, answersScroll);
		layout.putConstraint(SpringLayout.WEST, btnPreviousQuestion, 40, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, btnPreviousQuestion, -53, SpringLayout.SOUTH, panel);
		btnPreviousQuestion.setForeground(new Color(105, 105, 105));
		btnPreviousQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Go to previous question
				controller.previousQuestion();
			}
		});
		panel.add(btnPreviousQuestion);
		
		btnNextQuestion = new JButton("Next question");
		layout.putConstraint(SpringLayout.EAST, btnPreviousQuestion, -55, SpringLayout.WEST, btnNextQuestion);
		layout.putConstraint(SpringLayout.NORTH, btnNextQuestion, -1, SpringLayout.NORTH, btnPreviousQuestion);
		layout.putConstraint(SpringLayout.WEST, btnNextQuestion, 257, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, btnNextQuestion, -54, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, btnNextQuestion, 0, SpringLayout.EAST, lblQuestionItself);
		btnNextQuestion.setForeground(new Color(46, 139, 87));
		btnNextQuestion.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Advance to the next question
				controller.nextQuestion(currentAnswer);
				}
		});
		panel.add(btnNextQuestion);
		
		btnHome = new JButton("Home");
		layout.putConstraint(SpringLayout.NORTH, btnHome, 18, SpringLayout.SOUTH, previousQuestionsScroll);
		layout.putConstraint(SpringLayout.WEST, btnHome, -166, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.SOUTH, btnHome, -21, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, btnHome, -61, SpringLayout.EAST, panel);
		panel.add(btnHome);
		
		// Creation of a list of answers.
		if(currentQuestion.getAnswers() != null) {
			for(String answer : currentQuestion.getAnswers().values()) {
				JRadioButton newAnswer = new JRadioButton(answer);
				newAnswer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Advance to the next question
						currentAnswer = e.getActionCommand();
						}
				});
				answersPanel.add(newAnswer);
				answersPanel.revalidate();
				answersPanel.repaint();
			}
		}
		
		// Creation of a list of previous Q & A.
		if(listQA.values() != null) {
			for(String question : listQA.keySet()) {
				JLabel newQuestion = new JLabel(question);
				JLabel newAnswer = new JLabel(">>> " + listQA.get(question) + "<html><br><html>");
				previousQuestionsPanel.add(newQuestion);
				previousQuestionsPanel.add(newAnswer);
				previousQuestionsPanel.revalidate();
				previousQuestionsPanel.repaint();
			}
		}
		panel.repaint();
		panel.revalidate();
	}
	
	
	
	
	public void startQuestionView(Question cQ, HashMap<String, String> QA) {
		this.currentQuestion = cQ;
		this.listQA = QA;
		setUpFrame();
		this.setVisible(true);
	}
	
	public void closeQuestionView() {
		// Other things to be done ?
		this.setVisible(false);
	}
}

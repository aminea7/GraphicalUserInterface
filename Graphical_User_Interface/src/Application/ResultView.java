package Application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Application.Resource.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ResultView extends JFrame {
	static final long serialVersionUID = 1L;
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private JPanel panel;
	private SpringLayout layout;
	
	public Controller controller;
	public Question currentQuestion;
	private HashMap<String, String> listQA;
	
	private JPanel previousQuestionsPanel;
	private BoxLayout previousQuestionsLayout;
	private JScrollPane previousQuestionsScroll;
	
	private JLabel lblYourPreviousAnswers;
	private JLabel lblResults;
	private JButton btnHome;
	private JButton btnDownload;
	private JButton btnSave;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public ResultView(Controller c) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.controller = c;
		
		panel = new JPanel();
		layout = new SpringLayout();
		
		previousQuestionsPanel = new JPanel();
		previousQuestionsScroll = new JScrollPane(previousQuestionsPanel);
		layout.putConstraint(SpringLayout.WEST, previousQuestionsScroll, 479, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, previousQuestionsScroll, -10, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, previousQuestionsScroll, -10, SpringLayout.EAST, panel);
		previousQuestionsLayout = new BoxLayout(previousQuestionsPanel, BoxLayout.Y_AXIS);
		
		this.setSize(1000,600);
		setUpFrame();

	}
	private void setUpFrame() throws IOException {
		/* General things to do. */
		setContentPane(panel);
		// Set the pan with its layout
		panel.setLayout(layout);
		previousQuestionsPanel.setLayout(previousQuestionsLayout);

		panel.add(previousQuestionsScroll);
				
		//paintComponents(this.getGraphics());
		
		lblYourPreviousAnswers = new JLabel("All your answers :");
		lblYourPreviousAnswers.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		layout.putConstraint(SpringLayout.SOUTH, lblYourPreviousAnswers, -539, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.NORTH, previousQuestionsScroll, 6, SpringLayout.SOUTH, lblYourPreviousAnswers);
		layout.putConstraint(SpringLayout.WEST, lblYourPreviousAnswers, 0, SpringLayout.WEST, previousQuestionsScroll);
		panel.add(lblYourPreviousAnswers);
		
		/*
		//URL url = getClass().getResource("/Images/planning.png");
		//InputStream planningInput = new FileInputStream(url.getPath());
		
		String path = new File(".").getCanonicalPath();
		System.out.println(path);
		
		InputStream planningInput = getClass().getResourceAsStream("planning.png");
		BufferedImage planning = ImageIO.read(planningInput);
		JLabel logoPlanning = new JLabel(new ImageIcon(planning));
				
		layout.putConstraint(SpringLayout.NORTH, logoPlanning, 78, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, logoPlanning, 294, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, logoPlanning, -96, SpringLayout.WEST, previousQuestionsScroll);
        panel.add(logoPlanning);
		*/
		
		lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		layout.putConstraint(SpringLayout.NORTH, lblResults, 0, SpringLayout.NORTH, lblYourPreviousAnswers);
		layout.putConstraint(SpringLayout.WEST, lblResults, 203, SpringLayout.WEST, panel);
		panel.add(lblResults);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(new Color(70, 130, 180));
		layout.putConstraint(SpringLayout.WEST, btnHome, 33, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, btnHome, 136, SpringLayout.WEST, panel);
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nothing yet.
			}
		});
		panel.add(btnHome);
		
		btnDownload = new JButton("Download");
		btnDownload.setForeground(new Color(34, 139, 34));
		layout.putConstraint(SpringLayout.NORTH, btnHome, 0, SpringLayout.NORTH, btnDownload);
		layout.putConstraint(SpringLayout.SOUTH, btnHome, 0, SpringLayout.SOUTH, btnDownload);
		layout.putConstraint(SpringLayout.NORTH, btnDownload, -69, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.SOUTH, btnDownload, -29, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, btnDownload, -45, SpringLayout.WEST, previousQuestionsScroll);
		btnDownload.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nothing yet.
				controller.downloadResources();
			}
		});
		panel.add(btnDownload);
		
		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0, 128, 0));
		layout.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, btnHome);
		layout.putConstraint(SpringLayout.WEST, btnSave, 48, SpringLayout.EAST, btnHome);
		layout.putConstraint(SpringLayout.SOUTH, btnSave, 40, SpringLayout.NORTH, btnHome);
		layout.putConstraint(SpringLayout.EAST, btnSave, -39, SpringLayout.WEST, btnDownload);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveResults();
			}
		});
		btnSave.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		panel.add(btnSave);
		
		JButton btnPlanning = new JButton("Planning");
		layout.putConstraint(SpringLayout.NORTH, btnPlanning, 126, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, btnPlanning, -70, SpringLayout.WEST, previousQuestionsScroll);
		panel.add(btnPlanning);
		
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
	
	// Tests for drawing a line
    public void paintComponents(Graphics g) {
        super.paintComponents(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }
	
	public void startResultView(HashMap<String, String> listQA) throws IOException {
		this.listQA = listQA;
		setUpFrame();
		this.setVisible(true);
	}
	
	public void closeResultView() throws IOException {
		// Other things to be done ?
		this.setVisible(false);
	}
}

package Application;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;

public class WelcomeView extends JFrame {
	static final long serialVersionUID = 1L;
	
	/* * * * * A T T R I B U T E S * * * * */
	
	private JPanel welcomePanel;
	private SpringLayout layout;

	public Controller cont;
	
	/* * * * * C O N S T R U C T O R * * * * */
	
	public WelcomeView(Controller c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cont = c;
		
		welcomePanel = new JPanel();
		layout = new SpringLayout();
		
		this.setSize(600,600);
		//setUpFrame();

	}
	private void setUpFrame() {
		/* General things to do. */
		setContentPane(welcomePanel);
		// Set the pan with its layout
		welcomePanel.setLayout(layout);
		
		//Label title CeSort
		JLabel jcesort = new JLabel("CeSort");
		jcesort.setForeground(Color.DARK_GRAY);
		jcesort.setFont(new Font("Bitstream Charter", Font.BOLD , 60));
		jcesort.setBounds(40, 90, 300, 80);
		welcomePanel.add(jcesort);
		
		/*
		//Logo CeSort
		//InputStream logo2 = getClass().getResourceAsStream("Images/Logo-STAR.jpg");
		//ImageIcon logo= new ImageIcon(ImageIO.read(logo2));
		
		FileInputStream logo2 = new FileInputStream("Images/Logo-STAR.jpg");
		ImageIcon logo = new ImageIcon(ImageIO.read(logo2));
		
		JLabel image = new JLabel(logo);
		image.setBounds(650,90,300,80);
		welcomePanel.add(image);
		*/
		
		//Welcome small title
		JLabel jwelcome = new JLabel("Welcome ");
		layout.putConstraint(SpringLayout.SOUTH, jcesort, -29, SpringLayout.NORTH, jwelcome);
		jwelcome.setForeground(Color.BLACK);
		jwelcome.setFont(new Font("Dialog", Font.BOLD, 20));
		jwelcome.setBounds(60,170, 300,100);
		welcomePanel.add(jwelcome);
		
		JLabel welcomeText = new JLabel("<html>"
				+ "CeSort is an expert system made to sort out aeronautical standars. <br>"
				+ "It will allow you, after a few questions to download the things you need to start working on your aircraft project without any trouble.<br>"
				+ "<br>"
				+ "From this page, you can either initiate a new project by clicking on the \"Start\" button, or load a previous project that you would like to modify."
				+ "</html>");
		layout.putConstraint(SpringLayout.NORTH, welcomeText, 216, SpringLayout.NORTH, welcomePanel);
		layout.putConstraint(SpringLayout.SOUTH, jwelcome, -6, SpringLayout.NORTH, welcomeText);
		layout.putConstraint(SpringLayout.WEST, welcomeText, 49, SpringLayout.WEST, welcomePanel);
		layout.putConstraint(SpringLayout.EAST, welcomeText, 550, SpringLayout.WEST, welcomePanel);
		welcomeText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		welcomePanel.add(welcomeText);
		
		JButton btnStart = new JButton("Start");
		layout.putConstraint(SpringLayout.WEST, btnStart, 85, SpringLayout.WEST, welcomePanel);
		layout.putConstraint(SpringLayout.EAST, jcesort, 0, SpringLayout.EAST, btnStart);
		layout.putConstraint(SpringLayout.SOUTH, welcomeText, -23, SpringLayout.NORTH, btnStart);
		layout.putConstraint(SpringLayout.WEST, jwelcome, 0, SpringLayout.WEST, btnStart);
		layout.putConstraint(SpringLayout.NORTH, btnStart, 477, SpringLayout.NORTH, welcomePanel);
		layout.putConstraint(SpringLayout.SOUTH, btnStart, -54, SpringLayout.SOUTH, welcomePanel);
		btnStart.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		btnStart.setForeground(new Color(34, 139, 34));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Initiate questionnaire.
				cont.startQuestionnaire();
			}
		});
		btnStart.setBackground(new Color(224, 255, 255));
		welcomePanel.add(btnStart);
		
		JButton btnLoadProject = new JButton("Load Project");
		layout.putConstraint(SpringLayout.WEST, btnLoadProject, 350, SpringLayout.WEST, welcomePanel);
		layout.putConstraint(SpringLayout.EAST, btnStart, -111, SpringLayout.WEST, btnLoadProject);
		btnLoadProject.setForeground(new Color(105, 105, 105));
		layout.putConstraint(SpringLayout.NORTH, btnLoadProject, 0, SpringLayout.NORTH, btnStart);
		layout.putConstraint(SpringLayout.SOUTH, btnLoadProject, -54, SpringLayout.SOUTH, welcomePanel);
		layout.putConstraint(SpringLayout.EAST, btnLoadProject, -86, SpringLayout.EAST, welcomePanel);
		btnLoadProject.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnLoadProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nothing yet.
			}
		});
		welcomePanel.add(btnLoadProject);
		
		JButton btnChangeLanguage = new JButton("Change Language");
		btnChangeLanguage.setForeground(new Color(128, 128, 128));
		layout.putConstraint(SpringLayout.NORTH, btnChangeLanguage, 10, SpringLayout.NORTH, welcomePanel);
		layout.putConstraint(SpringLayout.EAST, btnChangeLanguage, -10, SpringLayout.EAST, welcomePanel);
		btnChangeLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nothing yet.
			}
		});
		welcomePanel.add(btnChangeLanguage);
		
		welcomePanel.repaint();
		welcomePanel.revalidate();
	}
	
	
	
	
	public void startWelcomeView() {
		setUpFrame();
		this.setVisible(true);
	}
	
	public void closeWelcomeView() {
		// Other things to be done ?
		this.setVisible(false);
	}
	
}

package Interface;

import Application.Questions ;

import java.awt.Dialog;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

//import Application.Chat;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;

public class Interface extends JFrame{
	private static JPanel contentPane;
	static Interface frame;
	public int num_page = 1 ;	//Current question page number
	public int num_pageMax = 1 ;	//The question page number max the client answered

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Interface();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public Interface() throws IOException{
		
		//Questions list
		Questions questions = new Questions() ;		//Initialize the table of questions
		int nb_questions = questions.get_nb_questions() ;	//Get the nb of questions
		
		//Global interface (the windows)
		setTitle("CeSort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 600);
        //setLocationRelativeTo();
   
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Welcome Panel
		JPanel welcome_panel = new JPanel();
		welcome_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		welcome_panel.setLayout(null);
		//welcome_panel.setBackground(Color.WHITE); //Fond blanc comme le logo mais le fond par défaut est mieux
		
		//Questions page
		JPanel qus_panel = new JPanel();
		qus_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		qus_panel.setLayout(null);
		
		//Results page
		JPanel results_panel = new JPanel();
		results_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		results_panel.setLayout(null);
		
		
		final CardLayout cardLayout = (CardLayout) contentPane.getLayout();
		

		/****************************** welcome_panel ***************************************/
		/*																					*/
		/************************************************************************************/

		
		//Label title CeSort
		JLabel jcesort = new JLabel("CeSort");
		jcesort.setForeground(Color.DARK_GRAY);
		jcesort.setFont(new Font("Bitstream Charter", Font.BOLD , 60));
		jcesort.setBounds(40, 90, 300, 80);
		welcome_panel.add(jcesort);
		
		//Logo CeSort
		//InputStream logo2 = getClass().getResourceAsStream("Images/Logo-STAR.jpg");
		//ImageIcon logo= new ImageIcon(ImageIO.read(logo2));
		
		FileInputStream logo2 = new FileInputStream("Images/Logo-STAR.jpg");
		ImageIcon logo = new ImageIcon(ImageIO.read(logo2));
		
		JLabel image = new JLabel(logo);
		image.setBounds(650,90,300,80);
        welcome_panel.add(image);
		
		
		//Welcome small title
		JLabel jwelcome = new JLabel("Welcome ");
		jwelcome.setForeground(Color.BLACK);
		jwelcome.setFont(new Font("Bitstream Charter",Font.PLAIN,20));
		jwelcome.setBounds(60,170, 300,100);
		welcome_panel.add(jwelcome);
		
		//Welcome text
		String nl=System.getProperty("line.separator");	//Newline
		String text = new String ("<html>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</html>xx") ; 
		JLabel jtext = new JLabel(text+text);
		jtext.setForeground(Color.BLACK);
		jtext.setFont(new Font("Bitstream Charter",Font.PLAIN,20));
		jtext.setBounds(20,200, 500,200);
		welcome_panel.add(jtext);
		
		//Start Button
		JButton button_start = new JButton("Start");
		button_start.setFont(new Font("Bitstream Charter", Font.BOLD, 25));
		button_start.setBounds(40, 470, 150, 50);
		button_start.setForeground(Color.WHITE);
		button_start.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_start.setBorder(BorderFactory.createLineBorder(Color.black));
		//button_start.setBorder(new EmptyBorder(15, 15, 15, 15));
		welcome_panel.add(button_start);
		
		//Load Button
		JButton button_load = new JButton("Load project");
		button_load.setFont(new Font("Bitstream Charter", Font.BOLD, 25)); 	
		button_load.setBounds(440, 470, 160,50);	
		button_load.setForeground(Color.WHITE);
		button_load.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_load.setBorder(BorderFactory.createLineBorder(Color.black));
		welcome_panel.add(button_load);
		
		
		////////				Banner					//////////
		
		//Banner Droite
    	JLabel jbanner = new JLabel();
		//jbanner.setForeground(Color.DARK_GRAY);
		jbanner.setFont(new Font("Bitstream Charter", Font.BOLD , 70));
		jbanner.setBounds(380,0, 1000, 80);
		jbanner.setBackground(Color.GRAY);
		jbanner.setOpaque(true) ;
		welcome_panel.add(jbanner) ;
		
		//Banner Gauche
		JLabel jbanner2 = new JLabel();
		//jbanner.setForeground(Color.DARK_GRAY);
		jbanner2.setFont(new Font("Bitstream Charter", Font.BOLD , 70));
		jbanner2.setBounds(0,0, 20, 80);
		jbanner2.setBackground(Color.GRAY);
		jbanner2.setOpaque(true) ;
		welcome_panel.add(jbanner2) ;
		
		Border emptyBorder = BorderFactory.createEmptyBorder();	//Empty border
		
		//Load icon
		FileInputStream load2 = new FileInputStream("Images/download.png");
		ImageIcon load = new ImageIcon(ImageIO.read(load2));
		JButton jload = new JButton(load);
		jload.setBounds(20,0,65,50);
		jload.setBackground(Color.GRAY);
		jload.setOpaque(true) ;
		welcome_panel.add(jload);
		jload.setFocusPainted(false);
        
        //Load text
        JLabel jloadt = new JLabel("  Load ");
		jloadt.setForeground(Color.BLACK);
		jloadt.setFont(new Font("Bitstream Charter",Font.BOLD,18));
		jloadt.setBounds(20,50, 60,30);
		jloadt.setBackground(Color.GRAY);
		jloadt.setOpaque(true) ;
		welcome_panel.add(jloadt);
        
        //Settings icon
		FileInputStream settings2 = new FileInputStream("Images/settings.png");
		ImageIcon settings = new ImageIcon(ImageIO.read(settings2));
      	JButton jsettings = new JButton(settings);
      	jsettings.setBounds(80,0,80,50);
    	jsettings.setBackground(Color.GRAY);
		jsettings.setOpaque(true) ;
        welcome_panel.add(jsettings);
        
        //Settings text
        JLabel jsettingst = new JLabel("  Settings");
        jsettingst.setForeground(Color.BLACK);
        jsettingst.setFont(new Font("Bitstream Charter",Font.BOLD,18));
        jsettingst.setBounds(80,50, 80,30);
        jsettingst.setBackground(Color.GRAY);
		jsettingst.setOpaque(true) ;
		welcome_panel.add(jsettingst);
        
        //Language icon
		FileInputStream language2 = new FileInputStream("Images/translate.png");
		ImageIcon language = new ImageIcon(ImageIO.read(language2));
      	JButton jlanguage = new JButton(language);
      	jlanguage.setBounds(160,0,100,50);
    	jlanguage.setBackground(Color.GRAY);
		jlanguage.setOpaque(true) ;
        welcome_panel.add(jlanguage);
        
        //Language text
        JLabel jlanguaget = new JLabel("  Language");
        jlanguaget.setForeground(Color.BLACK);
        jlanguaget.setFont(new Font("Bitstream Charter",Font.BOLD,18));
        jlanguaget.setBounds(160,50,100,30);
        jlanguaget.setBackground(Color.GRAY);
        jlanguaget.setOpaque(true) ;
		welcome_panel.add(jlanguaget);
        
        //Info icon
		FileInputStream info2 = new FileInputStream("Images/information.png");
		ImageIcon info = new ImageIcon(ImageIO.read(info2));
		JButton jinfo = new JButton(info);
      	jinfo.setBounds(260,0,120,50);
    	jinfo.setBackground(Color.GRAY);
		jinfo.setOpaque(true) ;
        welcome_panel.add(jinfo);
        
        //Info text
        JLabel jinfot = new JLabel("  Information");
        jinfot.setForeground(Color.BLACK);
        jinfot.setFont(new Font("Bitstream Charter",Font.BOLD,18));
        jinfot.setBounds(260,50, 120,30);
        jinfot.setBackground(Color.GRAY);
        jinfot.setOpaque(true) ;
		welcome_panel.add(jinfot);
		
		//Question number + The question (Belongs to the questions panel)
		JLabel jquestion = new JLabel("Question 1 : ");
		jquestion.setForeground(Color.DARK_GRAY);
		jquestion.setFont(new Font("Bitstream Charter", Font.BOLD , 18));
		jquestion.setBounds(20, 100, 500, 80);
		qus_panel.add(jquestion) ;

		
		// Start Button
		button_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle("CeSort - Question 1 ");
				num_page = 1 ; 	//Initialize the num_page
				jquestion.setText("Question "+num_page+" : "+questions.get_question(num_page)); //Update the title 
				cardLayout.show(contentPane, "qus");

			}
		});
					
			// inscription
		button_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
						

		/*********************		Questions Panel     	*******************/
		/*															    	*/
		/**********************************************************************/
		
		//Logo CeSort
		FileInputStream icone2 = new FileInputStream("Images/Logo-STAR.jpg");
		ImageIcon icone1 = new ImageIcon(ImageIO.read(icone2));
		Image image1 = icone1.getImage() ;
        Image newimage1 = image1.getScaledInstance(70,40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icone3 = new ImageIcon(newimage1) ;
		JLabel image2 = new JLabel(icone3);
		image2.setBounds(450,20,70,40);
        qus_panel.add(image2);
        
        //Where the answer in insered
		JTextField janswer = new JTextField("");
		janswer.setForeground(Color.DARK_GRAY);
		janswer.setFont(new Font("Bitstream Charter", Font.BOLD , 18));
		janswer.setBounds(20, 200, 500, 80);
		janswer.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(janswer) ;
		
        
        //Previous choices title
		JLabel jprevious = new JLabel("Your previous choices :");
		jprevious.setForeground(Color.DARK_GRAY);
		jprevious.setFont(new Font("Bitstream Charter", Font.BOLD , 20));
		jprevious.setBounds(600, 20, 300, 80);
		qus_panel.add(jprevious) ;
		
		//Scroll panel with the previous questions+answers
		JScrollPane jlist_answers = new JScrollPane() ;
		jlist_answers.setForeground(Color.DARK_GRAY);
		jlist_answers.setFont(new Font("Bitstream Charter", Font.BOLD , 20));
		jlist_answers.setBounds(550, 100, 320, 360);
		qus_panel.add(jlist_answers) ;
		
		//Content of the scroll panel
		JTextArea jta_list_answers = new JTextArea();
		jlist_answers.setViewportView(jta_list_answers);
		jta_list_answers.setLineWrap(true);
		jta_list_answers.setWrapStyleWord(true);
		jta_list_answers.setEditable(false);
		jta_list_answers.setBorder(BorderFactory.createLineBorder(Color.black));
		jta_list_answers.setFont(new Font("Bitstream Charter", Font.PLAIN, 19));

		
		/*
		//Previous choices title
		JLabel jerror3 = new JLabel("TEST xxxxxxxxxxxxxxxxxxxx:");
		jerror3.setForeground(Color.DARK_GRAY);
		jerror3.setFont(new Font("Bitstream Charter", Font.BOLD , 20));
		jerror3.setBounds(600, 100, 300, 80);
		qus_panel.add(jerror3) ; */

		
		// 		Buttons		//
		
		//Home Button
		JButton button_home = new JButton("Home");
		button_home.setFont(new Font("Bitstream Charter", Font.BOLD, 25)); 	
		button_home.setBounds(630, 470, 150,50);	
		button_home.setForeground(Color.WHITE);
		button_home.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_home.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(button_home);
		
		//Home Button Listener
		button_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num_page = 1 ; 	//Initialize the page number				
				frame.setTitle("CeSort "); 			//Initial frame title 
				cardLayout.show(contentPane, "welcome");

			}
		});
		
		//Finish Button
		JButton button_finish = new JButton("Finish");
		button_finish.setFont(new Font("Bitstream Charter", Font.BOLD, 30)); 	
		button_finish.setBounds(360, 470, 150,50);	
		button_finish.setForeground(Color.WHITE);
		button_finish.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_finish.setBorder(BorderFactory.createLineBorder(Color.black));
		button_finish.setVisible(false);
		qus_panel.add(button_finish);
		
		//Next Button
		JButton button_next = new JButton("Next");
		button_next.setFont(new Font("Bitstream Charter", Font.BOLD, 30)); 	
		button_next.setBounds(360, 470, 150,50);	
		button_next.setForeground(Color.WHITE);
		button_next.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_next.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(button_next);
		
		//Previous Button
		JButton button_previous = new JButton("Previous");
		button_previous.setFont(new Font("Bitstream Charter", Font.BOLD, 25)); 	
		button_previous.setBounds(50, 470, 150,50);	
		button_previous.setForeground(Color.WHITE);
		button_previous.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_previous.setBorder(BorderFactory.createLineBorder(Color.black));
		button_previous.setVisible(false) ;		//Initially,it's the first question so there is no previous questionn 
		qus_panel.add(button_previous);

		//Next Button Listener
		button_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the client forgot to answer
				if (janswer.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert an answert!", "Error", 0);
				}
				else {
					//Test if there is a next page 
					if (num_page<(nb_questions-1)) {
						
						String answer = janswer.getText() ;	    //We retrieve the answer 		 
						questions.set_answer(num_page, answer); //We save it
						actualize_answers(jta_list_answers,questions) ;	 				//Actualize the answers	
						
						button_previous.setVisible(true) ;		//As we are not at the first question, we can go back
						num_page ++ ; 							//Increment the num_page
						jquestion.setText("Question "+num_page+" : "+questions.get_question(num_page)); //Update the title 
						frame.setTitle("CeSort - Question "+num_page); //Actualize the title frame
						cardLayout.show(contentPane, "qus");
						
						
						//We actualize the number page max, for the case where we click on previous we have to save the progress with this variable 
						if (num_page>num_pageMax ) {
							num_pageMax = num_page ;
						}
						
					}
					if (num_page==(nb_questions-1)) { //If there is no next question
					
						//We replace the next button with the finish button
						button_next.setVisible(false);	
						button_finish.setVisible(true);	
					}	
					
					//Clear the answer zone or reinsert the answer that was there
					if (num_page<=num_pageMax) {	//The client already answered this question
						janswer.setText(questions.get_answer(num_page));  	//Clear the answer area
						
					}
					else { //It's the first he see this question
						janswer.setText("");  	//Clear the answer area
					}
				}

			}
		});
		
		
		 
		//Previous Button Listener
		button_previous.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
			
			//If the client forgot to answer this question
			if (janswer.getText().isEmpty()) {
				
				//JOptionPane.showMessageDialog(null, "Please insert an answer!", "Error", 1);
				num_page -- ; 	//Decrement the num_page
				num_pageMax -- ;
				jquestion.setText("Question "+num_page+" : "+questions.get_question(num_page)); //Update the number and content of the question
				janswer.setText(questions.get_answer(num_page));  	//The answered that was entered
				frame.setTitle("CeSort - Question "+num_page); //Actualize the title frame
				cardLayout.show(contentPane, "qus"); 
				
				//If the finish button is visible, we make sure that it's the next button instead
				button_next.setVisible(true);	
				button_finish.setVisible(false);
			}
			else {	
				//Test if there is a previous page
				if (num_page>1) {
					
					
					String answer = janswer.getText() ;	    //We retrieve the answer 		 
					questions.set_answer(num_page, answer); //We save it
					actualize_answers(jta_list_answers,questions) ;	 	//Actualize the answers	

					num_page -- ; 	//Decrement the num_page
					jquestion.setText("Question "+num_page+" : "+questions.get_question(num_page)); //Update the number and content of the question
					janswer.setText(questions.get_answer(num_page));  	//Clear the answer area

					frame.setTitle("CeSort - Question "+num_page); //Actualize the title frame
					cardLayout.show(contentPane, "qus"); 
					
					//If the finish button is visible, we make sure that it's the next button instead
					button_next.setVisible(true);	
					button_finish.setVisible(false);
					
				}
				if (num_page==1) { //If we are already at the first page
					//JOptionPane.showMessageDialog(null, "There is no previous question!", "Error", 0);
					button_previous.setVisible(false);	//We can't go back, it's the first page

				}				
				}
			}
		});

		//Finish Button Listener --> Go to the results page
		button_finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num_page = 1 ; 	//Initialiaze the num_page
				frame.setTitle("CeSort - Results "); 			 
				cardLayout.show(contentPane, "results");	

			}
		});



		//Label CeSort title 
		JLabel jcesort1 = new JLabel("CeSort");
		jcesort1.setForeground(Color.DARK_GRAY);
		jcesort1.setFont(new Font("Bitstream Charter", Font.BOLD , 60));
		jcesort1.setBounds(40, 40, 300, 80);
		qus_panel.add(jcesort1) ;
		
		
		//Global
		contentPane.add(welcome_panel, "welcome");
		contentPane.add(qus_panel, "qus");
		contentPane.add(results_panel, "results");
		
		
		


	}
	
	
	public void actualize_answers(JTextArea jta_list_answers, Questions questions) {
		
		String Newline=System.getProperty("line.separator");
		jta_list_answers.setText("") ;
		for (int i=1; i<(num_pageMax+1); i++) {
			jta_list_answers.setText(jta_list_answers.getText()+questions.get_question(i)+Newline+questions.get_answer(i)+Newline+Newline);

		}
		//jta_list_answers.setText(jta_list_answers.getText()+questions.get_question(num_page)+Newline+answer+Newline+Newline);

	}
	
	
	

}
	
	



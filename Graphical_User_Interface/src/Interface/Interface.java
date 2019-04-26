package Interface;

import Application.Questions ;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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

public class Interface extends JFrame{
	private static JPanel contentPane;
	private static JPanel ErrorPane ;
	static Interface frame;
	public int num_page = 0 ;
	
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
		int nb_questions = questions.get_nb_qus() ;	//Get the nb of questions
		
		//Global interface (the windows)
		setTitle("CeSort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Welcome Panel
		JPanel welcome_panel = new JPanel();
		welcome_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		welcome_panel.setLayout(null);
		//welcome_panel.setBackground(Color.WHITE); //Fond blanc comme le logo mais le fond par défaut est mieux
		
		//Question 1 page
		JPanel qus_panel = new JPanel();
		qus_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		qus_panel.setLayout(null);
		
		final CardLayout cardLayout = (CardLayout) contentPane.getLayout();
		

		/****************************** welcome_panel ***************************************/

		
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
		button_load.setBounds(400, 470, 160,50);	
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
				jquestion.setText("Question "+num_page+" : "+questions.get_qu(num_page)); //Update the title 
				cardLayout.show(contentPane, "qus");

			}
		});
					
			// inscription
		button_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
						

		/*********************		Questions 	*******************/
		
		
		//Home Button
		JButton button_home = new JButton("Home");
		button_home.setFont(new Font("Bitstream Charter", Font.BOLD, 25)); 	
		button_home.setBounds(630, 470, 150,50);	
		button_home.setForeground(Color.WHITE);
		button_home.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_home.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(button_home);
		
		//Previous Button
		JButton button_previous = new JButton("Previous");
		button_previous.setFont(new Font("Bitstream Charter", Font.BOLD, 25)); 	
		button_previous.setBounds(50, 470, 150,50);	
		button_previous.setForeground(Color.WHITE);
		button_previous.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_previous.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(button_previous);


		//Next Button
		JButton button_next = new JButton("Next");
		button_next.setFont(new Font("Bitstream Charter", Font.BOLD, 30)); 	
		button_next.setBounds(300, 470, 150,50);	
		button_next.setForeground(Color.WHITE);
		button_next.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.4f));
		button_next.setBorder(BorderFactory.createLineBorder(Color.black));
		qus_panel.add(button_next);


		//Label CeSort title 
		JLabel jcesort1 = new JLabel("CeSort");
		jcesort1.setForeground(Color.DARK_GRAY);
		jcesort1.setFont(new Font("Bitstream Charter", Font.BOLD , 60));
		jcesort1.setBounds(40, 40, 300, 80);
		qus_panel.add(jcesort1) ;
		
		//Logo CeSort
		FileInputStream icone2 = new FileInputStream("Images/Logo-STAR.jpg");
		ImageIcon icone1 = new ImageIcon(ImageIO.read(icone2));
		Image image1 = icone1.getImage() ;
        Image newimage1 = image1.getScaledInstance(70,40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icone3 = new ImageIcon(newimage1) ;
		JLabel image2 = new JLabel(icone3);
		image2.setBounds(450,20,70,40);
        qus_panel.add(image2);
        
        //Previous choices title
		JLabel jprevious = new JLabel("Your previous choices :");
		jprevious.setForeground(Color.DARK_GRAY);
		jprevious.setFont(new Font("Bitstream Charter", Font.BOLD , 20));
		jprevious.setBounds(600, 20, 300, 80);
		qus_panel.add(jprevious) ;
		
		
        
		//Previous Button Listener
		button_previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Test if there is a previous page
				if (num_page>1) {
					num_page -- ; 	//Decrement the num_page
					jquestion.setText("Question "+num_page+" : "+questions.get_qu(num_page)); //Update the number and content of the question
					frame.setTitle("CeSort - Question "+num_page); //Actualize the title frame
					cardLayout.show(contentPane, "qus");
					
				}
				else if (num_page==1) { //If we are already at the first page
					
					//Open a new error windows
					//TO BE CONTINUED
				}
				
			}
		});
		
		//Next Button Listener
		button_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				//Test if there is a next page 
				if (num_page<nb_questions) {
					num_page ++ ; 	//Increment the num_page
					jquestion.setText("Question "+num_page+" : "+questions.get_qu(num_page)); //Update the title 
					frame.setTitle("CeSort - Question "+num_page); //Actualize the title frame
					cardLayout.show(contentPane, "qus");
					
				}
				else { //If we are already at the first page
					
					//Open a new error windows
					//TO BE CONTINUED
				}
				
				

			}
		});
		
		//Home Button Listener
		button_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num_page = 1 ; 	//Increment the num_page
				
				frame.setTitle("CeSort "); 			//Initial frame title 
				cardLayout.show(contentPane, "welcome");

			}
		});
		
		//Global
		contentPane.add(welcome_panel, "welcome");
		contentPane.add(qus_panel, "qus");
		//contentPane.add(panel_modif, "modif");

	}

}
	
	



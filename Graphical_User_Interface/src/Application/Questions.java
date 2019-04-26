package Application;

import java.awt.EventQueue;


public class Questions {
	
	final int SIZE = 15;	//The nb of questions
	//The content of each question
	final String qu1 = "[Question 1 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu2 = "[Question 2 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu3 = "[Question 3 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu4 = "[Question 4 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu5 = "[Question 5 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu6 = "[Question 6 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu7 = "[Question 7 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu8 = "[Question 8 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu9 = "[Question 9 Content xxxxxxxxxxxxxxxxxx]" ;
	final String qu10 = "[Question 10 Content xxxxxxxxxxxxxxxxxx]" ;

	public String tab_qus [] = new String [SIZE] ;	//The question table

	
	public Questions() {
		tab_qus[1] = qu1 ;
		tab_qus[2] = qu2 ;
		tab_qus[3] = qu3 ;
		tab_qus[4] = qu4 ;
		tab_qus[5] = qu5 ;
		tab_qus[6] = qu6 ;
		tab_qus[7] = qu7 ;
		tab_qus[8] = qu8 ;
		tab_qus[9] = qu9 ;
		tab_qus[10] = qu10 ;

	}

	//Get a question content from the question index
	public String get_qu(int index) {
		return tab_qus[index] ;
	}
	
	//Get the number of questions
		public int get_nb_qus() {
			return SIZE ;
		}
		
	public static void main(String[] args) {
		
	}

	
	
}


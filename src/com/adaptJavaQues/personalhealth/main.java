//MAIN CLASS----------------------------ENTRY POINT

package com.adaptJavaQues.personalhealth;

import java.util.Scanner;

public class main {
	
//DECLERATION OF STATIC VARIABLES--------(IF VALUE CHANGES ONCE IT WILL CHANGE THROUGHOUT THE PROGRAM)	
	
	static float Temperature=25;
	static float Weight=0;
	static float Distance = 0.0f;
	static String Watch;
	static String Date;
	static String Curr_mode = "Mode1";
	
//MAIN CLASS----------------------------------------	
	
	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
		
//CREATING OBJECTS OF MODE1 AND MODE2---------------------------
		
		Mode1 m1=new Mode1();
		Mode2 m2=new Mode2();
		
// VARIABLE I IS USED FOR ITERATION OF WHILE LOOP----------------------------
		
		int i=0;
		
		while(i==0) {
			System.out.println("Enter '1' to Display Mode \n" + "Enter '2' to Toggle Mode \n" + "Enter '3' to Edit Values \n" + "Enter '0' to Exit Mode");
			int selection=sc.nextInt();
			
			if (Curr_mode.equals("Mode1")){
			switch(selection) {
			case 1:
				m1.display();
				break;
			case 2:
				m2.toggle();
				Curr_mode="Mode2";
				break;
			case 3:
				m1.edit();
				break;
			case 0:
				i=1;
				System.out.println("Exit!!");
				break;
			}
			
		}
			else {
				switch(selection) {
				case 1:
					m2.display();
					break;
				case 2:
					m1.toggle();
					main.Curr_mode="Mode1";
					break;
				case 3:
					m2.edit();
					break;
				case 0:
					i=1;
					System.out.println("Exit!!");
					break;
				}
			}
	}

}
	}

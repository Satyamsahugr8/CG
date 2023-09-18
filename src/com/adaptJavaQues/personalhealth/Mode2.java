package com.adaptJavaQues.personalhealth;

import java.util.Scanner;

public class Mode2 extends Date_time{
	Scanner sc=new Scanner(System.in);

	public void display() {	
		
		//DATE AND TIME FORMATE FOR MODE 2---------------------------------------
		super.mode_Date("GB");
		super.mode_time("HH:mm aa");
			System.out.println(" __________________________________________________________________________________________");
			System.out.println("|                                                                                          |");
			System.out.println("|   PERSONAL HEALTH ASSISTANT                              EDIT         MODE2 -> MODE1     |");
			System.out.println("|__________________________________________________________________________________________|");
			System.out.println("|                                                                                          |");
			System.out.println("|                                                                DATE                      |");
			System.out.println("|                                                                   "+main.Date+"           ");
			System.out.println("|                                                                                          |");
			System.out.println("|     WATCH                                                                                |");
			System.out.println("|         "+main.Watch+"                                                                    ");
			System.out.println("|                                                                                          |");
			System.out.println("|                                                                WEIGHT                    |");
			System.out.println("|                                                                   "+main.Weight+" Pounds  ");
			System.out.println("|                                                                                          |");
			System.out.println("|     TEMPERATURE                                                                          |");
			System.out.println("|         "+main.Temperature +" F                                                           ");
			System.out.println("|                                                                                          |");
			System.out.println("|                                                                DISTANCE                  |");
			System.out.println("|                                                                   "+main.Distance+" Miles ");
			System.out.println("|                                                                                          |");
			System.out.println("|__________________________________________________________________________________________|");
		}
	
	public void toggle() {
		
		//FORMULA FOR CELCIUS TO FARENHITE CONVERSION---------------------------------
		main.Temperature=(float) ((main.Temperature*1.8)+32);
		
		//FORMULA FOR KILOGRAM TO POUNDS CONVERSION---------------------------------

		main.Weight=(float) ((main.Weight)*2.205);
		
		//FORMULA FOR KILOMETER TO MILES CONVERSION---------------------------------

		main.Distance=(float) ((main.Distance)*0.621);
		this.display();
	}

	public void edit() {
		System.out.println("Enter '1' to change temperature \n" + "Enter '2' to change weight \n" + "Enter '3' to change distance \n");
		int input2=sc.nextInt();
		
		if (input2==1) {
			System.out.println("Enter Temperature in Farenhite");
			Float temp2=sc.nextFloat();
			//SETTING VALUE OF TEMPERATURE ACCORDING TO USER----------------------------------------
			main.Temperature=temp2;
		}
		else if(input2==2) {
			
			//TRY - CATCH BLOCK IS USED FOR HANNDEL THE EXCEPTION--------------------------------- 
			try {
			System.out.println("Enter Weight in Pounds");
			Float wei2=sc.nextFloat();
			if (wei2>=0) {
				//SETTING VALUE OF WEIGHT ACCORDING TO USER----------------------------------------
			main.Weight=wei2;
			}
			else {
				throw new Exception("Weight is never Negative , Try Again!");
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			try {
			System.out.println("Enter Distance in Miles");
			Float dist2=sc.nextFloat();
			if(dist2>=0) {
				//SETTING VALUE OF DISTANCE ACCORDING TO USER----------------------------------------
			main.Distance=dist2;
			}
			else {
				throw new Exception("Distance is never Negative , Try Again!");
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
	}
		
}}

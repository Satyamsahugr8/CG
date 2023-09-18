package com.adaptJavaQues.personalhealth;

import java.util.Scanner;

public class Mode1 extends Date_time{
	Scanner sc=new Scanner(System.in);
	
//DISPLAY METHOD FOR DISPLAYING RESULT OF MODE1------------------------------------------	
	
	public void display() {
		
		//DATE AND TIME FORMATE FOR MODE 1------------------------------------------
		super.mode_Date("Us");
		super.mode_time("hh:mm aa");
		System.out.println(" __________________________________________________________________________________________");
		System.out.println("|                                                                                          |");
		System.out.println("|   PERSONAL HEALTH ASSISTANT                              EDIT         MODE1 -> MODE2     |");
		System.out.println("|__________________________________________________________________________________________|");
		System.out.println("|                                                                                          |");
		System.out.println("|                                                                DATE                      |");
		System.out.println("|                                                                   "+main.Date+"           ");
		System.out.println("|                                                                                          |");
		System.out.println("|     WATCH                                                                                |");
		System.out.println("|         "+main.Watch+"                                                                    ");
    	System.out.println("|                                                                                          |");
    	System.out.println("|                                                                WEIGHT                    |");
    	System.out.println("|                                                                   "+main.Weight+" KG      ");
    	System.out.println("|                                                                                          |");
    	System.out.println("|     TEMPERATURE                                                                          |");
    	System.out.println("|         "+main.Temperature+" C                                                            ");
    	System.out.println("|                                                                                          |");
    	System.out.println("|                                                                DISTANCE                  |");
    	System.out.println("|                                                                   "+main.Distance+" KM    ");
    	System.out.println("|                                                                                          |");
    	System.out.println("|__________________________________________________________________________________________|");
		}
	
	public void toggle() {
		main.Temperature=(float)((main.Temperature-32)*5)/9;
		main.Weight=(float) ((main.Weight)*0.454);
		main.Distance=(float) ((main.Distance)*1.609);
		
		this.display();
		}
	
	public void edit() {
		System.out.println("Enter '1' to change temperature \n" + "Enter '2' to change weight \n" + "Enter '3' to change distance \n");
		int input=sc.nextInt();
		
		if (input==1) {
			System.out.println("Enter Temperature in Celcius");
			Float temp=sc.nextFloat();
			//SETTING VALUE OF TEMPERATURE ACCORDING TO USER----------------------------------------
			main.Temperature=temp;
		}
		else if(input==2) {
			
			//TRY - CATCH BLOCK IS USED FOR HANNDEL THE EXCEPTION--------------------------------- 
			try {
			System.out.println("Enter Weight in Kilogram");
			Float wei=sc.nextFloat();
			if (wei>=0) {
				//SETTING VALUE OF WEIGHT ACCORDING TO USER----------------------------------------
			main.Weight=wei;
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
			System.out.println("Enter Distance in Kilometer");
			Float dist=sc.nextFloat();
			if(dist>=0) {
				//SETTING VALUE OF DISTANCE ACCORDING TO USER----------------------------------------
			main.Distance=dist;
			}
			else {
				throw new Exception("Distance is never Negative , Try Again!");
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
	}
		
	}
		
		}	
	


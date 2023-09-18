package com.adaptJavaQues.personalhealth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Date_time {
	
	//METHOD FOR DESPLAYING DATE ACCORDING TO SYSTEM------------------------------------- 
	public void mode_Date(String pattern) {
		Locale local=new Locale("en",pattern);
		DateFormat dateformat=DateFormat.getDateInstance(DateFormat.DEFAULT,local);
		String date=dateformat.format(new Date());
		main.Date=date;	
	}
	
	//METHOD FOR DISPLAYING TIME ACCORDING TO SYSTEM------------------------------------
	public void mode_time(String pattern) {
		SimpleDateFormat formatDate=new SimpleDateFormat(pattern);
		Date date=new Date();
		main.Watch=formatDate.format(date);
	}
}

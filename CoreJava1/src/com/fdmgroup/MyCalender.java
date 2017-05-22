package com.fdmgroup;

import java.util.Calendar;

public class MyCalender {
	
	Calendar cal = Calendar.getInstance();
	public String getToday(){
		 return cal.getTime().toString();
	}
	
	public String getTodayDateOnly(){
		String date =  cal.get(Calendar.YEAR) + "/" +(cal.get(Calendar.MONTH)+1) + "/" +cal.get(Calendar.DATE) ;
		return cal.getTime().toString();
	}

	public String getTodayTimeOnly(){
		String time =  cal.get(Calendar.HOUR) + "/" +(cal.get(Calendar.MINUTE)+1) + "/" +cal.get(Calendar.SECOND) ;
		return time;
	}
	
	public String getTodayDateAndTime(){
		String time =  getTodayTimeOnly();
		String date =  getTodayDateOnly();
		return date + " "+ time;
	}
}
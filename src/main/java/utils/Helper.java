package utils;

import java.sql.Timestamp;
import java.util.Date;

public class Helper {

	public static String getDateTime() {
		
		Date date = new Date();  
        
		Timestamp ts=new Timestamp(date.getTime());  
        
        return ts.toString();
		
	}
	
	public static String concatStartTime(String date) {
		
		return date + " 00:00:00.000";
		
	}
	
	public static String concatEndTime(String date) {
		
		return date + " 23:59:59.999";
		
	}
	
	public static String checkIfEndDateIsNull(String endDate) {
		if (endDate == null) {
			endDate = Helper.getDateTime();
			endDate = Helper.concatEndTime(endDate);
		} else {
			endDate = Helper.concatEndTime(endDate);
		}

		return endDate;
		
	}

}

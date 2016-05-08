package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static int getWeekNo(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.getWeekNo(DateUtils.parseStringToDate("2016/04/17", "yyyy/MM/dd")));
		
		System.out.println(parseDateToString(getFirstDayDateByWeekNoAndYear(getWeekNo(parseYYYYMMDDStringToDate("2016/04/17")),2016),"yyyy/MM/dd"));
		
		System.out.println( parseDateToString(getLastDayDateByWeekNoAndYear(16, 2016),"yyyy/MM/dd"));
	}
	
	public static Date parseYYYYMMDDStringToDate(String dateString) {
		return DateUtils.parseStringToDate(dateString, "yyyy/MM/dd");
	}
	
	public static Date parseStringToDate(String dateString, String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int getYear(String dateString,String format) {
		Date date = DateUtils.parseStringToDate(dateString, format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static Date getFirstDayDateByWeekNoAndYear(int weekNo, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.WEEK_OF_YEAR, weekNo);
		calendar.set(Calendar.YEAR, year);

		// Now get the first day of week.
		Date date = calendar.getTime();
		
		return date;
	}
	
	public static Date getLastDayDateByWeekNoAndYear(int weekNo, int year) {
		Date date = getFirstDayDateByWeekNoAndYear(weekNo,year);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);
		
		return cal.getTime();
	}
	
	public static String parseDateToString(Date date, String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
}

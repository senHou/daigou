package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

	public final static int DASH = 0;
	public final static int NONE = 1;
	public final static int SLASH = 2;
	
	public static int getWeekNo(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		return week;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	public static void main(String[] args) {
		// System.out.println(DateUtils.getWeekNo(DateUtils.parseStringToDate("2016/04/17",
		// "yyyy/MM/dd")));
		//
		// System.out.println(parseDateToString(getFirstDayDateByWeekNoAndYear(getWeekNo(parseYYYYMMDDStringToDate("2016/04/17")),2016),"yyyy/MM/dd"));
		//
		// System.out.println(
		// parseDateToString(getLastDayDateByWeekNoAndYear(16,
		// 2016),"yyyy/MM/dd"));

		System.out.println(Arrays.toString(getPreviousMondayDate(5).toArray()));
	}

	public static Date parseYYYYMMDDStringToDate(String dateString) {
		return DateUtils.parseStringToDate(dateString, "yyyy/MM/dd");
	}

	public static Date parseStringToDate(String dateString, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int getYear(String dateString, String format) {
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

	public static Date getMondayDateByWeekNoAndYear(int weekNo, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.WEEK_OF_YEAR, weekNo);
		calendar.set(Calendar.YEAR, year);

		// Now get the first day of week.
		Date date = calendar.getTime();

		return date;
	}

	public static Date getSundayDateByWeekNoAndYear(int weekNo, int year) {
		Date date = getMondayDateByWeekNoAndYear(weekNo, year);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);

		return cal.getTime();
	}

	public static String parseDateToString(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static List<Date> getPreviousMondayDate(int numOfWeek) {
		List<Date> dates = new ArrayList<Date>();
		Date date = new Date();
		for (int i = numOfWeek-1; i > 0; i--) {
			Date tmp = addDays(date, i * -7);
			int weekNo = getWeekNo(tmp);
			int year = getYear(tmp);
			dates.add(getMondayDateByWeekNoAndYear(weekNo, year));
		}

		dates.add(getMondayDateByWeekNoAndYear(getWeekNo(date), getYear(date)));
		return dates;
	}

	public static List<Date> getPreviousSundayDate(int numOfWeek) {
		List<Date> dates = new ArrayList<Date>();
		Date date = new Date();
		for (int i = numOfWeek-1; i > 0; i--) {
			Date tmp = addDays(date, i * -7);
			int weekNo = getWeekNo(tmp);
			int year = getYear(tmp);
			dates.add(getSundayDateByWeekNoAndYear(weekNo, year));
		}

		dates.add(getSundayDateByWeekNoAndYear(getWeekNo(date), getYear(date)));
		return dates;
	}
}

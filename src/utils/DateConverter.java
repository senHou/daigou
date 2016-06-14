package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter {

	private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public Object convertFromString(Map arg0, String[] strings, Class arg2) {
		if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
			return null;
		}

		try {
			return DATETIME_FORMAT.parse(strings[0]);
		} catch (Exception e) {
			throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);
		}
	}

	@Override
	public String convertToString(Map arg0, Object date) {
		if (date != null && date instanceof Date) {
			return DATETIME_FORMAT.format(date);
		} else {
			return null;
		}
	}

}

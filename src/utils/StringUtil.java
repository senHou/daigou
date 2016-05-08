package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isEmpty(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmpty(String[] s) {
		boolean isEmpty = true;
		if (s != null && s.length > 0) {
			for (int i = 0, l = s.length; i < l; i++) {
				if (!isEmpty(s[i])) {
					isEmpty = false;
				}
			}
		}
		return isEmpty;
	}

	/**
	 * Replaces double quotes with a
	 * 
	 * <pre>
	 * &quot;
	 * </pre>
	 * 
	 * entity.
	 * 
	 * @param source
	 *            The source String.
	 * @return The reformatted String. If no quotes are found, the original
	 *         String.
	 */
	public static String formatHTMLQuotes(String source) {
		if (source == null)
			return null;
		int idx = source.indexOf("\"");
		if (idx != -1) {
			StringBuffer sb = new StringBuffer(source);
			int len = sb.length();
			for (int i = idx; i < (len - 1); i++) {
				char c = sb.charAt(i);
				// check for the String
				if (c == '\"') {
					sb.delete(i, i + 1);
					sb.insert(i, "&quot;");
					i += 6;
				}
				len = sb.length();
			}
			return sb.toString();
		} else {
			return source;
		}
	}

	/**
	 * Escapes a String for including in JavaScript. Essentially, this method
	 * will double single quotes, double quotes, and back slashes.
	 * 
	 * @param string
	 *            The String to escape.
	 * @return The escaped String.
	 */
	public static String escapeForJavaScript(String string) {

		string = StringUtil.replace(string, "\\", "\\\\"); // backslashes
		string = StringUtil.replace(string, "'", "\\\'"); // single quotes
		string = StringUtil.replace(string, "\"", "\\\""); // double quotes
		return string;
	}

	/**
	 * Returns the original String in Uppercase, or an empty String if the
	 * original String was <tt>null</tt>.
	 * 
	 * @param s
	 *            The original String.
	 * @param The
	 *            uppercased version, or an empty String if the original String
	 *            was <tt>null</tt>
	 */
	public static String toUppercase(String s) {
		return s == null ? null : s.toUpperCase();
	}

	/**
	 * Pads the specified <tt>String</tt> with blanks for the specified number
	 * of places.
	 * 
	 * @param value
	 *            The value to pad with blanks.
	 * @param size
	 *            The number of maximum number of characters.
	 */
	public static String rightPadBlanks(String value, int length) {
		if (value == null) {
			return value;
		}

		if (value.length() < length) {
			StringBuffer sb = new StringBuffer(value);
			for (int i = 0; i < length - value.length(); i++) {
				sb.append(" ");
			}
			return sb.toString();
		} else {
			return value;
		}
	}

	/**
	 * Pads the specified <code>String</code> with zeroes for the specified
	 * number of places.
	 * 
	 * @param value
	 *            The value to pad.
	 * @param size
	 *            The number of maximum number of characters.
	 */
	public static String leftPadBlanks(String value, int size) {
		if (value.length() > size) {
			value = value.substring(0, size);
		}
		StringBuffer sb = new StringBuffer(value);
		int len = value.length();
		for (int i = len; i < size; i++) {
			sb.insert(0, " ");
		}
		return sb.toString();
	}

	public static String rightPadZeroes(int length, String value) {
		if (value == null) {
			return value;
		}

		StringBuffer zeroes = new StringBuffer(length);
		for (int i = 0; i < (length - value.length()); i++) {
			zeroes.append("0");
		}
		return value + zeroes.toString();
	}

	/**
	 * Pads the specified <code>String</code> with zeroes for the specified
	 * number of places.
	 * 
	 * @param value
	 *            The value to pad.
	 * @param size
	 *            The number of places.
	 */
	public static String leftPadZeroes(String value, int size) {
		if (value.length() > size) {
			value = value.substring(0, size);
		}
		StringBuffer sb = new StringBuffer(value);
		int len = value.length();
		for (int i = len; i < size; i++) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}

	public static String removeLeadingZeroes(String value) {
		String theValue = value;
		String regex = "^0*";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(theValue);

		theValue = m.replaceAll("");

		return theValue;
	}

	/**
	 * Truncates a String so that its length is not more than a specified
	 * amount. If the string is already shorter than that length, no action is
	 * taken.
	 * 
	 * @param value
	 *            The value to be truncated
	 * @param newLength
	 *            The maximum length of the String to be returned
	 * @return String
	 */
	public static String truncate(String value, int newLength) {
		if (value.length() > newLength) {
			value = value.substring(0, newLength);
		}
		return value;
	}

	/**
	 * Trims non-null String objects.
	 * 
	 * @param value
	 * @return
	 */
	public static String trim(String value) {
		return value == null ? value : value.trim();
	}

	/**
	 * Pads the specified <tt>String</tt> with spaces
	 * 
	 * <pre>
	 * &nbsp;
	 * </pre>
	 * 
	 * for the specified number of places.
	 * 
	 * @param value
	 *            The value to pad with spaces.
	 * @param size
	 *            The number of maximum number of characters.
	 */
	public static String rightPadHTMLSpaces(String value, int length) {
		if (value == null) {
			return value;
		}

		if (value.length() < length) {
			StringBuffer sb = new StringBuffer(value);
			for (int i = 0; i < length - value.length(); i++) {
				sb.append("&nbsp;");
			}
			return sb.toString();
		} else {
			return value;
		}
	}

	/**
	 * Reformats a 'word' into a description, using the following rules. Check
	 * for upper case letters and digits within the word. Use this to determine
	 * how to split the 'word' (e.g. "retailerId") into multiple words (e.g.
	 * "Retailer Id"). Digits are used to determine word-brteaks as well. So,
	 * "item01" becomes "Item 01".
	 * 
	 * @param word
	 * @return
	 */
	public static String formatAsDescription(String word) {
		if (StringUtil.isEmpty(word)) {
			return "";
		}

		StringBuffer buf = new StringBuffer(word.substring(0, 1).toUpperCase());
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isUpperCase(c)) {
				buf.append(" ");
			} else if (Character.isDigit(c)) {
				// If digit, preceded by non-digit, leave a space
				if (!Character.isDigit(word.charAt(i - 1))) {
					buf.append(" ");
				}
			}
			buf.append(c);
		}
		return buf.toString();
	}

	/**
	 * Replace a string fragment with another.
	 * 
	 * @param s
	 *            The original string.
	 * @param one
	 *            The fragment to replace.
	 * @param another
	 *            The replacement fragment.
	 * @return
	 */
	public static String replace(String s, String one, String another) {
		if (s.equals("")) {
			return "";
		}
		String res = "";
		int i = s.indexOf(one, 0);
		int lastpos = 0;
		while (i != -1) {
			res += s.substring(lastpos, i) + another;
			lastpos = i + one.length();
			i = s.indexOf(one, lastpos);
		}
		res += s.substring(lastpos);
		return res;
	}

	/**
	 * Used to parse Strings like "ABC, XYZ, GJH" into a List Assumed delimiters
	 * are: Space, comma, tab and new-line
	 */
	public static List convertDelimitedStringToList(String commaDelimitedString, int maxStringLength)
			throws IllegalArgumentException {
		List theList = new ArrayList();
		StringTokenizer st = new StringTokenizer(commaDelimitedString, ", \t\n\r");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (!StringUtil.isEmpty(s) && !theList.contains(StringUtil.trim(s))) {
				if (s.length() > maxStringLength) {
					throw new IllegalArgumentException("Sub-String exceeded max-length:" + maxStringLength);
				}
				theList.add(StringUtil.trim(s));
			}
		}
		return theList;
	}

	/**
	 * Takes string s and changes the first character to UPPER case
	 * 
	 * @param s
	 * @return
	 */
	public static String uppercaseFirstCharacter(String s) {
		if (isEmpty(s)) {
			return s;
		} else {
			try {
				String s2 = s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase());
				return s2;
			} catch (RuntimeException e) {
				return s;
			}
		}
	}

	/**
	 * Replaces special characters with unicode index
	 * 
	 * @param s
	 * @return
	 */
	public static String escapeSpecialCharacters(String s) {
		if (isEmpty(s)) {
			return s;
		} else {
			// Smart Commma
			try {
				s = s.replaceAll("\u201A", ",");
			} catch (Throwable e) {
			}

			// Left Double Smart Quote
			try {
				s = s.replaceAll("\u201C", "\"\"");
			} catch (Throwable e) {
			}

			// Right Double Smart Quote
			try {
				s = s.replaceAll("\u201D", "\"\"");
			} catch (Throwable e) {
			}

			// Double Low Smart Quotation marks
			try {
				s = s.replaceAll("\u201E", "\"\"");
			} catch (Throwable e) {
			}

			// Left Single Smart Quote
			try {
				s = s.replaceAll("\u2018", "\'");
			} catch (Throwable e) {
			}

			// Right Single Smart Quote
			try {
				s = s.replaceAll("\u2019", "\'");
			} catch (Throwable e) {
			}

			// 1/3
			try {
				s = s.replaceAll("\u2153", "1/3");
			} catch (Throwable e) {
			}

			// 2/3
			try {
				s = s.replaceAll("\u2154", "2/3");
			} catch (Throwable e) {
			}

			// 1/2
			try {
				s = s.replaceAll("\u00BD", "1/2");
			} catch (Throwable e) {
			}

			// 1/4
			try {
				s = s.replaceAll("\u00BC", "1/4");
			} catch (Throwable e) {
			}

			// 3/4
			try {
				s = s.replaceAll("\u00BE", "3/4");
			} catch (Throwable e) {
			}

			return s;
		}
	}
}

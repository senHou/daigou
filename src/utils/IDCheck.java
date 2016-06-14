package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDCheck {

	private static Map<String, String> checkDigitMap = new HashMap<String, String>();
	private static List<Integer> multiple = new ArrayList<Integer>();

	static {
		checkDigitMap.put("0", "1");
		checkDigitMap.put("1", "0");
		checkDigitMap.put("2", "X");
		checkDigitMap.put("3", "9");
		checkDigitMap.put("4", "8");
		checkDigitMap.put("5", "7");
		checkDigitMap.put("6", "6");
		checkDigitMap.put("7", "5");
		checkDigitMap.put("8", "4");
		checkDigitMap.put("9", "3");
		checkDigitMap.put("10", "2");

		multiple.add(7);
		multiple.add(9);
		multiple.add(10);
		multiple.add(5);
		multiple.add(8);
		multiple.add(4);
		multiple.add(2);
		multiple.add(1);
		multiple.add(6);
		multiple.add(3);
		multiple.add(7);
		multiple.add(9);
		multiple.add(10);
		multiple.add(5);
		multiple.add(8);
		multiple.add(4);
		multiple.add(2);
	}

	public static boolean check(String id) {
		if (id.length() != 18) {
			return false;
		}
		String lastDigit = id.substring(id.length() - 1);

		if (calculateLastDigit(id.substring(0, 17)).equals(lastDigit)) {
			return true;
		} else {
			return false;
		}
	}

	private static String calculateLastDigit(String id) {
		int sum = 0;
		if (id.length() != 17) {
			return null;
		}
		for (int i = 0; i < id.length(); i++) {
			sum += Character.getNumericValue(id.charAt(i)) * multiple.get(i);
		}

		return checkDigitMap.get(String.valueOf(sum % 11));
	}

	public static void main(String[] args) {
		System.out.println(IDCheck.calculateLastDigit("41010519871103012"));
		System.out.println(IDCheck.check("410105198711030127"));
	}
}

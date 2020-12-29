package is.ru.stringcalculator;

public class StringCalculator {

	public static int add(String text) {
		if (text.equals("") || text.equals("null")) {
			return 0;
		} else {
			String delimiter = ",";
			if (text.matches("//(.*)\n(.*)")) {
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}

			String numbersList[] = text.split(delimiter + "|\n");
			return sum(numbersList);
		}
	}


	private static int sum(String[] numbers) {
		int totalSum = 0;
		String ifNegativeString = "";

		for (String number : numbers) {
			if (Integer.parseInt(number) < 0) {
				if (ifNegativeString.equals(""))
					ifNegativeString = number;
				else
					ifNegativeString += ("," + number);
			}
			if (Integer.parseInt(number) < 1000)
				totalSum += Integer.parseInt(number);
		}

		if (!ifNegativeString.equals("")) {
			throw new IllegalArgumentException("Negatives not allowed: " + ifNegativeString);
		}

		return totalSum;
	}
}
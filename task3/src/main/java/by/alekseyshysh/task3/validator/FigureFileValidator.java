package by.alekseyshysh.task3.validator;

import java.util.regex.Pattern;

public class FigureFileValidator {

	private static final String CORRECT_REGULAR_PYRAMID = "^\\w+:(-?\\d+\\.-?\\d+,){2}(-?\\d+\\.-?\\d+);\\d+;\\d+.\\d+;-?\\d+.\\d+$";
	private static final String CORRECT_REGULAR_POLYGON = "^\\w+:(-?\\d+\\.-?\\d+,){2}(-?\\d+\\.-?\\d+);\\d+;\\d+.\\d+$";
	
	private FigureFileValidator() {
	}

	public static boolean validateString(String line) {
		boolean resultRegularPyramid = Pattern.matches(CORRECT_REGULAR_PYRAMID, line);
		boolean resultRegularPolygon = Pattern.matches(CORRECT_REGULAR_POLYGON, line);
		return resultRegularPyramid || resultRegularPolygon;
	}
}

package by.alekseyshysh.task3.validator;

import by.alekseyshysh.task3.entity.RegularPolygon;

public class FigureShapeValidator {

	private static final int SIDES_COUNT = 3;
	
	private FigureShapeValidator() {
	}

	public static boolean isRegularPyramidCorrect(RegularPolygon polygon, double height) {
		boolean result = polygon.getSideCount() >= SIDES_COUNT
				&& polygon.getSideLength() > 0 
				&& (height > 0 || height < 0);
		return result;
	}
}

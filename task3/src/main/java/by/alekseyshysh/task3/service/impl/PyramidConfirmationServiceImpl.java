package by.alekseyshysh.task3.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.PyramidConfirmationService;
import by.alekseyshysh.task3.validator.FigureShapeValidator;

public class PyramidConfirmationServiceImpl implements PyramidConfirmationService {

	private static Logger logger = LogManager.getRootLogger();

	/*
	 * Для задач 4-8. Cекущие плоскости, фигуры и основания следует ориентировать в
	 * пространстве параллельно осям и плоскостям координат,чтобы формулы вычисления
	 * сечений и параметров фигур не были слишком сложными.
	 */

	// switch here for future extensibility
	@Override
	public boolean confirmShapeType(Figure figure, String figureName) {
		// RegularPolygon.sideCount >= 3
		// RegularPolygon.sideLength > 0
		// apex > 0 | apex < 0
		boolean result = false;
		if (figure != null) {
			String className = figure.getClass().getName();
			switch (className) {
			case ("RegularPyramid"):
				if (className.equals(figureName)) {
					RegularPyramid pyramid = (RegularPyramid) figure;
					RegularPolygon base = pyramid.getBase();
					double height = pyramid.getHeight();
					result = FigureShapeValidator.isRegularPyramidCorrect(base, height);
				}
				break;
			default:
				logger.log(Level.DEBUG, "No such figure: {}", className);
				break;
			}
		}
		return result;
	}

	// because we consider base parallel to plane:
	@Override
	public boolean confirmPyramidBaseOnCordinatePlane(RegularPyramid pyramid) {
		boolean result = false;
		if (pyramid != null) {
			Point point = pyramid.getCenter();
			if (point.getX() == 0 || point.getY() == 0 || point.getZ() == 0) {
				result = true;
			}
		}
		return result;
	}
}

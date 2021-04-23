package by.alekseyshysh.task3.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.RegularFigureConfirmationService;
import by.alekseyshysh.task3.validator.FigureShapeValidator;

public class RegularFigureConfirmationServiceImpl implements RegularFigureConfirmationService{

	private static Logger logger = LogManager.getRootLogger();

	@Override
	public boolean confirmShapeType(AbstractFigure abstractFigure, String figureName) {
		boolean result = false;
		if (abstractFigure != null) {
			String className = abstractFigure.getClass().getName();
			switch (className) {
			case ("RegularPyramid"):
				if (className.equals(figureName)) {
					RegularPyramid pyramid = (RegularPyramid) abstractFigure;
					RegularPolygon base = pyramid.getBase();
					double height = pyramid.getHeight();
					result = FigureShapeValidator.isRegularPyramidCorrect(base, height);
				}
				break;
			case ("RegularPolygon"):
				break;
			default:
				logger.log(Level.DEBUG, "No such figure: {}", className);
				break;
			}
		}
		return result;
	}

}

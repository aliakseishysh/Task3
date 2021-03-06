package by.alekseyshysh.task3.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.FigureConfirmationService;
import by.alekseyshysh.task3.validator.FigureShapeValidator;

public class FigureConfirmationServiceImpl implements FigureConfirmationService{

	private static Logger logger = LogManager.getRootLogger();

	@Override
	public boolean confirmShapeType(AbstractFigure abstractFigure, String figureName) {
		boolean result = false;
		if (abstractFigure != null) {
			String abstractFigureName = abstractFigure.getName();
			switch (abstractFigureName) {
			case (Figure.REGULAR_PYRAMID):
				if (abstractFigureName.equals(figureName)) {
					RegularPyramid pyramid = (RegularPyramid) abstractFigure;
					RegularPolygon base = pyramid.getBase();
					double height = pyramid.getHeight();
					result = FigureShapeValidator.isRegularPyramidCorrect(base, height);
				}
				break;
			case (Figure.REGULAR_POLYGON):
				if (abstractFigureName.equals(figureName)) {
					result = true;
				}
				break;
			default:
				logger.log(Level.DEBUG, "No such figure: {}", abstractFigureName);
				break;
			}
		}
		return result;
	}

}

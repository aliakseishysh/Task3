package by.alekseyshysh.task3.specification.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.RegularPolygonCalculationService;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPolygonCalculationServiceImpl;
import by.alekseyshysh.task3.service.impl.RegularPyramidCalculationServiceImpl;
import by.alekseyshysh.task3.specification.Specification;

public class PerimeterSpecification implements Specification {

	private static Logger logger = LogManager.getRootLogger();

	private double minPerimeter;
	private double maxPerimeter;

	public PerimeterSpecification(double minPerimeter, double maxPerimeter) {
		this.minPerimeter = minPerimeter;
		this.maxPerimeter = maxPerimeter;
	}

	@Override
	public boolean specify(AbstractFigure figure) {
		String figureName = figure.getName();
		boolean result = false;
		switch (figureName) {
		case Figure.REGULAR_POLYGON:
			RegularPolygon polygon = (RegularPolygon) figure;
			RegularPolygonCalculationService calculation = new RegularPolygonCalculationServiceImpl();
			double calculatedPolygonPerimeter = calculation.calculatePerimeter(polygon);
			result = minPerimeter <= calculatedPolygonPerimeter && calculatedPolygonPerimeter <= maxPerimeter;
			break;
		case Figure.REGULAR_PYRAMID:
			RegularPyramid pyramid = (RegularPyramid) figure;
			RegularPyramidCalculationService pyramidCalculation = new RegularPyramidCalculationServiceImpl();
			double calculatedPyramidPerimeter = pyramidCalculation.calculatePerimeter(pyramid);
			result = minPerimeter <= calculatedPyramidPerimeter && calculatedPyramidPerimeter <= maxPerimeter;
			break;
		default:
			logger.log(Level.ERROR, "No such action for figure: {}", figureName);
			break;
		}
		return result;
	}
}

package by.alekseyshysh.task3.repository.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPolygonParameter;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.entity.RegularPyramidParameter;
import by.alekseyshysh.task3.entity.Warehouse;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.repository.Specification;
import by.alekseyshysh.task3.service.RegularPolygonCalculationService;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPolygonCalculationServiceImpl;
import by.alekseyshysh.task3.service.impl.RegularPyramidCalculationServiceImpl;

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
		String className = figure.getClass().getSimpleName();
		boolean result = false;
		switch (className) {
		case "RegularPolygon":
			RegularPolygon polygon = (RegularPolygon) figure;
			RegularPolygonCalculationService calculation = new RegularPolygonCalculationServiceImpl();
			double calculatedPolygonPerimeter = calculation.calculatePerimeter(polygon);
			result = minPerimeter <= calculatedPolygonPerimeter & calculatedPolygonPerimeter <= maxPerimeter;
			break;
		case "RegularPyramid":
			RegularPyramid pyramid = (RegularPyramid) figure;
			RegularPyramidCalculationService pyramidCalculation = new RegularPyramidCalculationServiceImpl();
			double calculatedPyramidPerimeter = pyramidCalculation.calculatePerimeter(pyramid);
			result = minPerimeter <= calculatedPyramidPerimeter & calculatedPyramidPerimeter <= maxPerimeter;
			break;
		default:
			logger.log(Level.ERROR, "No such action for figure: {}", className);
			break;
		}
		return result;
	}

	@Override
	public boolean specifyFromWarehouse(AbstractFigure figure) {
		Warehouse warehouse = Warehouse.getInstance();
		String className = figure.getClass().getSimpleName();
		long id = -1;
		boolean result = false;
		switch (className) {
		case "RegularPolygon":
			RegularPolygon polygon = (RegularPolygon) figure;
			RegularPolygonParameter polygonParameter;
			try {
				polygon.getId();
				polygonParameter = warehouse.getRegularPolygonParameter(id);
				double polygonPerimeter = polygonParameter.getPerimeter();
				result = minPerimeter <= polygonPerimeter & polygonPerimeter <= maxPerimeter;
			} catch (FiguresException e) {
				logger.log(Level.ERROR, "Can not get figure by id: {}", id, e);
			}
			break;
		case "RegularPyramid":
			RegularPyramid pyramid = (RegularPyramid) figure;
			RegularPyramidParameter pyramidParameter;
			try {
				pyramid.getId();
				pyramidParameter = warehouse.getRegularPyramidParameter(id);
				double pyramidPerimeter = pyramidParameter.getPerimeter();
				result = minPerimeter <= pyramidPerimeter & pyramidPerimeter <= maxPerimeter;
			} catch (FiguresException e) {
				logger.log(Level.ERROR, "Can not get figure by id: {}", id, e);
			}
			break;
		default:
			logger.log(Level.ERROR, "No such action for figure: {}", className);
			break;
		}
		return result;
	}
}

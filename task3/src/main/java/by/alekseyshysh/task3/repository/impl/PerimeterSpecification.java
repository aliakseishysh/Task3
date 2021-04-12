package by.alekseyshysh.task3.repository.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.repository.Specification;
import by.alekseyshysh.task3.warehouse.RegularPolygonParameter;
import by.alekseyshysh.task3.warehouse.RegularPyramidParameter;
import by.alekseyshysh.task3.warehouse.Warehouse;

public class PerimeterSpecification implements Specification {
	
	private static Logger logger = LogManager.getRootLogger();
 
	private double perimeter;
	
	public PerimeterSpecification(double perimeter) {
		this.perimeter = perimeter;
	}
	
	@Override
	public boolean specify(AbstractFigure figure) {
		Warehouse warehouse = Warehouse.getInstance();
		String className = figure.getClass().getName();
		long id = -1;
		boolean result = false;
		switch(className) {
			case "RegularPolygon":
				RegularPolygon polygon = (RegularPolygon) figure;
				RegularPolygonParameter polygonParameter;
				try {
					polygon.getId();
					polygonParameter = warehouse.getRegularPolygonParameter(id);
					result = perimeter == polygonParameter.getPerimeter();
					return result;
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
					result = perimeter == pyramidParameter.getPerimeter();
					return result;
				} catch (FiguresException e) {
					logger.log(Level.ERROR, "Can not get figure by id: {}", id, e);
				}
				break;
			default:
				logger.log(Level.ERROR, "No such action for figure: {}", className);
				break;
		}
		return false;
	}
}

package by.alekseyshysh.task3.specification.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPyramidCalculationServiceImpl;
import by.alekseyshysh.task3.specification.Specification;

public class SideFacesAreaSpecification implements Specification {

	private static Logger logger = LogManager.getRootLogger();
	 
	private double sideFacesAreaMin;
	private double sideFacesAreaMax;
	
	public SideFacesAreaSpecification(double sideFacesAreaMin, double sideFacesAreaMax) {
		this.sideFacesAreaMin = sideFacesAreaMin;
		this.sideFacesAreaMax = sideFacesAreaMax;
	}
	
	@Override
	public boolean specify(AbstractFigure figure) {
		String figureName = figure.getName();
		boolean result = false;
		switch (figureName) {
		case Figure.REGULAR_PYRAMID:
			RegularPyramid pyramid = (RegularPyramid) figure;
			RegularPyramidCalculationService pyramidCalculation = new RegularPyramidCalculationServiceImpl();
			double pyramidSurfaceArea = pyramidCalculation.calculateSurfaceArea(pyramid);
			result = sideFacesAreaMin <= pyramidSurfaceArea && pyramidSurfaceArea <= sideFacesAreaMax;
			break;
		default:
			logger.log(Level.ERROR, "No such action for figure: {}", figureName);
			break;
		}
		return result;
	}
}

package by.alekseyshysh.task3.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.entity.Warehouse;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.service.PyramidCalculationService;
import by.alekseyshysh.task3.service.impl.PyramidCalculationServiceImpl;

public class RegularPyramidObserverImpl extends FigureObserverImpl {

	private static Logger logger = LogManager.getRootLogger();
	
	@Override
	public void parameterChanged(FigureEvent event) {
		RegularPyramid figure = (RegularPyramid) event.getSource();
		PyramidCalculationService calculationService = new PyramidCalculationServiceImpl();
		double perimeter = calculationService.calculatePerimeter(figure);
		double surfaceArea = calculationService.calculateSurfaceArea(figure);
		double volume = calculationService.calculateVolume(figure);
		long id = figure.getId();
		Warehouse warehouse = Warehouse.getInstance();
		try {
			warehouse.updateParametersRegularPyramid(id, perimeter, surfaceArea, volume);
		} catch (FiguresException e) {
			logger.log(Level.ERROR, e);
		}
		logger.log(Level.DEBUG, figure);
	}
	
}
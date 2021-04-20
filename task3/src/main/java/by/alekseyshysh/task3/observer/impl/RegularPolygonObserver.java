package by.alekseyshysh.task3.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.observer.FigureEvent;

public class RegularPolygonObserver extends FigureObserver {

	private static Logger logger = LogManager.getRootLogger();
	
	@Override
	public void parameterChanged(FigureEvent event) {
		RegularPolygon figure = (RegularPolygon) event.getSource();
		logger.log(Level.DEBUG, figure);
		// TODO create RegularPolygonCalculationService
	}
	
}

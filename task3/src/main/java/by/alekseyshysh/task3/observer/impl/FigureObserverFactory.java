package by.alekseyshysh.task3.observer.impl;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.observer.FigureObserver;

// TODO Delete this of no need
public class FigureObserverFactory {

	private FigureObserverFactory() {
	}
	
	// Null reference or return in case?
	public static FigureObserver newInstance(FigureObserver figureObserver) throws FiguresException {
		FigureObserver resultFigureObserver = null;
		switch (figureObserver.getClass().getSimpleName()) {
		case ("RegularPolygonObserverImpl"):
			resultFigureObserver = new RegularPolygonObserverImpl();
			break;
		case ("RegularPyramidObserverImpl"):
			resultFigureObserver = new RegularPyramidObserverImpl();
			break;
		default:
			throw new FiguresException("No such observer type: " + figureObserver.getClass().getName());
		}
		return resultFigureObserver;
	}
	
}

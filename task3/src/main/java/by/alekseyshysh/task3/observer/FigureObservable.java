package by.alekseyshysh.task3.observer;

import by.alekseyshysh.task3.observer.impl.FigureObserverImpl;

public interface FigureObservable {

	void attach(FigureObserverImpl observer);
	
	void detach(FigureObserverImpl observer);
	
	void notifyObservers();
	
}

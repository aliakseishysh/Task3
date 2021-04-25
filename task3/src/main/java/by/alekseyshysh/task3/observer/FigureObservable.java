package by.alekseyshysh.task3.observer;

public interface FigureObservable {

	boolean attach(FigureObserver observer);
	
	boolean detach(FigureObserver observer);
	
	void notifyObservers();
	
}

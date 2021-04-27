package by.alekseyshysh.task3.observer;

public interface FigureObserver extends Cloneable {

	void parameterChanged(FigureEvent event);
	
	FigureObserver clone();
	
}

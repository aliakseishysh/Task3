package by.alekseyshysh.task3.entity;

import java.util.ArrayList;
import java.util.List;

import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.observer.FigureObservable;
import by.alekseyshysh.task3.observer.FigureObserver;
import by.alekseyshysh.task3.observer.impl.FigureObserverImpl;
import by.alekseyshysh.task3.util.IdGenerator;

public abstract class AbstractFigure implements FigureObservable {

	private long id;
	private String name;
	private List<FigureObserver> figureObservers = new ArrayList<>();
	
	protected AbstractFigure() {
		this.id = IdGenerator.generateNextId();
	}
	
	protected AbstractFigure(String name) {
		this.id = IdGenerator.generateNextId();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}
	
	public List<FigureObserver> getObservers() {
		return figureObservers;
	}

	public void setObservers(List<FigureObserver> figureObservers) {
		this.figureObservers = figureObservers;
	}

	public void attach(FigureObserverImpl observer) {
		figureObservers.add(observer);
	}
	
	public void detach(FigureObserverImpl observer) {
		figureObservers.remove(observer);
	}
	
	public void notifyObservers() {
		for (FigureObserver figureObserver: figureObservers) {
			figureObserver.parameterChanged(new FigureEvent(this));			
		}
	}
	
}

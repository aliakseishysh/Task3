package by.alekseyshysh.task3.entity;

import java.util.ArrayList;
import java.util.List;

import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.observer.Observable;
import by.alekseyshysh.task3.observer.Observer;
import by.alekseyshysh.task3.util.IdGenerator;

public abstract class AbstractFigure implements Observable {

	private long id;
	private String name;
	private List<Observer> observers = new ArrayList<>();
	
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
	
	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public void attach(Observer observer) {
		this.observers.add(observer);
	}
	
	public void detach(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObservers() {
		if (this.observers == null) {
			return;
		}
		for (Observer observer: this.observers) {
			observer.parameterChanged(new FigureEvent(this));			
		}
	}
	
}

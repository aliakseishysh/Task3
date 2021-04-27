package by.alekseyshysh.task3.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.observer.FigureObservable;
import by.alekseyshysh.task3.observer.FigureObserver;

public abstract class AbstractFigure implements FigureObservable, Cloneable {

	private static Logger logger = LogManager.getRootLogger();
	private long id;
	private String name;
	private List<FigureObserver> figureObservers = new ArrayList<>();

	protected AbstractFigure() {
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

	public boolean attach(FigureObserver observer) {
		if (observer == null) {
			return false;
		}
		figureObservers.add(observer);
		return true;
	}

	public boolean detach(FigureObserver observer) {
		if (observer == null) {
			return false;
		}
		figureObservers.remove(observer);
		return true;
	}

	public void notifyObservers() {
		for (FigureObserver figureObserver : figureObservers) {
			figureObserver.parameterChanged(new FigureEvent(this));
		}
	}

	@Override
	public AbstractFigure clone() {
		AbstractFigure abstractFigure = null;
		try {
			abstractFigure = (AbstractFigure) super.clone();
		} catch (CloneNotSupportedException e) {
			logger.log(Level.ERROR, "clone not supported", e);
		}
		return abstractFigure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figureObservers == null) ? 0 : figureObservers.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		AbstractFigure other = (AbstractFigure) obj;
		if (figureObservers == null) {
			if (other.figureObservers != null) {
				return false;
			}
		} else if (!figureObservers.equals(other.figureObservers)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractFigure [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}

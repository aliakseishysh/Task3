package by.alekseyshysh.task3.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.observer.FigureEvent;
import by.alekseyshysh.task3.observer.FigureObservable;
import by.alekseyshysh.task3.observer.FigureObserver;

public abstract class AbstractFigure implements FigureObservable {

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

	public List<FigureObserver> getObservers() {
		return new ArrayList<>(figureObservers);
	}

	public void setObservers(List<FigureObserver> figureObservers) {
		this.figureObservers = new ArrayList<>(figureObservers);
	}

	// TODO throw new exception or return boolean value? 
	// simple method +
	// you can use it without try-catch +-
	// Or should I even perform this check? user can just check for his observer equals null 
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

	// TODO something smells fishy
	public void notifyObservers() {
		for (FigureObserver figureObserver : figureObservers) {
			figureObserver.parameterChanged(new FigureEvent(this));
		}
	}
	
	// TODO it's ok?
	public AbstractFigure copy() throws FiguresException {
		AbstractFigure newFigure = null;
		String figureName = this.getName();
		try {
			AbstractFigureFactory factory = new PlanimetricFigureFactory(); 
			newFigure = factory.newInstance(this);
			return newFigure;
		} catch (FiguresException e) {
			logger.log(Level.INFO, "Figure: {} is not planimetric", figureName);
		}
		try {
			AbstractFigureFactory factory = new StereometricFigureFactory(); 
			newFigure = factory.newInstance(this);
			return newFigure;
		} catch (FiguresException e) {
			logger.log(Level.INFO, "Figure: {} is not stereometric", figureName);
			throw new FiguresException("No such figure" + figureName);
		}
	}

	// TODO should i use id and name in hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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

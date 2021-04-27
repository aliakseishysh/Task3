package by.alekseyshysh.task3.observer;

import java.util.EventObject;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class FigureEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6663813236952561842L;

	public FigureEvent(Object source) {
		super(source);
	}
	
	@Override
	public AbstractFigure getSource() {
		return (AbstractFigure) super.getSource();
	}
}

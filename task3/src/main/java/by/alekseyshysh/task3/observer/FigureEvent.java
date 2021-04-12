package by.alekseyshysh.task3.observer;

import java.util.EventObject;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class FigureEvent extends EventObject {

	public FigureEvent(Object source) {
		super(source);
	}
	
	@Override
	public AbstractFigure getSource() {
		return (AbstractFigure) super.getSource();
	}
}

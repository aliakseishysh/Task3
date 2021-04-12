package by.alekseyshysh.task3.observer;

import java.util.EventObject;

import by.alekseyshysh.task3.entity.Figure;

public class FigureEvent extends EventObject {

	public FigureEvent(Object source) {
		super(source);
	}
	
	@Override
	public Figure getSource() {
		return (Figure) super.getSource();
	}
}

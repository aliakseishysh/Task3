package by.alekseyshysh.task3.observer;

import java.util.EventObject;

import by.alekseyshysh.task3.entity.RegularPolygon;

public class RegularPolygonEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 685312499081793079L;

	public RegularPolygonEvent(Object source) {
		super(source);
	}
	
	@Override
	public RegularPolygon getSource() {
		return (RegularPolygon) super.getSource();
	}

}

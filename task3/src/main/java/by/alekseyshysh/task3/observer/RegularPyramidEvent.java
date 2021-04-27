package by.alekseyshysh.task3.observer;

import java.util.EventObject;

import by.alekseyshysh.task3.entity.RegularPyramid;

public class RegularPyramidEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3120918211476588729L;

	public RegularPyramidEvent(Object source) {
		super(source);
	}
	
	@Override
	public RegularPyramid getSource() {
		return (RegularPyramid) super.getSource();
	}

}

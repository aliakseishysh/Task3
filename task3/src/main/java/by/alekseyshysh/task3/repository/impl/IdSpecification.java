package by.alekseyshysh.task3.repository.impl;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class IdSpecification {

	private int id;
	
	public IdSpecification(int id) {
		this.id = id;
	}
	
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = abstractFigure.getId() == id;
		return result;
	}
	
}

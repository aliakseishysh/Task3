package by.alekseyshysh.task3.repository.impl;

import by.alekseyshysh.task3.entity.Figure;

public class IdSpecification {

	private int id;
	
	public IdSpecification(int id) {
		this.id = id;
	}
	
	public boolean specify(Figure figure) {
		boolean result = figure.getId() == id;
		return result;
	}
	
}

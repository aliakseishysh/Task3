package by.alekseyshysh.task3.repository.impl;

import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.repository.Specification;

public class NameSpecification implements Specification {

	private String name;
	
	public NameSpecification(String name) {
		this.name = name;
	}
	
	@Override
	public boolean specify(Figure figure) {
		boolean result = figure.getName().equals(name);
		return result;
	}
}

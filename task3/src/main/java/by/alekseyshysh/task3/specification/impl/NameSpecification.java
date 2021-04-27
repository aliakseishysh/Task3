package by.alekseyshysh.task3.specification.impl;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.specification.Specification;

public class NameSpecification implements Specification {

	private String name;
	
	public NameSpecification(String name) {
		this.name = name;
	}
	
	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = abstractFigure.getName().equals(name);
		return result;
	}
}

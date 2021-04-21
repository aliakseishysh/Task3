package by.alekseyshysh.task3.repository;

import by.alekseyshysh.task3.entity.AbstractFigure;

@FunctionalInterface
public interface Specification {

	boolean specify(AbstractFigure abstractFigure);
	
}

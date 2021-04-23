package by.alekseyshysh.task3.repository;

import by.alekseyshysh.task3.entity.AbstractFigure;

public interface Specification {

	boolean specify(AbstractFigure abstractFigure);
	
	boolean specifyFromWarehouse(AbstractFigure abstractFigure);
	
}

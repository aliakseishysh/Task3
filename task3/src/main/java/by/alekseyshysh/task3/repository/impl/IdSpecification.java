package by.alekseyshysh.task3.repository.impl;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.repository.Specification;

public class IdSpecification implements Specification {

	private long minId;
	private long maxId;
	
	public IdSpecification(long minId, long maxId) {
		this.minId = minId;
		this.maxId = maxId;
	}
	
	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		long currentId = abstractFigure.getId();
		boolean result = minId <= currentId & currentId <= maxId;
		return result;
	}

	/**
	 * id does not stored in warehouse
	 */
	@Override
	public boolean specifyFromWarehouse(AbstractFigure abstractFigure) {
		return specify(abstractFigure);
	}
	
}

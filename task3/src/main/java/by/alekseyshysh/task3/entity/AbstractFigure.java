package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.util.IdGenerator;

public abstract class AbstractFigure {

	private long id;
	private String name;
	
	protected AbstractFigure() {
		this.id = IdGenerator.generateNextId();
	}
	
	protected AbstractFigure(String name) {
		this.id = IdGenerator.generateNextId();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

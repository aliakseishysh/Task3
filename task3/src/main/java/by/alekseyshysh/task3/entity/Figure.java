package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.util.IdGenerator;

public abstract class Figure {

	private long id;
	private String name;
	
	protected Figure() {
		this.id = IdGenerator.generateNextId();
	}
	
	protected Figure(String name) {
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

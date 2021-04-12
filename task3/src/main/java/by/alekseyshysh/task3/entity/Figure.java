package by.alekseyshysh.task3.entity;

public abstract class Figure {

	private int id;
	private String name;
	
	protected Figure() {
	}
	
	protected Figure(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

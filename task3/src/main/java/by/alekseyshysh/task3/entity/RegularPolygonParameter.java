package by.alekseyshysh.task3.entity;

public class RegularPolygonParameter {
	
	private double area;
	private double perimeter;
	
	RegularPolygonParameter() {
	}
	
	RegularPolygonParameter(double area, double perimeter) {
		this.area = area;
		this.perimeter = perimeter;
	}
	
	RegularPolygonParameter(RegularPolygonParameter parameter) {
		this.area = parameter.area;
		this.perimeter = parameter.perimeter;
	}

	public double getArea() {
		return area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(perimeter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		RegularPolygonParameter other = (RegularPolygonParameter) object;
		boolean result = area == other.area && perimeter == other.perimeter;
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularPolygonParameter [area=");
		builder.append(area);
		builder.append(", perimeter=");
		builder.append(perimeter);
		builder.append("]");
		return builder.toString();
	}
	
	void setArea(double area) {
		this.area = area;
	}

	void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
}

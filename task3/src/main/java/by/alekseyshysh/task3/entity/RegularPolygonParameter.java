package by.alekseyshysh.task3.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegularPolygonParameter implements Cloneable {
	
	private static Logger logger = LogManager.getRootLogger();
	private double area;
	private double perimeter;
	
	RegularPolygonParameter() {
	}
	
	RegularPolygonParameter(double area, double perimeter) {
		this.area = area;
		this.perimeter = perimeter;
	}

	public double getArea() {
		return area;
	}

	public double getPerimeter() {
		return perimeter;
	}
	
	@Override
	public RegularPolygonParameter clone() {
		RegularPolygonParameter parameter = null;
		try {
			parameter = (RegularPolygonParameter) super.clone();
		} catch (CloneNotSupportedException e) {
			logger.log(Level.ERROR, e);
		}
		return parameter;
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

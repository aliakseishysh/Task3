package by.alekseyshysh.task3.entity;

public class RegularPyramidParameter {

	// set checks for fields?
	private double perimeter;
	private double surfaceArea;
	private double volume;

	public RegularPyramidParameter() {
	}

	public RegularPyramidParameter(double perimeter, double sideFacesArea, double volume) {
		this.perimeter = perimeter;
		this.surfaceArea = sideFacesArea;
		this.volume = volume;
	}

	public RegularPyramidParameter(RegularPyramidParameter parameter) {
		this.perimeter = parameter.perimeter;
		this.surfaceArea = parameter.surfaceArea;
		this.volume = parameter.volume;
	}

	public double getSideFacesArea() {
		return surfaceArea;
	}

	public void setSideFacesArea(double sideFacesArea) {
		this.surfaceArea = sideFacesArea;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(perimeter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(surfaceArea);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		RegularPyramidParameter other = (RegularPyramidParameter) obj;
		return perimeter == other.perimeter && surfaceArea == other.surfaceArea && volume == other.volume;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularPyramidParameter [perimeter=");
		builder.append(perimeter);
		builder.append(", surfaceArea=");
		builder.append(surfaceArea);
		builder.append(", volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}

}

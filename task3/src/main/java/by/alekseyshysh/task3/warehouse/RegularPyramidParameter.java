package by.alekseyshysh.task3.warehouse;

public class RegularPyramidParameter {

	double perimeter;
	double surfaceArea;
	double volume;
	
	public RegularPyramidParameter() {
	}
	
	public RegularPyramidParameter(double sideFacesArea, double volume) {
		this.surfaceArea = sideFacesArea;
		this.volume = volume;
	}
	
	public RegularPyramidParameter(RegularPyramidParameter parameter) {
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
		boolean result = surfaceArea == other.surfaceArea && volume == other.volume;
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularPyramidParameter [sideFacesArea=");
		builder.append(surfaceArea);
		builder.append(", volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

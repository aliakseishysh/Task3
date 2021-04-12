package by.alekseyshysh.task3.warehouse;

public class RegularPyramidParameter {

	double sideFacesArea;
	double volume;
	
	public RegularPyramidParameter() {
	}
	
	public RegularPyramidParameter(double sideFacesArea, double volume) {
		this.sideFacesArea = sideFacesArea;
		this.volume = volume;
	}

	public double getSideFacesArea() {
		return sideFacesArea;
	}

	public void setSideFacesArea(double sideFacesArea) {
		this.sideFacesArea = sideFacesArea;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(sideFacesArea);
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
		boolean result = sideFacesArea == other.sideFacesArea && volume == other.volume;
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularPyramidParameter [sideFacesArea=");
		builder.append(sideFacesArea);
		builder.append(", volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

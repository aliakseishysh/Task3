package by.alekseyshysh.task3.entity;

public class RegularPolygon extends AbstractFigure {

	private Point center;
	private int sideCount;
	private double sideLength;

	public RegularPolygon() {
	}

	public RegularPolygon(Point center, int sideCount, double sideLength) {
		this.center = center;
		this.sideCount = sideCount;
		this.sideLength = sideLength;
	}

	public RegularPolygon(RegularPolygon base) {
		super(RegularPolygon.class.getName());
		this.center = base.center;
		this.sideCount = base.sideCount;
		this.sideLength = base.sideLength;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
		notifyObservers();
	}

	public int getSideCount() {
		return sideCount;
	}

	public void setSideCount(int sideCount) {
		this.sideCount = sideCount;
		notifyObservers();
	}

	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
		notifyObservers();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + sideCount;
		long temp;
		temp = Double.doubleToLongBits(sideLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegularPolygon other = (RegularPolygon) obj;
		if (center == null) {
			if (other.center != null) {
				return false;
			}
		} else if (!center.equals(other.center)) {
			return false;
		}
		if (sideCount != other.sideCount) {
			return false;
		}
		if (Double.doubleToLongBits(sideLength) != Double.doubleToLongBits(other.sideLength)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("RegularPolygon [center=");
		builder.append(center);
		builder.append(", sideCount=");
		builder.append(sideCount);
		builder.append(", sideLength=");
		builder.append(sideLength);
		builder.append("]");
		return builder.toString();
	}


}

package by.alekseyshysh.task3.entity;

public class RegularPolygon extends AbstractFigure {

	private Point center;
	// sideCount >= 3
	private int sideCount;
	// sideLength > 0
	private double sideLength;

	public RegularPolygon() {
		super();
	}

	public RegularPolygon(Point center, int sideCount, double sideLength) {
		super(RegularPolygon.class.getName());
		this.center = center;
		this.sideCount = sideCount;
		this.sideLength = sideLength;
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
		int result = 1;
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
		if (obj == null) {
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
		if (sideLength != other.sideLength) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("RegularPolygon [center=");
		stringBuilder.append(center);
		stringBuilder.append(", sideCount=");
		stringBuilder.append(sideCount);
		stringBuilder.append(", sideLength=");
		stringBuilder.append(sideLength);
		stringBuilder.append("]");
		String result = stringBuilder.toString();
		return result;
	}
}

package by.alekseyshysh.task3.entity;

public class Point {

	private double x;
	private double y;
	private double z;

	public Point() {
	}

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
		Point other = (Point) object;
		return x == other.x && y == other.y && z == other.z;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Point: [x=");
		stringBuilder.append(x);
		stringBuilder.append(", y=");
		stringBuilder.append(y);
		stringBuilder.append(", z=");
		stringBuilder.append(z);
		stringBuilder.append("]");
		String result = stringBuilder.toString();
		return result;
	}

}

package by.alekseyshysh.task3.entity;

public class RegularPyramid extends AbstractFigure {

	private RegularPolygon base;
	private double height;

	public RegularPyramid() {
		super();
	}

	public RegularPyramid(RegularPolygon base, double height) {
		super(RegularPyramid.class.getName());
		this.base = base;
		this.height = height;
	}

	// TODO remove this
	public Point getCenter() {
		return base.getCenter();
	}

	public RegularPolygon getBase() {
		return new RegularPolygon(base);
	}

	public void setBase(RegularPolygon base) {
		this.base = new RegularPolygon(base);
		notifyObservers();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		notifyObservers();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
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

		RegularPyramid other = (RegularPyramid) obj;
		if (base == null && other.base != null) {
			return false;
		}

		return base != null && base.equals(other.base)
				&& height == other.height;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("RegularPyramid [base=");
		stringBuilder.append(base);
		stringBuilder.append(", height=");
		stringBuilder.append(height);
		stringBuilder.append("]");
		String result = stringBuilder.toString();
		return result;
	}
}

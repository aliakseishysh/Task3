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
		int result = super.hashCode();
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
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegularPyramid other = (RegularPyramid) obj;
		if (base == null || Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			if (other.base != null) {
				return false;
			}
		} else if (!base.equals(other.base)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("RegularPyramid [base=");
		builder.append(base);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}


}

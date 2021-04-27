package by.alekseyshysh.task3.entity;

public class RegularPyramid extends AbstractFigure {

	private RegularPolygon base;
	private double height;

	public RegularPyramid() {
	}

	public RegularPyramid(RegularPolygon base, double height) {
		this.base = base.clone();
		this.height = height;
	}

	public RegularPolygon getBase() {
		return base.clone();
	}

	public void setBase(RegularPolygon base) {
		this.base = base.clone();
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
	public RegularPyramid clone() {
		RegularPyramid copy = (RegularPyramid) super.clone();
		copy.base = base.clone();
		return copy;
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

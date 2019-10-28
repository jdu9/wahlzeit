package org.wahlzeit.model;

/**
 * A coordinate represents a 3-dimensional point in space.
 */
public class Coordinate {

	private final double x, y, z;

	public Coordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getDistance(Coordinate coordinate) {
		if (this.equals(coordinate)) {
			return 0.0;
		}
		double qp1 = Math.pow(this.getX() - coordinate.getX(), 2.0);
		double qp2 = Math.pow(this.getY() - coordinate.getY(), 2.0);
		double qp3 = Math.pow(this.getZ() - coordinate.getZ(), 2.0);
		return Math.sqrt(qp1 + qp2 + qp3);
	}

	public boolean isEqual(Coordinate coordinate) {
		return this.getX() == coordinate.getX() &&
			this.getY() == coordinate.getY() &&
			this.getZ() == coordinate.getZ();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	@Override
	public boolean equals(Object o) { 
		if (o == this) {
			return true; 
		} 

		if (!(o instanceof Coordinate)) { 
			return false; 
		} 

		Coordinate coord = (Coordinate) o; 

		return this.isEqual(coord);
	} 

}

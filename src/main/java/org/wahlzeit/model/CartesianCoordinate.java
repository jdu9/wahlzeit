package org.wahlzeit.model;

/**
 * A cartesian coordinate represents a 3-dimensional point in space, inherits from Coordinate
 */
public class CartesianCoordinate implements Coordinate {

	private final double x, y, z;

	static double Epsilon = 1E-5;

	public CartesianCoordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return this.getDistance(coordinate.asCartesianCoordinate());
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		CartesianCoordinate origin = new CartesianCoordinate(0.0, 0.0, 0.0);
		double radius = origin.getDistance(this);
		double theta = Math.acos(this.getZ() / radius);
		double phi = Math.asin(this.getY() / Math.sqrt( Math.pow(this.getX(), 2.0) + Math.pow(this.getY(), 2.0) ) );
		return new SphericCoordinate(phi, theta, radius);
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		boolean coordinateNotNull = coord != null;
		boolean xCompare = Math.abs(this.getX() - coord.getX()) < CartesianCoordinate.Epsilon;
		boolean yCompare = Math.abs(this.getY() - coord.getY()) < CartesianCoordinate.Epsilon;
		boolean zCompare = Math.abs(this.getZ() - coord.getZ()) < CartesianCoordinate.Epsilon;
		return coordinateNotNull && xCompare && yCompare && zCompare;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		return this.asSphericCoordinate().getCentralAngle(coordinate);
	}

	public boolean equals(Object o) { 
		if (o == this) {
			return true; 
		} 

		if (!(o instanceof CartesianCoordinate)) { 
			return false; 
		} 

		Coordinate coord = (CartesianCoordinate) o; 

		return this.isEqual(coord);
	} 

	public double getDistance(CartesianCoordinate coordinate) {
		if (this.equals(coordinate)) {
			return 0.0;
		}
		double qp1 = Math.pow(this.getX() - coordinate.getX(), 2.0);
		double qp2 = Math.pow(this.getY() - coordinate.getY(), 2.0);
		double qp3 = Math.pow(this.getZ() - coordinate.getZ(), 2.0);
		return Math.sqrt(qp1 + qp2 + qp3);
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

}


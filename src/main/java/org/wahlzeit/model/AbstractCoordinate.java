package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate) {
		this.assertClassInvariants();
		this.assertCoordinateNotNull(coordinate);

		CartesianCoordinate coord1 = this.asCartesianCoordinate();
		CartesianCoordinate coord2 = coordinate.asCartesianCoordinate();
		double result = coord1.getDistance(coord2);

		this.assertCoordinateNotNull(coord1);
		this.assertCoordinateNotNull(coord2);
		this.assertClassInvariants();
		return result;
	}

	public abstract SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate) {
		this.assertClassInvariants();
		this.assertCoordinateNotNull(coordinate);

		SphericCoordinate coord1 = coordinate.asSphericCoordinate();
		SphericCoordinate coord2 = this.asSphericCoordinate();
		double result = coord1.getAngle(coord2);

		this.assertCoordinateNotNull(coord1);
		this.assertCoordinateNotNull(coord2);
		this.assertClassInvariants();
		return result;
	}

	public abstract boolean isEqual(Coordinate coordinate);

	protected abstract void assertClassInvariants();

	protected void assertCoordinateNotNull(Coordinate coordinate) {
		if (coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null!");
		}
	}

	protected void assertDoubleNotNull(Object value) {
		if (value == null) {
			throw new IllegalArgumentException("Value must not be null!");
		}
	}

	protected void assertDoubleNotNegative(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value must be positive!");
		}
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

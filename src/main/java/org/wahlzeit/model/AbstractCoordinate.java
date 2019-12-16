package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();
		this.assertObjectNotNull(coordinate);

		CartesianCoordinate coord1 = this.asCartesianCoordinate();
		CartesianCoordinate coord2 = coordinate.asCartesianCoordinate();
		double result = coord1.getDistance(coord2);

		this.assertObjectNotNull(coord1);
		this.assertObjectNotNull(coord2);

		this.assertClassInvariants();
		return result;
	}

	public abstract SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();
		this.assertObjectNotNull(coordinate);

		SphericCoordinate coord1 = coordinate.asSphericCoordinate();
		SphericCoordinate coord2 = this.asSphericCoordinate();
		double result = coord1.getAngle(coord2);

		this.assertObjectNotNull(coord1);
		this.assertObjectNotNull(coord2);
		this.assertClassInvariants();
		return result;
	}

	public abstract boolean isEqual(Coordinate coordinate);

	protected abstract void assertClassInvariants();

	protected void assertObjectNotNull(Object value) throws IllegalArgumentException {
		if (value == null) {
			throw new IllegalArgumentException("Value must not be null!");
		}
	}

	protected void assertDoubleNotNegative(double value) throws IllegalArgumentException {
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

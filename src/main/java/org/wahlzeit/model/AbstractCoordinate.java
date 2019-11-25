package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract CartesianCoordinate asCartesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate coord1 = this.asCartesianCoordinate();
		CartesianCoordinate coord2 = coordinate.asCartesianCoordinate();
		return coord1.getDistance(coord2);
	}

	public abstract SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate) {
		SphericCoordinate c1 = coordinate.asSphericCoordinate();
		SphericCoordinate c2 = this.asSphericCoordinate();
		return c1.getAngle(c2);
	}

	public abstract boolean isEqual(Coordinate coordinate);

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

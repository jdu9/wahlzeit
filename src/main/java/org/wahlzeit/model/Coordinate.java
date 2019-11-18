package org.wahlzeit.model;

/**
 * A coordinate represents a 3-dimensional point in space.
 */
public interface Coordinate {

	public CartesianCoordinate asCartesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate);

	public SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate);

	public boolean isEqual(Coordinate coordinate);

}

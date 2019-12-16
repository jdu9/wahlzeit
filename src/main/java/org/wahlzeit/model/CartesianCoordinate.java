package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Objects;

/**
 * A cartesian coordinate represents a 3-dimensional point in space, inherits from Coordinate
 */
public class CartesianCoordinate extends AbstractCoordinate {

	private final double x, y, z;

	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.assertClassInvariants();
	}

	@Override
	protected void assertClassInvariants() {
		try {
			this.assertObjectNotNull(this.x);
			this.assertObjectNotNull(this.y);
			this.assertObjectNotNull(this.z);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Failed class invariant!");
		}
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws NullPointerException {
		this.assertClassInvariants();

		CartesianCoordinate origin = new CartesianCoordinate(0.0, 0.0, 0.0);
		double radius = origin.getDistance(this);
		double theta = Math.acos(this.getZ() / radius);
		double phi = Math.asin(this.getY() / Math.sqrt( Math.pow(this.getX(), 2.0) + Math.pow(this.getY(), 2.0) ) );

		this.assertClassInvariants();
		return SphericCoordinate.get(phi, theta, radius);
	}

	@Override
	public boolean isEqual(Coordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();

		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		boolean coordinateNotNull = coord != null;
		boolean xCompare = Math.abs(this.getX() - coord.getX()) < CartesianCoordinate.Epsilon;
		boolean yCompare = Math.abs(this.getY() - coord.getY()) < CartesianCoordinate.Epsilon;
		boolean zCompare = Math.abs(this.getZ() - coord.getZ()) < CartesianCoordinate.Epsilon;
		boolean result = coordinateNotNull && xCompare && yCompare && zCompare;

		this.assertClassInvariants();
		return result;
	}

	public double getDistance(CartesianCoordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();
		this.assertObjectNotNull(coordinate);

		if (this.equals(coordinate)) {
			return 0.0;
		}
		double qp1 = Math.pow(this.getX() - coordinate.getX(), 2.0);
		double qp2 = Math.pow(this.getY() - coordinate.getY(), 2.0);
		double qp3 = Math.pow(this.getZ() - coordinate.getZ(), 2.0);
		double result = Math.sqrt(qp1 + qp2 + qp3);

		this.assertDoubleNotNegative(qp1);
		this.assertDoubleNotNegative(qp2);
		this.assertDoubleNotNegative(qp3);
		this.assertDoubleNotNegative(result);
		this.assertClassInvariants();
		return result;
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
	public int hashCode() {
		return CartesianCoordinate.genHashCode(this.x, this.y, this.z);
	}

	static double Epsilon = 1E-5;

	protected static HashMap<String, CartesianCoordinate> coordinates = new HashMap<String, CartesianCoordinate>();

	public synchronized static CartesianCoordinate get(double x, double y, double z) {
		String key = Integer.toString(SphericCoordinate.genHashCode(x, y, z));
		CartesianCoordinate coordinate = coordinates.get(key);

		if (coordinate != null) {
			return coordinate;
		}

		CartesianCoordinate newCoordinate = new CartesianCoordinate(x, y, z);
		coordinates.put(Integer.toString(newCoordinate.hashCode()), newCoordinate);
		return newCoordinate;
	}

	public static int genHashCode(double x, double y, double z) {
		return Objects.hash(x, y, z);
	}

	public static int count() {
		return coordinates.size();
	}

	public static void clear() {
		coordinates.clear();
	}

}


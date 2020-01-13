package org.wahlzeit.model;

import org.wahlzeit.annotations.DesignPattern;
import java.util.HashMap;
import java.util.Objects;

/**
 * A spheric coordinate represents a 3-dimensional point in space, inherits from Coordinate
 */
@DesignPattern (
	name = "Value Object",
	participants = { "Value Object" }
)
public class SphericCoordinate extends AbstractCoordinate {

	private final double phi, theta, radius;

	private SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		this.assertClassInvariants();
	}

	private void assertPhi(double angle) throws IllegalArgumentException {
		if (angle < 0.0 && angle > 2.0 * Math.PI) {
			throw new IllegalArgumentException("Phi has a wrong value!");
		}
	}

	private void assertTheta(double angle) throws IllegalArgumentException {
		if (angle < 0.0 && angle > Math.PI) {
			throw new IllegalArgumentException("Theta has a wrong value!");
		}
	}

	@Override
	protected void assertClassInvariants() {
		try {
			this.assertPhi(this.phi);
			this.assertTheta(this.theta);
			this.assertDoubleNotNegative(this.radius);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Failed class invariant!");
		}
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws NullPointerException {
		this.assertClassInvariants();

		double x = this.getRadius() * Math.sin(theta) * Math.cos(phi);
		double y = this.getRadius() * Math.sin(theta) * Math.sin(phi);
		double z = this.getRadius() * Math.cos(theta);

		this.assertClassInvariants();
		return CartesianCoordinate.get(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		this.assertClassInvariants();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();
		return this.asCartesianCoordinate().isEqual(coordinate);
	}

	public double getRadius() {
		return this.radius;
	}

	public double getPhi() {
		return this.phi;
	}

	public double getTheta() {
		return this.theta;
	}

	public double getAngle(SphericCoordinate coordinate) throws NullPointerException {
		this.assertClassInvariants();
		this.assertObjectNotNull(coordinate);

		double dphi = Math.pow(Math.sin((this.getPhi() - coordinate.getPhi())/2.0), 2);
		double dtheta = Math.pow(Math.sin((this.getTheta() - coordinate.getTheta())/2.0), 2);
		double result = 2.0 * Math.asin(dphi + Math.cos(coordinate.getPhi()) * Math.cos(this.getPhi() * dtheta));

		this.assertPhi(dphi);
		this.assertTheta(dtheta);
		this.assertClassInvariants();
		return result;
	}

	@Override
	public int hashCode() {
		return SphericCoordinate.genHashCode(this.phi, this.theta, this.radius);
	}

	protected static HashMap<String, SphericCoordinate> coordinates = new HashMap<String, SphericCoordinate>();

	public synchronized static SphericCoordinate get(double phi, double theta, double radius) {
		String key = Integer.toString(SphericCoordinate.genHashCode(phi, theta, radius));
		SphericCoordinate coordinate = coordinates.get(key);

		if (coordinate != null) {
			return coordinate;
		}

		SphericCoordinate newCoordinate = new SphericCoordinate(phi, theta, radius);
		coordinates.put(Integer.toString(newCoordinate.hashCode()), newCoordinate);
		return newCoordinate;
	}

	public static int genHashCode(double phi, double theta, double radius) {
		return Objects.hash(phi, theta, radius);
	}

	public static int count() {
		return coordinates.size();
	}

	public static void clear() {
		coordinates.clear();
	}

}

package org.wahlzeit.model;

/**
 * A spheric coordinate represents a 3-dimensional point in space, inherits from Coordinate
 */
public class SphericCoordinate extends AbstractCoordinate {

	private final double phi, theta, radius;

	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
		this.assertClassInvariants();
	}

	public SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		this.assertClassInvariants();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		this.assertClassInvariants();

		double x = this.getRadius() * Math.sin(theta) * Math.cos(phi);
		double y = this.getRadius() * Math.sin(theta) * Math.sin(phi);
		double z = this.getRadius() * Math.cos(theta);
		CartesianCoordinate result = new CartesianCoordinate(x, y, z);

		this.assertClassInvariants();
		return result;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		this.assertClassInvariants();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
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

	public double getAngle(SphericCoordinate coordinate) {
		this.assertClassInvariants();
		this.assertCoordinateNotNull(coordinate);

		double dphi = Math.pow(Math.sin((this.getPhi() - coordinate.getPhi())/2.0), 2);
		double dtheta = Math.pow(Math.sin((this.getTheta() - coordinate.getTheta())/2.0), 2);
		double result = 2.0 * Math.asin(dphi + Math.cos(coordinate.getPhi()) * Math.cos(this.getPhi() * dtheta));

		this.assertRadian(dphi);
		this.assertRadian(dtheta);
		this.assertRadian(result);
		this.assertClassInvariants();
		return result;
	}

	@Override
	public void assertClassInvariants() {
		this.assertRadian(this.phi);
		this.assertRadian(this.theta);
		this.assertDoubleNotNegative(this.radius);
	}

	private void assertRadian(double angle) {
		if (angle < 0 && angle >= 2 * Math.PI) {
			throw new IllegalArgumentException("Radian value is invalid!");
		}
	}

}

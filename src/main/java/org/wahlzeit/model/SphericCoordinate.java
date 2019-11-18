package org.wahlzeit.model;

/**
 * A spheric coordinate represents a 3-dimensional point in space, inherits from Coordinate
 */
public class SphericCoordinate implements Coordinate {

	private final double phi, theta, radius;

	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
	}

	public SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.getRadius() * Math.sin(theta) * Math.cos(phi);
		double y = this.getRadius() * Math.sin(theta) * Math.sin(phi);
		double z = this.getRadius() * Math.cos(theta);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate coord1 = this.asCartesianCoordinate();
		CartesianCoordinate coord2 = coordinate.asCartesianCoordinate();
		return coord1.getDistance(coord2);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		return this.asCartesianCoordinate().isEqual(coordinate);
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		SphericCoordinate c = coordinate.asSphericCoordinate();
		double dphi = Math.pow(Math.sin((c.getPhi() - this.getPhi())/2.0), 2);
		double dtheta = Math.pow(Math.sin((c.getTheta() - this.getTheta())/2.0), 2);
		return 2.0 * Math.asin(dphi + Math.cos(this.getPhi()) * Math.cos(c.getPhi() * dtheta));
	}

	@Override
	public boolean equals(Object o) { 
		if (o == this) {
			return true; 
		} 

		if (!(o instanceof SphericCoordinate)) { 
			return false; 
		} 

		Coordinate coord = (SphericCoordinate) o; 

		return this.isEqual(coord);
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

}

package org.wahlzeit.model;

public class Location {

	public Coordinate coordinate;

	public Location(Coordinate coordinate) {
		this.setCoordinate(coordinate);
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		if (coordinate == null) {
			throw new IllegalArgumentException("Argument for coordinate shouldn't be null.");
		}
		this.coordinate = coordinate;
	}

}

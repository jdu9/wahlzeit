package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

	private Coordinate coordinate;

	private double delta = 0.001;

	/**
	 *
	 */
	@Test
	public void testConstructor1() {
		Location location = new Location(new Coordinate());
		assertNotNull(location);
		assertNotNull(location.coordinate);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance1() {
		Coordinate coordinate1 = new Coordinate(0.0, 0.0, 0.0);
		Coordinate coordinate2 = new Coordinate(0.0, 0.0, 0.0);
		assertEquals(0.0, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance2() {
		Coordinate coordinate1 = new Coordinate(-10.0, -10.0, -10.0);
		Coordinate coordinate2 = new Coordinate(10.0, 10.0, 10.0);
		assertEquals(34.641, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance3() {
		Coordinate coordinate1 = new Coordinate(-15.0, 5.0, 3.0);
		Coordinate coordinate2 = new Coordinate(3.0, 12.0, -2.5);
		assertEquals(20.0811, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testEqualsTrue() {
		Coordinate coordinate1 = new Coordinate(15.0, 0.0, 15.0);
		Coordinate coordinate2 = new Coordinate(15.0, 0.0, 15.0);
		assertTrue(coordinate1.equals(coordinate2));
	}

	/**
	 *
	 */
	@Test
	public void testEqualsFalse() {
		Coordinate coordinate1 = new Coordinate(15.0, 0.001, 15.0);
		Coordinate coordinate2 = new Coordinate(15.0, 0.0, 15.0);
		assertFalse(coordinate1.equals(coordinate2));
	}

}

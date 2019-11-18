package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

	private double delta = 0.001;

	/**
	 *
	 */
	@Test
	public void testCartesianCoordinateConstructor() {
		CartesianCoordinate coordinate = new CartesianCoordinate(123.0, 456.0, 789.0);
		double eps = CartesianCoordinate.Epsilon;
		assertTrue(Math.abs(coordinate.getX() - 123.0) < eps);
		assertTrue(Math.abs(coordinate.getY() - 456.0) < eps);
		assertTrue(Math.abs(coordinate.getZ() - 789.0) < eps);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance1() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(0.0, 0.0, 0.0);
		CartesianCoordinate coordinate2 = new CartesianCoordinate(0.0, 0.0, 0.0);
		assertEquals(0.0, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance2() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(-10.0, -10.0, -10.0);
		CartesianCoordinate coordinate2 = new CartesianCoordinate(10.0, 10.0, 10.0);
		assertEquals(34.641, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testGetDistance3() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(-15.0, 5.0, 3.0);
		CartesianCoordinate coordinate2 = new CartesianCoordinate(3.0, 12.0, -2.5);
		assertEquals(20.0811, coordinate1.getDistance(coordinate2), delta);
	}

	/**
	 *
	 */
	@Test
	public void testEqualsTrue() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(15.0, 0.0, 15.0);
		CartesianCoordinate coordinate2 = new CartesianCoordinate(15.0, 0.0, 15.0);
		assertTrue(coordinate1.equals(coordinate2));
	}

	/**
	 *
	 */
	@Test
	public void testEqualsFalse() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(15.0, 0.001, 15.0);
		CartesianCoordinate coordinate2 = new CartesianCoordinate(15.0, 0.0, 15.0);
		assertFalse(coordinate1.equals(coordinate2));
	}

	/**
	 *
	 */
	@Test
	public void testCartesianSpheric1() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate();
		SphericCoordinate coordinate2 = new SphericCoordinate(); 
		assertTrue(coordinate2.isEqual(coordinate2));
		assertTrue(coordinate1.isEqual(coordinate2));
	}

	/**
	 *
	 */
	@Test
	public void testCartesianSpheric2() {
		CartesianCoordinate coordinate1 = new CartesianCoordinate(-1.36005, 4.59768, 1.41831);
		SphericCoordinate coordinate2 = new SphericCoordinate(5.0, 5.0, 5.0); 
		assertTrue(coordinate2.isEqual(coordinate2));
	}


}

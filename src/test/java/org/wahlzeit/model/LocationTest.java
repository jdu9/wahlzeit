package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocationTest {

	public Location location;

	@Before
	public void initLocation() {
		location = new Location(CartesianCoordinate.get(0.0, 0.0, 0.0));
	}

	/**
	 *
	 */
	@Test
	public void testConstructor1() {
		assertNotNull(this.location);
		assertNotNull(this.location.coordinate);
	}

}

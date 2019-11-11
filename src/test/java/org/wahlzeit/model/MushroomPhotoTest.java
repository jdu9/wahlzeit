package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MushroomPhotoTest {

	/**
	 *
	 */
	@Test
	public void testConstructor1() {
		PhotoId photoId = new PhotoId(100);
		MushroomPhoto mushroomPhoto = new MushroomPhoto(photoId);
		assertEquals(mushroomPhoto.getId().asInt(), 100);
	}

	/**
	 *
	 */
	@Test
	public void testConstructor2() {
		MushroomPhoto mushroomPhoto = new MushroomPhoto(true, true, 40);
		assertTrue(mushroomPhoto.isEdible());
		assertTrue(mushroomPhoto.isHallucinogen());
		assertEquals(mushroomPhoto.getRadius(), 40);
	}

}

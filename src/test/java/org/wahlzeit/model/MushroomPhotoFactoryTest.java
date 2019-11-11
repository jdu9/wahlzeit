package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MushroomPhotoFactoryTest {

	/**
	 *
	 */
	@Test
	public void testFactoryCreate() {
		MushroomPhoto mushroomPhoto = MushroomPhotoFactory.getInstance().createMushroomPhoto(false, true, 1241);
		assertEquals(mushroomPhoto.isEdible(), false);
		assertEquals(mushroomPhoto.isHallucinogen(), true);
		assertEquals(mushroomPhoto.getRadius(), 1241);
	}

}

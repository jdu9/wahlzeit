package org.wahlzeit.model;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MushroomPhotoManagerTest {

	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());


	@Test
	public void testManagerAdd() throws IOException {
		MushroomPhoto mushroomPhoto = new MushroomPhoto(true, false, 5);
		MushroomPhotoManager.getInstance().addPhoto(mushroomPhoto);
		assertEquals(MushroomPhotoManager.getInstance().getPhoto(mushroomPhoto.getId()), mushroomPhoto);
	}

}

package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	MushroomPhotoTest.class,
	MushroomPhotoManagerTest.class,
	MushroomPhotoFactoryTest.class
})

public class ModelTestSuite {}

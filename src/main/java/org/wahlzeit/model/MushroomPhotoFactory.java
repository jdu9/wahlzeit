package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

/**
 * An Abstract Factory for creating photos and related objects.
 */
public class MushroomPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static MushroomPhotoFactory instance = null;

	/**
	 *
	 */
	protected MushroomPhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized MushroomPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic MushroomPhotoFactory").toString());
			setInstance(new MushroomPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(MushroomPhotoFactory mushroomPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize MushroomPhotoFactory twice");
		}

		instance = mushroomPhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public MushroomPhoto createMushroomPhoto() {
		return new MushroomPhoto();
	}

	/**
	 * @methodtype factory
	 */
	public MushroomPhoto createMushroomPhoto(PhotoId myId) throws NullPointerException {
		return new MushroomPhoto(myId);
	}


	/**
	 * @methodtype factory
	 */
	public MushroomPhoto createMushroomPhoto(boolean edible, boolean hallucinogen, int radius) throws NullPointerException {
		return new MushroomPhoto(edible, hallucinogen, radius);
	}

}

package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * A photo manager provides access to and manages photos.
 */
@Subclass
public class MushroomPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final MushroomPhotoManager instance = new MushroomPhotoManager();

	/**
	 *
	 */
	public MushroomPhotoManager() {
		super();
	}

}

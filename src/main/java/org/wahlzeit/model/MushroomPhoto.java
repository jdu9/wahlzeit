package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * A photo represents a user-provided (uploaded) mushroom photo.
 */
@Subclass
public class MushroomPhoto extends Photo {

	private boolean edible;
	private boolean hallucinogen;
	private int radius; // in mm

	/**
	 * @methodtype constructor
	 */
	public MushroomPhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public MushroomPhoto(PhotoId myId) {
		super(myId);
	}


	/**
	 * @methodtype constructor
	 */
	public MushroomPhoto(boolean edible, boolean hallucinogen, int radius) {
		super();
		this.edible = edible;
		this.hallucinogen = hallucinogen;
		this.radius = radius;
	}

	/**
	 *
	 */
	public boolean isEdible() {
		return this.edible;
	}

	/**
	 *
	 */
	public boolean isHallucinogen() {
		return this.hallucinogen;
	}

	/**
	 *
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 *
	 */
	public void setEdible(boolean edible) {
		this.edible = edible;
	}

	/**
	 *
	 */
	public void setHallucinogen(boolean hallucinogen) {
		this.hallucinogen = hallucinogen;
	}

	/**
	 *
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

}

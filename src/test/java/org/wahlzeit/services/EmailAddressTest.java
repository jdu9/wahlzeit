/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	String webFefeString = "web@fefe.de";
	String bloginputFefeString = "felix-bloginput@fefe.de";

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

	/**
	 *
	 */
	public void testEmailAddressIsEqualTrue() {
		EmailAddress addr1 = EmailAddress.getFromString(webFefeString);
		EmailAddress addr2 = EmailAddress.getFromString(bloginputFefeString);
		EmailAddress addr3 = EmailAddress.getFromString(bloginputFefeString);
		assertTrue(addr1.isEqual(addr1));
		assertTrue(addr2.isEqual(addr2));
		assertTrue(addr2.isEqual(addr3));
	}

	/**
	 *
	 */
	public void testEmailAddressIsEqualFalse() {
		EmailAddress addr1 = EmailAddress.getFromString(webFefeString);
		EmailAddress addr2 = EmailAddress.getFromString(bloginputFefeString);
		assertFalse(addr1.isEqual(addr2));
	}

}


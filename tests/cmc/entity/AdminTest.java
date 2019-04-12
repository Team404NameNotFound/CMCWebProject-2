package cmc.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdminTest {
	Admin testAdmin;

	@Before
	public void setUp() throws Exception {
		testAdmin = new Admin("Hugo", "Virgen", "hvirgen", "Henlo", "a", "Y");
	}

	/*
	 * testing getFirstName method
	 */
	@Test
	public void testGetFirstName() {
		assertTrue(testAdmin.getFirstName().equals("Hugo"));
	}

	/**
	 * testing setFirstName method
	 */
	@Test
	public void testSetFirstName() {
		this.testAdmin.setFirstName("notHugo");
		assertTrue(testAdmin.getFirstName().equals("notHugo"));
	}

	/**
	 * testing getLatName method
	 */
	@Test
	public void testGetLastName() {
		assertTrue(this.testAdmin.getLastName().equals("Virgen"));
	}

	/**
	 * testing setLatNameMethod
	 */
	@Test
	public void testSetLastName() {
		this.testAdmin.setLastName("notVirgen");
		assertTrue(this.testAdmin.getLastName().equals("notVirgen"));
	}

	/**
	 * testing getUsername method
	 */
	@Test
	public void testGetUsername() {
		assertTrue(this.testAdmin.getUsername().equals("hvirgen"));
	}

	/**
	 * testing setUserName method
	 */
	@Test
	public void testSetUsername() {
		this.testAdmin.setUsername("newUsername");
		assertTrue(this.testAdmin.getUsername().equals("newUsername"));
	}

	/**
	 * testing getPassword method
	 */
	@Test
	public void testGetPassword() {
		assertTrue(this.testAdmin.getPassword().equals("Henlo"));
	}

	/**
	 * testing setPassword method
	 */
	@Test
	public void testSetPassword() {
		this.testAdmin.setPassword("newPassword");
		assertTrue(this.testAdmin.getPassword().equals("newPassword"));
	}

	/**
	 * testing getUserType
	 */
	@Test
	public void testGetUserType() {
		assertTrue(this.testAdmin.getUserType().equals("a"));
	}

	/**
	 * testing setUserType method
	 */
	@Test
	public void setUserType() {
		this.testAdmin.setUserType("u");
		assertTrue(this.testAdmin.getUserType().equals("u"));
	}

	/**
	 * testing getUserStatus method
	 */
	@Test
	public void testGetUserStatus() {
		assertTrue(this.testAdmin.getUserStatus().equals("Y"));
	}

	/**
	 * testing setUserStatus
	 */
	@Test
	public void testSetUserStatus() {
		this.testAdmin.setUserStatus("N");
		assertTrue(this.testAdmin.getUserStatus().equals("N"));
	}

}

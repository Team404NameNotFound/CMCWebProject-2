package cmc.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account testacc;

	@Before
	public void setUp() throws Exception {
		testacc = new Account("test", "account", "testacc", "password", "u", "Y");
	}

	@Test
	public void testGetFirstName() {
		String result = testacc.getFirstName();
		String expResult = "test";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetFirstName() {
		testacc.setFirstName("test1");
		String result = testacc.getFirstName();
		String expResult = "test1";
		assertEquals(result, expResult);
	}

	@Test
	public void testGetLastName() {
		String result = testacc.getLastName();
		String expResult = "account";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetLastName() {
		testacc.setLastName("last254");
		String result = testacc.getLastName();
		String expResult = "last254";
		assertEquals(result, expResult);
	}

	@Test
	public void testGetUsername() {
		String result = testacc.getUsername();
		String expResult = "testacc";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetUsername() {
		testacc.setUsername("testacc1");
		String result = testacc.getUsername();
		String expResult = "testacc1";
		assertEquals(result, expResult);
	}

	@Test
	public void testGetPassword() {
		String result = testacc.getPassword();
		String expResult = "password";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetPassword() {
		testacc.setPassword("password1");
		String result = testacc.getPassword();
		String expResult = "password1";
		assertEquals(result, expResult);
	}

	@Test
	public void testGetUserType() {
		String result = testacc.getUserType();
		String expResult = "u";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetUserType() {
		testacc.setUserType("a");
		String result = testacc.getUserType();
		String expResult = "a";
		assertEquals(result, expResult);
	}

	@Test
	public void testGetUserStatus() {
		String result = testacc.getUserStatus();
		String expResult = "Y";
		assertEquals(result, expResult);
	}

	@Test
	public void testSetUserStatus() {
		testacc.setUserStatus("N");
		String result = testacc.getUserStatus();
		String expResult = "N";
		assertEquals(result, expResult);
	}

}

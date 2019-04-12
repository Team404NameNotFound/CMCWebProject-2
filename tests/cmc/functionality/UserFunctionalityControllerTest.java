package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.University;

public class UserFunctionalityControllerTest {
	UserFunctionalityController ufc;

	@Before
	public void setUp() throws Exception {
		this.ufc = new UserFunctionalityController();
	}

	/**
	 * tests to make sure login fails when invalid username is used
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLoginFailsUserDNE() {
		ufc.login("userDNE", "asdf");
	}

	/**
	 * tests to make sure the user status is active
	 */
	@Test(expected = NullPointerException.class)
	public void testLoginFailsInvalidCredentials() {
		ufc.login("cuser", "user");
	}

	/**
	 * tests to check that login fails when password does not match
	 */
	@Test(expected = IllegalArgumentException.class)
	public void loginFailsPasswordMatch() {
		ufc.login("juser", "asdf");
	}

	/**
	 * tests to make sure login works
	 */
	@Test
	public void loginTest() {
		assertTrue(ufc.login("juser", "user"));
	}

	/**
	 * test to make sure the user can logout
	 */
	@Test
	public void testLogout() {
		ufc.login("cz001", "password");
		assertTrue(ufc.loggedIn);
		ufc.logout();
		assertFalse(ufc.loggedIn);
	}

	/**
	 * tests to make sure you can view the profile of a user
	 */
	@Test
	public void testViewUserProfile() {
		DBController db = new DBController();
		ArrayList<String> userInfo = ufc.viewUserProfile("cz001");
		assertTrue(userInfo.get(0).equals(db.getAccount("cz001").getFirstName()));
		assertTrue(userInfo.get(1).equals(db.getAccount("cz001").getLastName()));
		assertTrue(userInfo.get(2).equals(db.getAccount("cz001").getUsername()));
	}

	/**
	 * tests to make sure view user fails when the user does not exist
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testViewUserFailsWhenUserDNE() {
		ufc.viewUserProfile("nonexist");
	}

	/**
	 * tests to make sure edit User fails when user does not exist
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserFailsWhenDNE() {
		ufc.editUserProfile("NONEXISTANT", "adf", "af", "sdf", "a");
	}

	/**
	 * tests to make sure you can edit the profile of a user
	 */
	@Test
	public void testEditUserProfile() {
		DBController db = new DBController();
		ufc.editUserProfile("cz001", "first", "pass", "last", "u");
		assertTrue(db.getAccount("cz001").getFirstName().equals("first"));
		assertTrue(db.getAccount("cz001").getLastName().equals("last"));
		assertTrue(db.getAccount("cz001").getPassword().equals("pass"));
		ufc.editUserProfile("cz001", "Carrie", "password", "Zhang", "u");

	}

	/**
	 * tests to make sure you can get a complete list of schools to view
	 */
	@Test
	public void testViewSchoolList() {
		DBController db = new DBController();
		ArrayList<University> universityList = db.getUniversityList();
		ArrayList<University> unis = ufc.viewSchoolList();
		for (int i = 0; i < universityList.size(); i++) {
			assertTrue(universityList.get(i).getName().equals(unis.get(i).getName()));
		}
	}

	/**
	 * tests to make sure the forgot password feature works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForgotPassword() {
		ufc.forgotPassword("userDNE");
	}

	@Test
	public void forgotPasswordTest() {
		DBController db = new DBController();
		String passOld = db.getAccount("ajheroux@csbsju.edu").getPassword();
		ufc.forgotPassword("ajheroux@csbsju.edu");
		assertFalse(passOld.equals(db.getAccount("ajheroux@csbsju.edu").getPassword()));
	}

	/**
	 * tests to make sure you can see the universities details
	 */
	@Test
	public void testViewUniversityDetials() {
		// ADELPHI NEW YORK -1 PRIVATE 15000 70 500 475 37437 60 5500 70 40 2 2 2
		University school = new DBController().getUniversity("ADELPHI");
		ArrayList<String> schoolDetails = ufc.viewUniversityDetials("ADELPHI");
		assertTrue(schoolDetails.get(0).equals((school.getName())));
		assertTrue(schoolDetails.get(1).equals((school.getState())));
		assertTrue(schoolDetails.get(3).equals(school.getControl()));
		assertTrue(schoolDetails.get(4).equals(school.getEnrollment()));
	}

	/**
	 * tests to make sure a university fails when you call to view a non existant
	 * university
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testViewUniversityDetailsFailsWhenUniversityDNE() {
		ufc.viewUniversityDetials("henlo");
	}

}

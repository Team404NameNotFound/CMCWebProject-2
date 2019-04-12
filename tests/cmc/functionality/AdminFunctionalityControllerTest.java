package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.University;

public class AdminFunctionalityControllerTest {

	DBController dbController = new DBController();
	AdminFunctionalityController afc;
	ArrayList<University> universityList;
	ArrayList<Account> accounts;

	/**
	 * constructs the new AdmintFuncitonalityController used for Testing
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		afc = new AdminFunctionalityController();

	}

	/**
	 * ensures the DummySchool made for testing is always removed after a test
	 * 
	 * @throws Exception
	 */
	@After
	public void cleanUp() throws Exception {
		dbController.removeUniversity("DummyTestSchool");

	}

	/**
	 * tests to make sure all universities are retrieved/viewable
	 */
	@Test
	public void testViewUniversities() {
		this.universityList = dbController.getUniversityList();
		ArrayList<University> unis = afc.viewSchoolList();
		for (int i = 0; i < this.universityList.size(); i++) {
			assertTrue(this.universityList.get(i).getName().equals(unis.get(i).getName()));
		}
	}

	@Test
	public void testViewUsers() {
		this.accounts = dbController.getAccountList();
		ArrayList<Account> users = afc.viewUsers();
		for (int i = 0; i < this.accounts.size(); i++) {
			assertTrue(this.accounts.get(i).getFirstName().equals(users.get(i).getFirstName()));
		}
	}

	/**
	 * tests to make sure a new university is added to the database
	 */
	@Test
	public void testAddNewUniversity() {
		String[] emphases = { "Math" };
		afc.addNewUniversity("DummyTestSchool", "DummyState", "DummyLocation", "DummyControl", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
		assertTrue(dbController.getUniversity("DummyTestSchool").getSatMath().equals("600"));
	}

	/**
	 * tests to make sure adding a university fails when a school already has the
	 * name
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewUniversityFailsWhenAlreadyExists() {
		String[] emphases = { "Math" };
		afc.addNewUniversity("DummyTestSchool", "DummyState", "DummyLocation", "DummyControl", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
		afc.addNewUniversity("DummyTestSchool", "DummyState", "DummyLocation", "DummyControl", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
	}

	/**
	 * tests that editing a university changes its information in the databse
	 */
	@Test
	public void testEditUniversity() {
		String[] emphases = { "Math" };
		afc.addNewUniversity("DummyTestSchool", "DummyState", "DummyLocation", "DummyControl", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
		afc.editUniversity("DummyTestSchool", "DummyState2", "DummyLocation2", "DummyControl2", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
		assertTrue(dbController.getUniversity("DummyTestSchool").getState().equals("DummyState2"));
	}

	/**
	 * tests to make sure that a university is removed from the database
	 */
	@Test(expected = NullPointerException.class)
	public void testRemoveUniversity() {
		String[] emphases = { "Math" };
		afc.addNewUniversity("DummyTestSchool", "DummyState", "DummyLocation", "DummyControl", "200", "20", "600",
				"600", "3", "99", "50", "50", "10", "5", "5", "5", emphases);
		assertTrue(dbController.getUniversity("DummyTestSchool").getState().equals("DummyState"));
		afc.removeUniversity("DummyTestSchool");
		dbController.getUniversity("DummyTestSchool").getApplicants();
	}

	/**
	 * tests to make sure a user has to havea a unique username
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserFailsInDatabase() {
		afc.addUser("User", "asdf", "asdf", "afd", "asdf");
	}

	/**
	 * tests to make sure a new user has all fields when added
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserFailsEmptyField() {
		afc.addUser("UniqueUser", "", "asdf", "asdf", "adf");
	}

	/**
	 * test to make sure a user type is specified
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserFailsWrongUserType() {
		afc.addUser("UniqueUser", "af", "asdf", "asdf", "t");
	}

	/**
	 * test adding a user, but you must make sure the user is not already in the
	 * database or else it will fail and it cannot be cleaned since there is no
	 * remove student method
	 */
	@Test
	public void testAddUser() {
		afc.addUser("individual", "pls", "newUser", "asdf", "u");
		assertTrue(dbController.getAccount("newUser").getFirstName().equals("individual"));

	}

	/**
	 * tests to make sure a users status is toggled and toggles it back to their
	 * normal status
	 */
	@Test
	public void testToggleActivationStatus() {
		assertTrue(dbController.getAccount("User").getUserStatus().equalsIgnoreCase("Y"));
		afc.toggleActivationStatus("User");
		assertTrue(dbController.getAccount("User").getUserStatus().equalsIgnoreCase("N"));
		afc.toggleActivationStatus("User");
	}

}

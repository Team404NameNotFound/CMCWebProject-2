package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.University;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {

	private DBController dbcon;
	private String[] emphases = null;
	private University testuni;
	private University testuni2;
	private Account testacc;
	private Account testacc2;
	private UniversityDBLibrary dbLibrary;

	@Before
	public void setUp() throws Exception {
		dbcon = new DBController();
		testuni = new University("testuni", "MN", "URBAN", "PRIVATE", "200", "50", "10", "11", "22", "33", "2222", "30",
				"25", "1", "2", "3", emphases);
		testuni2 = new University("testuni", "EDIT", "URBAN", "PRIVATE", "200", "50", "10", "11", "22", "33", "2222",
				"30", "25", "1", "2", "3", emphases);
		testacc = new Account("first", "last", "testacc", "password", "u", "Y");
		testacc2 = new Account("first", "editedlast", "testacc", "password", "u", "Y");
		dbLibrary = new UniversityDBLibrary("error404", "csci230");
	}

	@Test
	public void testCheckUserYStatus() {
		boolean result = dbcon.checkUser("juser");
		boolean expResult = true;
		assertEquals(result, expResult);
	}

	@Test
	public void testCheckUserNStatus() {
		boolean result = dbcon.checkUser("luser");
		boolean expResult = false;
		assertEquals(result, expResult);
	}

	@Test
	public void testAddUniversity() {
		dbcon.removeUniversity("testuni");
		int expResult = dbLibrary.university_getUniversities().length + 1;
		dbcon.addUniversity(testuni);
		int result = dbLibrary.university_getUniversities().length;
		dbcon.removeUniversity("testuni");
		assertEquals(result, expResult);
	}

	@Test
	public void testGetUniversity() {
		dbcon.addUniversity(testuni);
		dbcon.setUniversity(testuni);
		University result = dbcon.getUniversity("testuni");
		assertEquals(result.getName(), "testuni");
	}

	@Test
	public void testSetUniversity() {
		dbcon.addUniversity(testuni);
		dbcon.setUniversity(testuni2);
		University result = dbcon.getUniversity("testuni");
		dbcon.setUniversity(testuni2);
		assertEquals(result.getState(), "EDIT");
	}

	@Test
	public void testRemoveUniversity() {
		dbcon.removeUniversity("testuni");
		boolean result = dbcon.findUniversity("testuni");
		boolean expResult = false;
		assertEquals(result, expResult);
	}

	@Test
	public void testAddUser() {
		dbcon.addUser(testacc);
		Boolean result = dbcon.checkUser("testacc");
		Boolean expResult = true;
		assertEquals(result, expResult);
	}

	@Test
	public void testGetAccount() {
		dbcon.setAccount(testacc);
		Account result = dbcon.getAccount("testacc");
		assertEquals(result.getUsername(), "testacc");
	}

	@Test
	public void testSetAccount() {
		dbcon.setAccount(testacc2);
		Account result = dbcon.getAccount("testacc");
		Account expResult = testacc2;
		assertEquals(result.getLastName(), "editedlast");
	}

	@Test
	public void testFindUniversityExists() {
		boolean result = dbcon.findUniversity("BROWN");
		boolean expResult = true;
		assertEquals(result, expResult);
	}

	@Test
	public void testFindUniversityDoesNotExist() {
		boolean result = dbcon.findUniversity("NONEXISTINGUNIVERSITY");
		boolean expResult = false;
		assertEquals(result, expResult);
	}

	@Test
	public void testAddEmphasis() {
		int expResult = dbLibrary.university_getEmphases().length + 1;
		dbcon.addEmphasis("testuni", "testEmphasis");
		int result = dbLibrary.university_getEmphases().length;
		dbLibrary.university_removeUniversityEmphasis("testuni", "testEmphasis");
		assertEquals(result, expResult);
	}

	@Test
	public void testSaveShool() {
		dbcon.removeSavedSchool("testacc", "BROWN");
		int expResult = dbcon.getUserSavedStatistics("BROWN") + 1;
		dbcon.saveShool("testacc", "BROWN");
		int result = dbcon.getUserSavedStatistics("BROWN");
		assertEquals(expResult, result);
	}

	@Test
	public void testRemoveSavedSchool() {
		dbcon.removeSavedSchool("testacc", "BROWN");
		dbcon.saveShool("testacc", "BROWN");
		int expResult = dbcon.getUserSavedStatistics("BROWN") - 1;
		dbcon.removeSavedSchool("testacc", "BROWN");
		int result = dbcon.getUserSavedStatistics("BROWN");
		assertEquals(expResult, result);
	}

	@Test
	public void testGetUserSavedStatistics() {
		String[][] namesWithSavedSchools = this.dbLibrary.user_getUsernamesWithSavedSchools();
		int count = 0;
		for (int i = 0; i < namesWithSavedSchools.length; i++) {
			if (namesWithSavedSchools[i][1].equals("BROWN")) {
				count++;
			}
		}
		assertEquals(count, dbcon.getUserSavedStatistics("BROWN"));
	}

}

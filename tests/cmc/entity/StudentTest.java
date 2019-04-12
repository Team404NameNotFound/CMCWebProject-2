package cmc.entity;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.lang.Exception.*;

public class StudentTest {

	private Student testStudent;
	private ArrayList<UserSavedSchool> schoolList;
	private UserSavedSchool savedSchool;

	@Before
	public void setUp() throws Exception {
		this.schoolList = new ArrayList<UserSavedSchool>();
		String[] list = { "-1" };
		this.savedSchool = new UserSavedSchool("TestSchool", "MN", "St. Cloud", "Public", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", list, "-1");
		this.schoolList.add(savedSchool);
		this.testStudent = new Student("Test", "Student", "ajheroux@csbsju.edu", "password", "a", "Y", this.schoolList);
	}

	@Test
	public void testGetSavedSchools() {
		ArrayList<UserSavedSchool> result = testStudent.getSavedSchools();
		ArrayList<UserSavedSchool> expResult = this.schoolList;
		assertEquals(result, expResult);
	}

	@Test
	public void testSetSavedSchools() {
		ArrayList<UserSavedSchool> localSchoolList = new ArrayList<UserSavedSchool>();
		String[] list = { "-1" };
		UserSavedSchool localSavedSchool = new UserSavedSchool("LocalTestSchool", "MN", "St. Joseph", "Private", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", list, "-1");
		localSchoolList.add(localSavedSchool);
		this.testStudent.setSavedSchools(localSchoolList);
		ArrayList<UserSavedSchool> result = localSchoolList;
		ArrayList<UserSavedSchool> expResult = this.testStudent.getSavedSchools();
		assertEquals(result, expResult);
	}

	@Test
	public void testIsSchoolSavedReturnsTrue() {
		Assert.assertTrue(this.testStudent.isSchoolSaved("TestSchool"));
	}

	@Test
	public void testIsSchoolSavedReturnsFalse() {
		Assert.assertFalse(this.testStudent.isSchoolSaved("TestFalse"));
	}

	@Test
	public void testRemoveSchool() {
		this.testStudent.removeSchool("TestSchool");
		assertTrue(this.testStudent.getSavedSchools().size() == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveSchoolInvalidSchoolName() {
		this.testStudent.removeSchool("Non-saved School");
	}

	@Test
	public void testSaveSchool() {
		String[] list = { "-1" };
		University newUniversity = new University("SaveUniversity", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", list);
		this.testStudent.saveSchool(newUniversity, "Current Date");

		this.testStudent.isSchoolSaved("SaveUniversity");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveSchoolSaveSchoolThatIsAlreadySaved() {
		String[] list = { "-1" };
		University newUniversity = new University("SaveUniversity", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", "-1", "-1", list);
		this.testStudent.saveSchool(newUniversity, "Current Date");
		this.testStudent.saveSchool(newUniversity, "Current Date");
	}

}

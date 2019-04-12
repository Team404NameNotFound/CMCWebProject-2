package cmc.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UserSavedSchoolTest {

	private UserSavedSchool uss;
	private String[] emphases = null;
	private ArrayList<Student> students = new ArrayList<Student>();
	private University uni = new University("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emphases);

	@Before
	public void setUp() throws Exception {
		uss = new UserSavedSchool("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emphases, "");
	}

	@Test
	public void testGetDateAdded() {
		String expResult = "";
		String result = uss.getDateAdded();
		assertEquals(result, expResult);
	}

	@Test
	public void testSetDateAdded() {
		String expResult = "1";
		uss.setDateAdded("1");
		String result = uss.getDateAdded();
		assertEquals(result, expResult);
	}
}

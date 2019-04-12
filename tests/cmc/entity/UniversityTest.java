package cmc.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniversityTest {
	private University university;

	@Before
	public void setUp() throws Exception {
		university = new University();
	}

	@Test
	public void testGetName() {
		String expResult = "";
		String result = university.getName();
		assertEquals("University name is " + expResult, expResult, result);
	}

	@Test
	public void testSetName() {
		String expResult = "test";
		university.setName(expResult);
		String result = university.getName();
		assertEquals("University name is now " + expResult, expResult, result);
	}

	@Test
	public void testGetState() {
		String expResult = "";
		String result = university.getState();
		assertEquals("University state is " + expResult, expResult, result);
	}

	@Test
	public void testSetState() {
		String expResult = "test";
		university.setState(expResult);
		String result = university.getState();
		assertEquals("University state is now " + expResult, expResult, result);
	}

	@Test
	public void testGetLocation() {
		String expResult = "";
		String result = university.getLocation();
		assertEquals("University location is " + expResult, expResult, result);
	}

	@Test
	public void testSetLocation() {
		String expResult = "test";
		university.setLocation(expResult);
		String result = university.getLocation();
		assertEquals("University location is now " + expResult, expResult, result);
	}

	@Test
	public void testGetControl() {
		String expResult = "";
		String result = university.getControl();
		assertEquals("University control is " + expResult, expResult, result);
	}

	@Test
	public void testSetControl() {
		String expResult = "test";
		university.setControl(expResult);
		String result = university.getControl();
		assertEquals("University state is now " + expResult, expResult, result);
	}

	@Test
	public void testGetEnrollment() {
		String expResult = "";
		String result = university.getEnrollment();
		assertEquals("University enrollment is " + expResult, expResult, result);
	}

	@Test
	public void testSetEnrollment() {
		String expResult = "test";
		university.setEnrollment(expResult);
		String result = university.getEnrollment();
		assertEquals("University Enrollment is now " + expResult, expResult, result);
	}

	@Test
	public void testGetPercentFemale() {
		String expResult = "";
		String result = university.getPercentFemale();
		assertEquals("University's percentage of female is " + expResult, expResult, result);
	}

	@Test
	public void testSetPercentFemale() {
		String expResult = "test";
		university.setPercentFemale(expResult);
		String result = university.getPercentFemale();
		assertEquals("University PercentFemale is now " + expResult, expResult, result);

	}

	@Test
	public void testGetSatVerbal() {
		String expResult = "";
		String result = university.getSatVerbal();
		assertEquals("University SAT Verbal is " + expResult, expResult, result);
	}

	@Test
	public void testSetSatVerbal() {
		String expResult = "test";
		university.setSatVerbal(expResult);
		String result = university.getSatVerbal();
		assertEquals("University SatVerbal is now " + expResult, expResult, result);
	}

	@Test
	public void testGetSatMath() {
		String expResult = "";
		String result = university.getSatMath();
		assertEquals("University SAT Math is " + expResult, expResult, result);
	}

	@Test
	public void testSetSatMath() {
		String expResult = "test";
		university.setSatMath(expResult);
		String result = university.getSatMath();
		assertEquals("University SatMath is now " + expResult, expResult, result);
	}

	@Test
	public void testGetCost() {
		String expResult = "";
		String result = university.getCost();
		assertEquals("University cost is " + expResult, expResult, result);
	}

	@Test
	public void testSetCost() {
		String expResult = "test";
		university.setCost(expResult);
		String result = university.getCost();
		assertEquals("University Cost is now " + expResult, expResult, result);
	}

	@Test
	public void testGetPercentFinAid() {
		String expResult = "";
		String result = university.getPercentFinAid();
		assertEquals("University's percentage of financial aid is " + expResult, expResult, result);
	}

	@Test
	public void testSetPercentFinAid() {
		String expResult = "test";
		university.setPercentFinAid(expResult);
		String result = university.getPercentFinAid();
		assertEquals("University PercentFinAid is now " + expResult, expResult, result);
	}

	@Test
	public void testGetPercentEnrolled() {
		String expResult = "";
		String result = university.getPercentEnrolled();
		assertEquals("University's percentage of enrollment is " + expResult, expResult, result);
	}

	@Test
	public void testSetPercentEnrolled() {
		String expResult = "test";
		university.setPercentEnrolled(expResult);
		String result = university.getPercentEnrolled();
		assertEquals("University PercentEnrolled is now " + expResult, expResult, result);
	}

	@Test
	public void testGetApplicants() {
		String expResult = "";
		String result = university.getApplicants();
		assertEquals("University's number of applicants is " + expResult, expResult, result);
	}

	@Test
	public void testSetApplicants() {
		String expResult = "test";
		university.setApplicants(expResult);
		String result = university.getApplicants();
		assertEquals("University Applicants is now " + expResult, expResult, result);
	}

	@Test
	public void testGetPercentAdmitted() {
		String expResult = "";
		String result = university.getPercentAdmitted();
		assertEquals("Universit's percentage of admitted is " + expResult, expResult, result);
	}

	@Test
	public void testSetPercentAdmitted() {
		String expResult = "test";
		university.setPercentAdmitted(expResult);
		String result = university.getPercentAdmitted();
		assertEquals("University PercentAdmitted is now " + expResult, expResult, result);
	}

	@Test
	public void testGetAcademicScale() {
		String expResult = "";
		String result = university.getAcademicScale();
		assertEquals("University's academic scale is " + expResult, expResult, result);
	}

	@Test
	public void testSetAcademicScale() {
		String expResult = "test";
		university.setAcademicScale(expResult);
		String result = university.getAcademicScale();
		assertEquals("University AcademicScale is now " + expResult, expResult, result);
	}

	@Test
	public void testGetSocialScale() {
		String expResult = "";
		String result = university.getSocialScale();
		assertEquals("University social scale is " + expResult, expResult, result);
	}

	@Test
	public void testSetSocialScale() {
		String expResult = "test";
		university.setSocialScale(expResult);
		String result = university.getSocialScale();
		assertEquals("University SocialScale is now " + expResult, expResult, result);
	}

	@Test
	public void testGetQualityOfLife() {
		String expResult = "";
		String result = university.getQualityOfLife();
		assertEquals("University's quality of life is " + expResult, expResult, result);
	}

	@Test
	public void testSetQualityOfLife() {
		String expResult = "test";
		university.setQualityOfLife(expResult);
		String result = university.getQualityOfLife();
		assertEquals("University QualityOfLife is now " + expResult, expResult, result);
	}

	@Test
	public void testGetEmphases() {
		String expResult = null;
		String[] result = university.getEmphases();
		assertEquals("University's emphases are " + expResult, expResult, result);
	}

	@Test
	public void testSetEmphases() {
		String[] expResult = { "test1", "test2" };
		university.setEmphases(expResult);
		String[] result = university.getEmphases();
		assertEquals("University Emphases is now " + expResult, expResult, result);
	}

}

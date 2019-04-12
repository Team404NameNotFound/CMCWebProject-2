package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.University;

public class UniversityControllerTest {

	UniversityController unicon;
	UniversityController unicon2;
	University university1;
	University university2;

	@Before
	public void setUp() throws Exception {
		university1 = new University("testUniversity", "testState", "testLocation", "testControl", "testEnrollment",
				"testPercentFemale", "testSatVerbal", "testSatMath", "testCost", "testPercentFinAid",
				"testPercentEnrolled", "testApplicants", "testPercentAdmitted", "testAcademicScale", "testSocialScale",
				"testQualityOfLife", new String[] { "emphasis" });
		university2 = new University("testUniversity", "Oregon", "testLocation", "testControl", "testEnrollment",
				"testPercentFemale", "testSatVerbal", "testSatMath", "testCost", "testPercentFinAid",
				"testPercentEnrolled", "testApplicants", "testPercentAdmitted", "testAcademicScale", "testSocialScale",
				"testQualityOfLife", new String[] { "emphasis" });

		unicon = new UniversityController();
		unicon2 = new UniversityController(university1);
	}


	@Test
	public void testUpdateUniversityInfo() {
		UniversityController uniconUpdate = new UniversityController(new University("testUniversity", "Oregon",
				"testLocation", "testControl", "testEnrollment", "testPercentFemale", "testSatVerbal", "testSatMath",
				"testCost", "testPercentFinAid", "testPercentEnrolled", "testApplicants", "testPercentAdmitted",
				"testAcademicScale", "testSocialScale", "testQualityOfLife", new String[] { "emphasis" }));
		unicon2.updateUniversityInfo("-1", "Oregon", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", new String[] { "-1" });
		ArrayList<String> result = unicon2.getSchoolDetails();
		ArrayList<String> expResult = uniconUpdate.getSchoolDetails();

		assertEquals(result, expResult);

	}
}

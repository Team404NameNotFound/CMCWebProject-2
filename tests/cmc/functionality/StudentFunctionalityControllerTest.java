package cmc.functionality;

import static org.junit.Assert.*;
import cmc.entity.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StudentFunctionalityControllerTest {

	private StudentFunctionalityController studentConTest;
	private DBController dbCon = new DBController();
	private Account andrew = new Student("Andrew", "Heroux", "ajheroux@csbsju.edu", "38dgf", "u", "Y", null);
	@Before
	public void setUp() throws Exception {
		this.studentConTest = new StudentFunctionalityController();
<<<<<<< HEAD
		this.studentConTest.login("testacc", "password");
		this.studentConTest.saveSchool("YALE");
=======
		Account andrew = new Student("Andrew", "Heroux", "ajheroux@csbsju.edu", "38dgf", "u", "Y", null);
		dbCon.setAccount(andrew);
		this.studentConTest.login("ajheroux@csbsju.edu", "38dgf");
		Boolean found = false;
		for(int i = 0; i<dbCon.getSchoolList2(dbCon.getAccount("ajheroux@csbsju.edu")).size(); i++)
		{
			if(dbCon.getSchoolList2(dbCon.getAccount("ajheroux@csbsju.edu")).get(i).getName().equals("YALE"))
			{
				found = true;
			}
		}
		if(!found)
		{
			this.studentConTest.saveSchool("YALE");
		}
		
>>>>>>> abaecbb9325803a103b7575bc01405219bb16147
	}

	@After
	public void cleanUp() {
		Boolean found = false;
		for(int i = 0; i<dbCon.getSchoolList2(dbCon.getAccount("ajheroux@csbsju.edu")).size(); i++)
		{
			if(dbCon.getSchoolList2(dbCon.getAccount("ajheroux@csbsju.edu")).get(i).getName().equals("YALE"))
			{
				found = true;
			}
		}
		if(found)
		{
			this.studentConTest.removeSavedSchool("YALE");
		}
		this.studentConTest.logout();
	}

	@Test
	public void testRankUniversity() {
		this.studentConTest.rankUniversity("BROWN");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankUniversityUniversityDoesNotExsist() {
		this.studentConTest.rankUniversity("Lala Land");
	}

	@Test
	public void testSearch() {
			String schoolName = "BROWN";
			String state = "RHODEISLAND";
			String location = "URBAN";
			int numStudentsMin = -1;
			int numStudentsMax = -1;
			float percentFemaleMin = -1; 
			float percentFemaleMax = -1;
			int SATVerbalMin = -1; 
			int SATVerbalMax = -1;
			int SATMathMin = -1;
			int SATMathMax = -1; 
			int expensesMin = -1; 
			int expensesMax = -1;
			float PercentFinancialAidMin = -1;
			float percenetFinancialAidMax = -1;
			int numberApplicantsMin = -1;
			int numberApplicatnsMax = -1;
			float percentAddmittedMin = -1;
			float percentAdmittedMax = -1;
			float percentEnrolledMin = -1;
			float percentEnrolledMax = -1;
			int academicScaleMin = -1;
			int academicScaleMax =-1;
			int socialScaleMin = -1;
			int socialScaleMax = -1 ;
			int qualityOfLifeMin = -1; 
			int qualityOfLifeMax = -1;
			String[] emphases = new String[0];
			String control = "-1";
			ArrayList<University> result = studentConTest.search(schoolName, state, location, numStudentsMin, numStudentsMax, percentFemaleMin
					, percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMathMin, SATMathMax, expensesMin, expensesMax
					, PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin, numberApplicatnsMax
					, percentAddmittedMin, percentAdmittedMax, percentEnrolledMin, percentEnrolledMax, academicScaleMin
					, academicScaleMax, socialScaleMin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax, emphases
					, control);
			
			ArrayList<University> expResult = new ArrayList();
			expResult.add(dbCon.getUniversity("BROWN"));
			for(int i=0; i<result.size(); i++)
			{
				System.out.print(result.get(i).getName());
				assertEquals(result.get(i).getName(), expResult.get(i).getName());
			}
	}

	@Test
	public void testViewSchoolDetails() {
		DBController DBCon = new DBController();
		ArrayList<String> schoolDetials = this.studentConTest.viewSchoolDetails("AUGSBURG");
		University school = DBCon.getUniversity("AUGSBURG");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(school.getName());
		expected.add(school.getState());
		expected.add(school.getLocation());
		expected.add(school.getControl());
		expected.add(school.getEnrollment());
		expected.add(school.getPercentFemale());
		expected.add(school.getSatVerbal());
		expected.add(school.getSatMath());
		expected.add(school.getCost());
		expected.add(school.getPercentFinAid());
		expected.add(school.getApplicants());
		expected.add(school.getPercentAdmitted());
		expected.add(school.getPercentEnrolled());
		expected.add(school.getAcademicScale());
		expected.add(school.getSocialScale());
		expected.add(school.getQualityOfLife());
		assertEquals(schoolDetials, expected);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testViewSchoolDetailsFailsForInvalidSchoolName() {
		this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testSaveSchool() {
		boolean found = false;
		this.studentConTest.saveSchool("BROWN");
		ArrayList<UserSavedSchool> savedSchools = this.studentConTest.viewSavedSchools();
		for (int i = 0; i < savedSchools.size(); i++) {
			if (savedSchools.get(i).getName().equals("BROWN")) {
				found = true;
			}
		}
		this.studentConTest.removeSavedSchool("BROWN");
		assertTrue(found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveSchoolFailsForSchoolThatDoesNotExist() {
		this.studentConTest.saveSchool("Lala Land");
	}

	@Test
	public void testSetAccountController() {
		this.studentConTest.setAccountController(andrew);
		AccountController result = this.studentConTest.account;
		AccountController expected = this.studentConTest.account;
		assertEquals(result, expected);
	}

	@Test
	public void testViewSavedSchools() {
		ArrayList<UserSavedSchool> result = this.studentConTest.viewSavedSchools();
		ArrayList<UserSavedSchool> expected = dbCon.getSchoolList2(dbCon.getAccount("ajheroux@csbsju.edu"));
		for(int i=0; i<result.size(); i++) {
			assertEquals(result.get(i).getName(), expected.get(i).getName());
		}
		
	}

	@Test
	public void testRemoveSavedSchool() {
		boolean found = false;
		this.studentConTest.removeSavedSchool("YALE");
		ArrayList<UserSavedSchool> savedSchools = this.studentConTest.viewSavedSchools();
		for (int i = 0; i < savedSchools.size(); i++) {
			if (savedSchools.get(i).getName().equals("YALE"));
			{
				found = true;
				System.out.println("It's True");
			}
		}
		System.out.println(found + " " + found);
		assertFalse(found);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchoolFailsForNonExistingSchool() {
		this.studentConTest.removeSavedSchool("Lala Land");
	}

	@Test
	public void testViewSavedSchoolDetails() {
		DBController DBCon = new DBController();
		ArrayList<String> schoolDetials = this.studentConTest.viewSavedSchoolDetails("AUGSBURG");
		University school = DBCon.getUniversity("AUGSBURG");
		String timeAdded = "2019-03-23 16:06:20.0";

		ArrayList<String> expected = new ArrayList<String>();
		expected.add(school.getName());
		expected.add(school.getState());
		expected.add(school.getLocation());
		expected.add(school.getControl());
		expected.add(school.getEnrollment());
		expected.add(school.getPercentFemale());
		expected.add(school.getSatVerbal());
		expected.add(school.getSatMath());
		expected.add(school.getCost());
		expected.add(school.getPercentFinAid());
		expected.add(school.getApplicants());
		expected.add(school.getPercentAdmitted());
		expected.add(school.getAcademicScale());
		expected.add(school.getSocialScale());
		expected.add(school.getQualityOfLife());
		expected.add("BUSINESS-ADMINISTRATION");
		expected.add("EDUCATION");
		expected.add("PERFORMING-ARTS");
		
		expected.add(timeAdded);
		
		for(int i=0; i<schoolDetials.size(); i++)
		{
			System.out.println(schoolDetials.get(i)+ " "+expected.get(i));
			assertEquals(schoolDetials.get(i), expected.get(i));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testViewSavedSchoolDetailsFailsForInvalidSchoolName() {
		this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testViewUserSavedStatistics() {
//		String[] saveStatistics = this.studentConTest.viewUserSavedStatistics("YALE");
//		System.out.println(saveStatistics[0]);
//		System.out.println(saveStatistics[1]);
//		assertTrue(saveStatistics[0].equals("YALE") && saveStatistics[1].equals("2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testViewUserSavedStatisticsFailsForNonExistingSchool() {
		this.studentConTest.viewUserSavedStatistics("Lala Land");
	}

	@Test
	public void testCompareSchoolsByScore() {
		ArrayList<String> result = this.studentConTest.compareSchoolsByScore();
		ArrayList<String> expected = this.studentConTest.account.compareSchoolsByScore();
		assertEquals(result, expected);
	}

}

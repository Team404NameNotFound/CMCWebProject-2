import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.Student;
import cmc.entity.University;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;
import cmc.functionality.StudentFunctionalityController;
import cmc.interaction.AccountInteraction;
import cmc.interaction.StudentInteraction;

public class CompleteFunctionalTestClass {





	@Test
	public void UC1SucessfulLogin() {
		AccountInteraction ac = new AccountInteraction();
		assertTrue(ac.login("cz001", "password"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void UC1UnsuccessfulLogin() {
		AccountInteraction ac = new AccountInteraction();
		ac.login("DNE", "afsd");
	}
	
	@Test
	public void UC2Logout() {
		AccountInteraction ac = new AccountInteraction();
		ac.login("cz001", "password");
		assertTrue(ac.logout());
	}
	
	@Test
	public void UC3ForgotPassword() {
		
	}
	
	@Test
	public void UC5Search() {
		DBController dbCon = new DBController();
		AccountController user = new AccountController(dbCon.getAccount("kmendel001@csbsju.edu"));
		StudentInteraction student = new StudentInteraction();
		student.getSfCon().setAccount(user);
		
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
		ArrayList<University> result = student.fieldSearch(schoolName, state, location, numStudentsMin, numStudentsMax, percentFemaleMin
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
	public void UC6TakePersonalityQuiz() {
		DBController dbCon = new DBController();
		AccountController user = new AccountController(dbCon.getAccount("kmendel001@csbsju.edu"));
		StudentInteraction student = new StudentInteraction();
		student.getSfCon().setAccount(user);
		
		String location = "URBAN";
		String characteristic = "Social"; 
		String control = ""; 
		String[] emphases = {"Art"};
		student.takeQuiz(location, characteristic, control, emphases);
	}
	
	@Test
	public void UC8ViewSearchSchoolDetials() {
		DBController DBCon = new DBController();
		StudentFunctionalityController studentConTest = new StudentFunctionalityController();
		Account andrew = new Student("Andrew", "Heroux", "ajheroux@csbsju.edu", "38dgf", "u", "Y", null);
		DBCon.setAccount(andrew);
		studentConTest.login("ajheroux@csbsju.edu", "38dgf");
		
		ArrayList<String> schoolDetials = studentConTest.viewSchoolDetails("AUGSBURG");
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
	
}



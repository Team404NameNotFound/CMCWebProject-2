package cmc.interaction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;

public class AdminInteractionTest {
	private DBController dbController; 
	private AdminInteraction admin;
	
	@Before
	public void setUp() {
		dbController = new DBController();
		admin = new AdminInteraction();
		this.admin.afCon.setAccount(new AccountController(dbController.getAccount("nadmin")));
	}
	
	@After
	public void shutDown() {
		admin.logout();
	}

	/*@Test
	public void testAdminInteraction() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdminInteractionAdminFunctionalityController() {
		fail("Not yet implemented");
	}
*/

	/*@Test (expected = IllegalArgumentException.class) 
	public void testEditProfile_adminNotLoggedIn_case1() {
		admin.editProfile("cz001", "cf", "cl", "cp", "u", "Y");
	}*/
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminEnterEmpty_case2() {
		admin.login("nadmin", "Admin");
		admin.editProfile("", "", "", "", "", "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminNonExistingUsername_case3() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz002", "cf", "cl", "cp", "u", "Y");
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserType_case4() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "invalidUserType", "Y");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserStatus_case5() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "u", "invalidUserStatus");
	}
	
	@Test
	public void testEditProfile_adminEditProfileSuccessfully_case6() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "a", "Y"); //last Y
		String expFirstName = "cf";
		String expUserType = "a";
		String resultFirstName = (this.dbController.getAccount("cz001").getFirstName());
		String resultUserType= (this.dbController.getAccount("cz001").getUserType());
		assertEquals("Admin edit profile: first name" + expFirstName, expFirstName,resultFirstName );
		assertEquals("Admin edit profile: user type" + expUserType, expUserType,resultUserType );
		
	}

	/*@Test (expected = IllegalArgumentException.class)
	public void testToggleActivationStatus_adminNotLoggedIn_case1() {
		admin.toggleActivationStatus("cz001");
	}*/
	
	@Test (expected = NullPointerException.class)
	public void testToggleActivationStatus_adminToggleNonexsitingUser_case2() {
		admin.login("nadmin", "Admin");
		admin.toggleActivationStatus("ASDASD");
	}
	
	@Test (expected = NullPointerException.class)
	public void testToggleActivationStatus_adminEnterEmptyUserName_case3() {
		admin.login("nadmin", "Admin");
		admin.toggleActivationStatus("");
	}
	
	@Test
	public void testToggleActivationStatus_adminToggleActivationSuccessfully_case4() {
		admin.login("nadmin", "Admin");
		admin.toggleActivationStatus("cuser");
		String expResult = "Y";
		String result= (this.dbController.getAccount("cuser").getUserStatus());
		assertEquals("Admin toggle avtication status: " + expResult, expResult,result);
	}

	
	/*@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminNotLoggedIn_case1() {
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}*/
	
	//***************************************************EditUniversityInfo*******************************
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEditNonExistingSchool_case2() {
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("haha", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test
	public void testEditUniversityInfo_adminEnterEmpty_case3() {
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "", "",  "",
				 "", "",  "", "", 
				 "", "", "", "", 
				"", "", "", "", 
				new String[] {});
		String expResult = "-1";
		String result = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getControl();
		assertEquals("Admin edit ABILENE CHRISTIAN UNIVERSITY to be all empty:  " + expResult,expResult, result);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterInvalidControl_case4() { //STATE OR PRIVATE
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "Invalid Controll",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterNegativeNumofStudents_case5() { //-1,
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "-1", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterDecimalNumofStudents_case6() { //-1.2,
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "2.2", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterNegativePercentOfFemale_case7() { //-2
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "-50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterGreaterThanOnePercentOfFemale_case8() { //2.5
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "150",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterSATMathScoreLessThan200_case9() { // 100
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "100 ", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterSATMathScoreMoreThan800_case10() {
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "802 ", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterNegativeExpense_case11() { //negative or 0
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "-1", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterPercentFinancialAidEqualsToZero_case12() { // 0
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "0", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterInvalidNumOfApplicants_case13() { // not an integer
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "2.2", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterNotNumberPercentAdmitted_case15() { //enter a string
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"percentAdmitted", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	} 

	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterInvalidAcademicsScale_case16() { //not 1, 2, 3, 4, 5
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "8", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test
	public void testEditUniversityInfo_adminEnterInvalidEmphasis_case17() { 
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"InvalidEmphasis"});
		String[] expResult = new String[] {"InvalidEmphasis"};
		String[] result = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getEmphases();
		assertEquals("Admin edit emphases:  " + expResult,expResult, result);
	}
	
	@Test
	public void testEditUniversityInfo_adminEditSuccessfully_case18() { //This school's control was originally PRIVATE
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PUBLIC",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"InvalidEmphasis"});
		String expResult = "PUBLIC";
		String[] expResult2 = new String[] {"InvalidEmphasis"};
		String result = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getControl();
		String[] result2 = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getEmphases();
		assertEquals("Admin edit ABILENE CHRISTIAN UNIVERSITY to be all empty:  " + expResult,expResult, result);
		assertEquals("Admin edit emphases:  " + expResult2,expResult2, result2);
	}
	
	//***********************************************************************************************************************

	@Test
	public void testViewUsers() {
		admin.login("nadmin", "Admin"); 
		admin.viewUsers();
	}

	@Test
	public void testViewUniversities() {
		admin.login("nadmin", "Admin"); 
		admin.viewUniversities();
	}


	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversity_removeInvalidUniversity() {
		admin.login("nadmin", "Admin"); 
		admin.removeUniversity("yoyoyo");
	}
	
	@Test
	public void testRemoveUniversity_removeSuccessfully() {
		admin.login("nadmin", "Admin"); 
		admin.removeUniversity("ECOLE NATIONALE SUPERIEURE DE TELECOMMUNICATION DE PARIS");
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddNewUniversity_addExistingUniversity() {
		admin.addNewUniversity("YALE", "state", "location", "control", 
				"enrollment", "percentFemale", "satVerbal", "satMath", 
				"cost", "percentFinAid", "percentEnrolled", "applicants", 
				"percentAdmitted", "academicScale", "socialScale", 
				"qualityOfLife", new String[] {});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddNewUniversity_addInvalidUniversityControl() {
		admin.addNewUniversity("YAYAYAYAYAYA", "state", "location", "control", 
				"enrollment", "percentFemale", "satVerbal", "satMath", 
				"cost", "percentFinAid", "percentEnrolled", "applicants", 
				"percentAdmitted", "academicScale", "socialScale", 
				"qualityOfLife", new String[] {});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddNewUniversity_addInvalidUniversityPercentFemale() {
		admin.addNewUniversity("YAYAYAYAYAYA", "state", "location", "control", 
				"enrollment", "-111111", "satVerbal", "satMath", 
				"cost", "percentFinAid", "percentEnrolled", "applicants", 
				"percentAdmitted", "academicScale", "socialScale", 
				"qualityOfLife", new String[] {});
	}
	
	@Test
	public void testAddNewUniversity_addSuccessfully() {
		admin.addNewUniversity("aaaaa", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_studentAddUser_case1() {
		admin.afCon.setAccount(new AccountController(dbController.getAccount("kmendel001@csbsju.edu")));
		admin.addUser("newUser", "newUser", "newUser", "newUser", "a");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminNotLoggedIn_case2() {
		admin.addUser("testAddUser", "testAddUser", "testAddUser", "testAddUser", "a");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddExistingUsername_case3() {
		admin.login("nadmin", "Admin");
		admin.addUser("testAddUser", "testAddUser", "cuser", "testAddUser", "a");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddInvalidUserType_case4() {
		admin.login("nadmin", "Admin");
		admin.addUser("testAddUser", "testAddUser", "testAddUser", "testAddUser", "invalidUserType");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddEmptyUser_case5() {
		admin.login("nadmin", "Admin");
		admin.addUser("", "", "testAddUser", "", "a");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddEmptyUserName_case6() {
		admin.login("nadmin", "Admin");
		admin.addUser("testAddUser", "testAddUser", "", "testAddUser", "a");
	}
	
	@Test
	public void testAddUser_adminAddUserSuccessfully_case7() {
		admin.login("nadmin", "Admin");
		admin.addUser("testAddUser", "test", "thisIsANewUSER", "testAddUser", "a");
		String expResult = "thisIsANewUSER";
		String result = dbController.getAccount("thisIsANewUSER").getUsername();
	    assertEquals("Admin add new user" + expResult,expResult, result);
	}

}

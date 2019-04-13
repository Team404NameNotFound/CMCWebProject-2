package cmc.interaction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.University;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;

/**
 * @author tzhang001
 *
 */
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

	//*******************************EditProfile()***********************************************
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminEnterEmpty_case1() {
		admin.login("nadmin", "Admin");
		admin.editProfile("", "", "", "", "", "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminNonExistingUsername_case2() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz002", "cf", "cl", "cp", "u", "Y");
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserType_case3() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "invalidUserType", "Y");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserStatus_case4() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "u", "invalidUserStatus");
	}
	
	@Test
	public void testEditProfile_adminEditProfileSuccessfully_case5() {
		admin.login("nadmin", "Admin");
		admin.editProfile("juser", "Johnny", "User", "user", "u", "Y"); 
		String expFirstName = "Johnny";
		String expUserType = "u";
		String resultFirstName = (this.dbController.getAccount("juser").getFirstName());
		String resultUserType= (this.dbController.getAccount("juser").getUserType());
		assertEquals("Admin edit profile: first name" + expFirstName, expFirstName,resultFirstName );
		assertEquals("Admin edit profile: user type" + expUserType, expUserType,resultUserType );
		
	}
	
	//************************************AddUser()***************************************************
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddExistingUsername_case1() {
		admin.login("nadmin", "Admin");
		admin.addUser("juser", "testAddUser", "cuser", "testAddUser", "a");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddInvalidUserType_case2() {
		admin.login("nadmin", "Admin");
		admin.addUser("jj", "testAddUser", "testAddUser", "testAddUser", "invalidUserType");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUser_adminAddEmptyUser_case3() {
		admin.login("nadmin", "Admin");
		admin.addUser("", "", "aaNewUser", "", "a");
	}

	@Test
	public void testAddUser_adminAddUserSuccessfully_case4() {
		admin.login("nadmin", "Admin");
		admin.addUser("testAddUser", "test", "AHappyGal", "testAddUser", "a");
		String expResult = "AHappyGal";
		String result = dbController.getAccount("AHappyGal").getUsername();
	    assertEquals("Admin add new user" + expResult,expResult, result);
	}

	//************************************ViewUsers()***************************************************
	
	@Test
	public void testViewUsers() {
		admin.login("nadmin", "Admin"); 
		int result = admin.viewUsers().size();
		int expResult = this.dbController.getAccountList().size(); 
		assertEquals("Admin view users" + expResult,expResult, result);
		
	}
	
	//************************************ViewUniversities()***************************************************
	
	@Test
	public void testViewUniversities() {
		admin.login("nadmin", "Admin"); 
		int result = admin.viewUniversities().size();
		int expResult = this.dbController.getUniversityList().size();
		assertEquals("Admin view users" + expResult,expResult, result);
		
	}
	
	//**********************************toggleActivationStatus()*************************************************
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testToggleActivationStatus_adminToggleNonexsitingUser_case1() {
		admin.login("nadmin", "Admin");
		admin.toggleActivationStatus("buladddnON");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testToggleActivationStatus_adminEnterEmptyUserName_case2() {
		admin.login("nadmin", "Admin");
		admin.toggleActivationStatus("");
	}
	
	@Test
	public void testToggleActivationStatus_adminToggleActivationSuccessfully_case3() {
		admin.login("nadmin", "Admin");
		String currentStatus = this.dbController.getAccount("green@csbsju.edu").getUserStatus();
		String expResult;
		if(currentStatus.equals("N")) {
			expResult = "Y";
		}else {
			expResult = "N";
		}
		admin.toggleActivationStatus("green@csbsju.edu");
		String result= (this.dbController.getAccount("green@csbsju.edu").getUserStatus());
		assertEquals("Admin toggle avtication status: " + expResult, expResult,result);
	}
	
	
	//**********************************editUniversityInfo*************************************************
	
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
	public void testEditUniversityInfo_adminEnterSATMathScoreLessThan200_case9() {  //100
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
	public void testEditUniversityInfo_adminEnterPercentFinancialAidEqualsToZero_case12() {  //0
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "0", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditUniversityInfo_adminEnterInvalidNumOfApplicants_case13() {  //not an integer
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
	public void testEditUniversityInfo_adminEnterOneEmphasis_case17() { 
		admin.login("nadmin", "Admin");
		admin.editUniversityInfo("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN",  "PRIVATE",
				 "10000", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"OneEmphasis"});
		String[] expResult = new String[] {"OneEmphasis"};
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
				new String[] {"BIOLOGY"});
		String expControll = "PUBLIC";
		String[] expResultEmpha = new String[] {"BIOLOGY"};
		String resultControll = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getControl();
		String[] resultEmpha = this.dbController.getUniversity2("ABILENE CHRISTIAN UNIVERSITY").getEmphases();
		assertEquals("Admin edit ABILENE CHRISTIAN UNIVERSITY controll  " + expControll,expControll, resultControll);
		assertEquals("Admin edit emphases:  " + expResultEmpha,expResultEmpha, resultEmpha);
	} 
	//**********************************addNewUniversity()*************************************************
	
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
		admin.addNewUniversity("YAYAYAYAYAYA", "state", "location", "invalidControll", 
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
		admin.addNewUniversity("AAAAASCHOOL", "NOTTEXAS", "SUBURBAN",  "PRIVATE",
				 "10011", "50",  "", "", 
				 "12088", "70", "80", "4000", 
				"90", "2", "3", "3", 
				new String[] {"ACCOUNTING", "BIOLOGY"});
		String expControll = "PRIVATE";
		String[] expResultEmpha = new String[] {"ACCOUNTING", "BIOLOGY"};
		String resultControll = this.dbController.getUniversity2("BBBSCHOOL").getControl();
		String[] resultEmpha = this.dbController.getUniversity2("BBBSCHOOL").getEmphases();
		assertEquals("Admin add a new university  " + expControll,expControll, resultControll);
		assertEquals("Admin add a new university  " + expResultEmpha,expResultEmpha, resultEmpha);
		
	} 
	
	//**********************************removeUniversity()*************************************************
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversity_removeInvalidUniversity() {
		admin.login("nadmin", "Admin"); 
		admin.removeUniversity("yoyoyoyoyoyoyoyoyoyoyoyo");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversityWithEmphases_() {
		admin.login("nadmin", "Admin"); 
		admin.removeUniversity("BBSCHOOL");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveSavedUniversity() {
		admin.login("nadmin", "Admin"); 
		admin.removeUniversity("BROWN");
	}
	
	public void testRemoveUniversity_removeSuccessfully() {
		admin.login("nadmin", "Admin");
		admin.addNewUniversity(
		"BBBSCHOOL", "NOTTEXAS", "SUBURBAN",  "PRIVATE",
		 "10011", "50",  "", "", 
		 "12088", "70", "80", "4000", 
		"90", "2", "3", "3", 
		new String[] {"ACCOUNTING", "BIOLOGY"});
		//admin.removeUniversity("TESTdELETE");
	}
	

}

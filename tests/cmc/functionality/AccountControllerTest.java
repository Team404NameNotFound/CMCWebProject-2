package cmc.functionality;

import cmc.entity.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AccountControllerTest {
	private AccountController user;
	private AccountController user2;
	private AccountController admin;
	private AccountController noSavedSchoolUser;
	private DBController dbController = new DBController();

	@Before
	public void setUp() throws Exception {
		user = new AccountController(dbController.getAccount("cuser"));
		user2 = new AccountController(dbController.getAccount("kmendel001@csbsju.edu"));
		user.removeAllSavedSchools();
		admin = new AccountController(dbController.getAccount("nadmin"));
		noSavedSchoolUser = new AccountController(dbController.getAccount("juser"));

		dbController.getAccount("kmendel001@csbsju.edu").setPassword("user");
		dbController.getAccount("kmendel001@csbsju.edu").setUserStatus("N");

	}

	/*
	 * @Test public void testAccountControllerAccount() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testAccountController() { fail("Not yet implemented"); }
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testCheckIfSchoolSaved_invalidSchool_case1() {
		user.checkIfSchoolSaved("-1");
	}

	@Test
	public void testCheckIfSchoolSaved_savedSchool_case2() {
		user.saveSchool("EMORY");
		Boolean expResult = true;
		assertTrue("Check if school saved", expResult.equals(user.checkIfSchoolSaved("EMORY")));
	}

	@Test
	public void testCheckIfSchoolSaved_unsavedSchool_case3() {
		Boolean expResult = false;
		assertTrue("Check if school is not saved", expResult.equals(user.checkIfSchoolSaved("AUGSBURG")));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCheckIfSchoolSaved_invalidAccount_case4() {
		admin.checkIfSchoolSaved("BROWN");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testViewSavedSchools_invalidAccount_case1() {
		admin.viewSavedSchools();
	}

	@Test
	public void testViewSavedSchools_noSavedSchools_case2() {
		user.viewSavedSchools();
	}

	@Test
	public void testViewSavedSchools_hasSavedSchools_case3() {
		user.saveSchool("VASSAR");
		user.saveSchool("YALE");
		int expResult = 2;
		int result = user.viewSavedSchools().size();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_invalidSchool_case1() {
		user.saveSchool("notExistingSchool");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_invalidAccount_case2() {
		admin.saveSchool("YALE");
	}

	@Test
	public void testSaveSchool_saveSchoolSuccess_case3() {
		Boolean expResult = true;
		Boolean result = user.saveSchool("CORNELL");
		;
		assertEquals("Save a school successfully " + expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_saveSameSchoolTwice_case4() {
		user.saveSchool("HARVARD");
		user.saveSchool("HARVARD");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchool_invalidAccount_case1() {
		admin.removeSavedSchool("YALE");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchool_invalidSchool_case2() {
		user.removeSavedSchool("hahahahaYeah");
	}

	@Test
	public void testRemoveSavedSchool_schoolHasNotBeenSaved_case3() {
		Boolean expResult = false;
		Boolean result = user.removeSavedSchool("AUGSBURG");
		;
		assertEquals("Cannot remove an unsaved School " + expResult, expResult, result);
	}

	@Test
	public void testRemoveSavedSchool_removeSavedSchoolSuccessful_case4() {
		user.saveSchool("BARD");
		Boolean result = user.removeSavedSchool("BARD");
		Boolean expResult = true;
		assertEquals("The saved school is being removed: " + expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCompareSchoolsByScore_invalidAccount_case1() {
		admin.compareSchoolsByScore();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCompareSchoolsByScore_noSchoolsToCompare_case2() {
		noSavedSchoolUser.compareSchoolsByScore();
	}

	@Test
	public void testCompareSchoolsByScore_oneSchoolToCompare_case3() {
		user.saveSchool("VASSAR");
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add("VASSAR 600.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test
	public void testCompareSchoolsByScore_moreThanOneSchoolToCompare_case4() {
		user.saveSchool("BOSTON COLLEGE");
		user.saveSchool("BROWN");
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add("BOSTON COLLEGE 550.0");
		expResult.add("BROWN 650.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test
	public void testCompareSchoolsByScore_savedSchoolDoesNotHaveSATMathScore_case5() {
		user.saveSchool("ABILENE CHRISTIAN UNIVERSITY"); // sat score is -1
		user.saveSchool("BOSTON COLLEGE");
		user.saveSchool("BROWN");
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("BOSTON COLLEGE 550.0");
		expResult.add("BROWN 650.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test(expected = NullPointerException.class)
	public void testToggleActivationStatusNullAccount() {
		admin = new AccountController(dbController.getAccount("fake"));
		admin.toggleActivationStatus();
	}

	@Test
	public void testToggleActivationStatusNtoY() {
		Account userCheck = dbController.getAccount("kmendel001@csbsju.edu");
		userCheck.setUserStatus("N");
		dbController.setAccount(userCheck);
		user2.toggleActivationStatus();
		String result = dbController.getAccount("kmendel001@csbsju.edu").getUserStatus();
		String expResult = "N";
		assertEquals("User is now " + result, expResult, result);
	}

	@Test
	public void testToggleActivationStatusYtoN() {
		Account userCheck = dbController.getAccount("kmendel001@csbsju.edu");
		userCheck.setUserStatus("Y"); //y
		dbController.setAccount(userCheck);
		user2.toggleActivationStatus();
		String result = dbController.getAccount("kmendel001@csbsju.edu").getUserStatus();
		String expResult = "Y";
		assertEquals("User is now " + result, expResult, result);
	}

	@Test(expected = NullPointerException.class)
	public void testUpdatePasswordNullnewPassword() {
		String newPassword = null;
		user2.updatePassword(newPassword);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdatePasswordEmptynewPassword() {
		String newPassword = "";
		user2.updatePassword(newPassword);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdatePasswordSamenewPassword() {
		String newPassword = dbController.getAccount("kmendel001@csbsju.edu").getPassword();
		user2.updatePassword(newPassword);

	}

	@Test
	public void testUpdatePasswordValidnewPassword() {
		String newPassword = "password";
		String expResult = "password";
		String oldPassword = dbController.getAccount("kmendel001@csbsju.edu").getPassword();
		user2.updatePassword(newPassword);
		String result = dbController.getAccount("kmendel001@csbsju.edu").getPassword();
		user2.updatePassword(oldPassword);
		assertEquals("Password is now " + result, expResult, result);
	}

	@Test
	public void testCreateNewAccountTypeUser() {
		ArrayList<UserSavedSchool> savedSchools = new ArrayList<UserSavedSchool>();
		Account result = admin.createNewAccount("Andrew", "Heroux", "ajheroux@csbsju.edu", "HappySunfish45", "u",
				savedSchools);
		Account expected = new Student("Andrew", "Heroux", "ajheroux@csbsju.edu", "HappySunfish45", "u", "Y",
				savedSchools);
		assertEquals(result, expected);
	}

	@Test
	public void testCreateNewAccountTypeAdmin() {
		ArrayList<UserSavedSchool> savedSchools = new ArrayList<UserSavedSchool>();
		Account result = admin.createNewAccount("Andrew", "Heroux", "ajheroux@csbsju.edu", "GoodPassword", "a",
				savedSchools);
		Account expected = new Admin("Andrew", "Heroux", "ajheroux@csbsju.edu", "GoodPassword", "a", "Y");
		assertEquals(result, expected);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAccountInvalidUserType() {
		ArrayList<UserSavedSchool> savedSchools = new ArrayList<UserSavedSchool>();
		admin.createNewAccount("Andrew", "Heroux", "ajheroux@csbsju.edu", "GoodPassword", "HAha", savedSchools);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCheckPassword_emptyPassword_case1() {
		user.checkPassword("");
	}

	@Test
	public void testCheckPassword_wrongPassword_case2() {
		Boolean result = user.checkPassword("cuser");
		Boolean expResult = false;
		assertEquals("Check wrong password: " + expResult, expResult, result);
	}

	@Test
	public void testCheckPassword_correctPassword_case3() {
		Boolean result = user.checkPassword("user");
		Boolean expResult = true;
		assertEquals("Check corrent password: " + expResult, expResult, result);
	}

	@Test
	public void testMakeRandomPasswor() {
		int result = user.makeRandomPassword().length();
		int expResult = 5;
		assertEquals(" Make random password: " + expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUpdateUserInfo_invalidType_case1() {
		user.updateUserInfo("updated", "updated", "updated", "Y", "updated");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUpdateUserInfo_invalidStatus_case2() {
		user.updateUserInfo("updated", "updated", "updated", "updated", "u");
	}

	@Test
	public void testUpdateUserInfo_unchangeUserInfo_case3() {
		String expFN = user.account.getFirstName();
		String expLN = user.account.getLastName();
		String expP = user.account.getPassword();
		String expS = user.account.getUserStatus();
		String expT = user.account.getUserType();
		user.updateUserInfo("", "", "", "", "");
		String resultFN = user.account.getFirstName();
		String resultLN = user.account.getLastName();
		String resultP = user.account.getPassword();
		String resultS = user.account.getUserStatus();
		String resultT = user.account.getUserType();
		assertEquals("Update fist name is now " + resultFN, expFN, resultFN);
		assertEquals("Update last name is now " + resultLN, expLN, resultLN);
		assertEquals("Update password  is now " + resultP, expP, resultP);
		assertEquals("Update status  is now " + resultS, expS, resultS);
		assertEquals("Update type  is now " + resultT, expT, resultT);

	}

	@Test
	public void testUpdateUserInfo_updateUserLastname_case4() {
		String expLN = "updatedLastName";
		user.updateUserInfo("", "updatedLastName", "", "", "");
		String resultLN = user.account.getLastName();
		assertEquals("Update last name is now " + resultLN, expLN, resultLN);
	}

	@Test
	public void testUpdateUserInfo_updateUserStatus_case5() {
		String expS = "Y";
		admin.updateUserInfo("", "", "", "y", "");
		String resultS = admin.account.getUserStatus();
		assertEquals("Update last name is now " + resultS, expS, resultS);
	}

	/*
	 * 
	 * @Test public void testSendEmail() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdateUserInfo() { fail("Not yet implemented"); }
	 * 
	 */

}

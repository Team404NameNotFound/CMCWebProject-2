package cmc.interaction;

import java.util.ArrayList;
import cmc.entity.*;

import cmc.functionality.UserFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class AccountInteraction {

	protected UserFunctionalityController UFCon = new UserFunctionalityController();
	protected Boolean isLoggedIn = false;
	//protected String un = null;
//	/**
//	 * Create a new AccountInteraction
//	 */
	public AccountInteraction() {
		
	}

	/**
	 * Create a new AccountInteraction with a given UserFunctionalityController
	 * 
	 * @param UFCon
	 */
	public AccountInteraction(UserFunctionalityController UFCon) {
		this.UFCon = UFCon;
	}

	/**
	 * Student or Admin log in.
	 * 
	 * @param String
	 *            username
	 * @param String
	 *            password
	 */
	public int login(String username, String password) {
		this.isLoggedIn = true;
		return this.UFCon.login(username, password);

	}

	public boolean getLoggedIn() {
		Boolean loginStatus = this.isLoggedIn;
		return loginStatus;
	}
	
	/**
	 * View a school's detail information
	 * 
	 * @param univeristyName
	 * @return
	 */
	public ArrayList<String> viewSchoolDetails(String univeristyName) {
		ArrayList<String> school = UFCon.viewUniversityDetials(univeristyName);
//		System.out.print(school);
		return school;
	}

	/**
	 * Displays the profile of the specified user
	 * 
	 * @param userName
	 */
	public ArrayList<String> viewProfile(String userName) {
		ArrayList<String> userInfo = UFCon.viewUserProfile(userName);
		// System.out.println("User info gotten for: " + userInfo.get(0));
		return userInfo;
		// for (int i = 0; i < userInfo.size(); i++) {
		// System.out.println("" + userInfo.get(i));
		// }
	}

	/**
	 * Updates the first name, last name, and password for the specified user
	 * 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public ArrayList<String> editProfile(String userName, String firstName, String lastName, String password, String userType, String activeStatus) {
		//if (firstName == "" || lastName == "" || password == "" || userType == "" || activeStatus == "") {
		if (firstName.length() < 1 || lastName.length() < 1 || password.length() < 1 || userType.length() < 1 || activeStatus.length() < 1) {
			throw new IllegalArgumentException("Sorry, the field cannot be empty");
		}else if (!userType.equals("a") && !userType.equals("u")) {
			throw new IllegalArgumentException("Sorry, User Type needs to be u or a");
		}else if(!activeStatus.equals("Y") && !activeStatus.equals("N")){
			throw new IllegalArgumentException("Sorry, User status need to be Y or N");
		}else {
			return UFCon.editUserProfile(userName, firstName, lastName, password, userType, activeStatus);
		}
	}

	/**
	 * Logs out the currently logged in user
	 */
	public boolean logout() {
		isLoggedIn = false;
		return this.UFCon.logout();
	}

	/**
	 * Generates a random password then sets it as the specified user and sends it
	 * to the email address of that user
	 * 
	 * @param username
	 */
	public int forgotPsw(String usrName) {
		return this.UFCon.forgotPassword(usrName);
	}

	/**
	 * Displays information about all schools in the database
	 */
	public ArrayList<University> viewSchoolList() {
		ArrayList<University> universityList = this.UFCon.viewSchoolList();
		for (int index = 0; index < universityList.size(); index++) {

			String[] emphases = universityList.get(index).getEmphases();
			for (int i = 0; i < emphases.length; i++) {
				System.out.print(" " + emphases[i]);
			}

		}
		return universityList;
	}
	
	public void setUfCon(String username) {
		this.UFCon.setAccount(username);
	}
	//Imad told us to get Account information through this way, instead of getParameter()
	public void setAccount(String username) {
		this.UFCon.setAccount(username);
	}
	
	public Account getAccount() {
		return this.UFCon.getAccount();
	}
}

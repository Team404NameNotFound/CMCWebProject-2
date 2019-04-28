package cmc.functionality;

import cmc.entity.*;
import java.util.ArrayList;

/**
 * 
 * @author ajheroux
 *
 */
public class UserFunctionalityController {

	// Making instance variables
	DBController DBCon = new DBController();
	AccountController account;// = new AccountController();
	UniversityController universityCon;
	public Boolean loggedIn;

	/**
	 * class constructor
	 */
	public UserFunctionalityController() {
		this.account = new AccountController();
		this.universityCon = new UniversityController();
		this.loggedIn = false;
	}

	// /**
	// * Get the current UniversityController
	// * @return the universityCon
	// */
	// public UniversityController getUniversityCon() {
	// return universityCon;
	// }
	//
	// /**
	// * Set the current UniversityController
	// * @param universityCon the universityCon to set
	// */
	// public void setUniversityCon(UniversityController universityCon) {
	// this.universityCon = universityCon;
	// }

	/**
	 * Log on checks to see if the the user is logged in and is an active user. If
	 * both are true, the password and user name are verified and the user is logged
	 * in.
	 * 
	 * @param userName
	 * @param password
	 * @return true in log on is successful
	 */
	public int login(String userName, String password) {
		if (userName == null || password == null) {
			throw new IllegalArgumentException("Sorry, one or more fields are empty");
		}
		if (!loggedIn) {
			if (this.DBCon.checkUser(userName)) {
				if (this.DBCon.getAccount(userName).getUserStatus().equals("Y")) {
					AccountController userAcc = new AccountController(this.DBCon.getAccount(userName));
					if (userAcc.checkPassword(password)) {
						account = new AccountController(this.DBCon.getAccount(userName));
						this.loggedIn = true;
						return 0;
					} else {
						throw new IllegalArgumentException("Sorry, invalid password");

					}
				} else {
					throw new IllegalArgumentException("Sorry, user is inactive");
				}
			} else {
				throw new IllegalArgumentException("Sorry, invalid username");

			}
		}
		throw new IllegalArgumentException("User is inactive");
	}

	/**
	 * Checks if the the user is logged in and if not logs out
	 */
	public boolean logout() {
		if (loggedIn) {
			this.account = null;
			this.loggedIn = false;

		}
		return true;
	}

	/**
	 * Finds the information of a specified user and prints the users details
	 * 
	 * @param userName
	 */
	public ArrayList<String> viewUserProfile(String userName) {
		// get rid of A IF
		if (this.DBCon.checkUser(userName)) {

			Account userAcc = this.DBCon.getAccount(userName);
			ArrayList<String> profile = new ArrayList<String>();
			profile.add(userAcc.getFirstName());
			profile.add(userAcc.getLastName());
			profile.add(userAcc.getUsername());
			profile.add(userAcc.getPassword());
			profile.add(userAcc.getUserType());
			profile.add(userAcc.getUserStatus());

			return profile;
		} else {
			throw new IllegalArgumentException(userName + " does not exist in the database!");
		}
	}

	/**
	 * Updates the first name, last name and password of the specified user
	 * 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public ArrayList<String> editUserProfile(String userName, String firstName,  String lastName, String password,
			String userType, String activeStatus) {

		account = new AccountController(this.DBCon.getAccount(userName));
		if (this.DBCon.getAccount(userName) == null) 
		{
			throw new IllegalArgumentException("Valid User needed");
		} 
		else 
		{
			Account userAcc = account.updateUserInfo(firstName, lastName, password, userType, activeStatus);

			this.DBCon.setAccount(userAcc);
			ArrayList<String> updatedAccount= new ArrayList<String>();
			updatedAccount.add(userAcc.getFirstName());
			updatedAccount.add(userAcc.getLastName());
			updatedAccount.add(userAcc.getUsername());
			updatedAccount.add(userAcc.getPassword());
			updatedAccount.add(userAcc.getUserType());
			updatedAccount.add(userAcc.getUserStatus());
			return updatedAccount;
		}

	}

	/**
	 * Displays information for all schools in the database the information
	 * displayed is different for admins and students
	 */
	public ArrayList<University> viewSchoolList() {
		ArrayList<University> universityList = this.DBCon.getUniversityList();
		return universityList;
	}

	/**
	 * The password for a specified user is changed to a random password. The new
	 * password is sent to the users email(username)
	 * 
	 * @param userName
	 */
	public int forgotPassword(String userName) {
		if (!loggedIn) {
			if (this.DBCon.checkUser(userName)) {
				AccountController userAcc = new AccountController(this.DBCon.getAccount(userName));
				String rndPassword = userAcc.makeRandomPassword();
				userAcc.account.setPassword(rndPassword);
				this.DBCon.setAccount(userAcc.account);
				String emailMessage = "Hello " + userAcc.account.getFirstName()
						+ ",\n\nYour password has been updated to " + rndPassword + ".\n\nPlease update "
						+ "your password using the provided temporary password.\n\nCMC.com";
				userAcc.sendEmail(emailMessage, userAcc.account.getUsername());
				return 0;
			} else {
				throw new IllegalArgumentException("Sorry, invalid email address");
			}
		}
		throw new IllegalArgumentException("Sorry, invalid email address");
	}

	/**
	 * Returns a list of all details for a specified school
	 * 
	 * @param universityName
	 * @return
	 */
	public ArrayList<String> viewUniversityDetials(String universityName) {
		University university = this.DBCon.getUniversity2(universityName);
		if (university == null) {
			throw new IllegalArgumentException("University Does not exist");

		} else {
			universityCon = new UniversityController(university);
			return universityCon.getSchoolDetails();
		}
	}

	// /**
	// * Confirms that a password matches with the currently logged in user
	// * @param password
	// * @return
	// */
	// public Boolean checkPassword(String password) {
	// if (this.loggedIn) {
	// if (this.account.checkPassword(password)) {
	// return true;
	// }
	// else {
	// return false;
	// }
	// }
	// else {
	// return false;
	// }
	// }

	/**
	 * Get the current AccountController
	 * 
	 * @return
	 */
	public Account getAccount() {
		return this.account.account;
	}

	/**
	 * Set the current AccountController
	 * 
	 * @param account
	 */
	public void setAccount(AccountController account) {
		this.account = account;
	}
	
	public void setAccount(String username) {
		if(this.account == null) {
			throw new NullPointerException("The account controller in UserFunctionalityController is null");
		}
		this.account.setAccount(username);
	}

}

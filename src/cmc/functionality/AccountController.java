/**
 * 
 */
package cmc.functionality;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

import cmc.entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author kmendel001
 *
 */
public class AccountController {
	protected DBController dbController = new DBController();
	protected Account account; //= new Account(); // ??

	/**
	 * creates new AccountController object
	 * 
	 * @param Account
	 *            student being accessed
	 */
	public AccountController(Account account) {
		if (account == null) {
			System.out.println("Sorry, account cannot be null");
		} else {
			this.account = account;
		}
	}

	/**
	 * creates new AccountController object
	 */
	public AccountController() {

	}

	public void setAccount(String username) {
		Account currentAccount = this.dbController.getAccount(username);
		this.account = currentAccount;
		System.out.println("Account Controller this.account: "+ this.getAccount().getUsername());
	}

	public Account getAccount() {
		return this.account;
	}

	/**
	 * Returns list of all schools
	 * 
	 * @return
	 * @return schoolList list of schools the student has on saved school list
	 */
	public ArrayList<UserSavedSchool> viewSavedSchools() {
		// if (this.account.getUserType().equals("a"))
		// throw new UnsupportedOperationException("Current account is an admin");
		// else {
		System.out.println("Account Controller this.viewSavedSchools: "+ this.getAccount());
		for (University savedSchool : this.dbController.getSchoolList2(this.account)) {
			System.out.println(savedSchool.getName());
		}
		// }

		return this.dbController.getSchoolList2(this.account);
	}

	/**
	 * Checks to see if any student has saved the specified school
	 * 
	 * @param University
	 *            university user is trying to save
	 * @return boolean true if school already saved, else false
	 */
	public boolean checkIfSchoolSaved(String school) {
		if (this.account == null)
			throw new NullPointerException();
		else if (this.account.getUserType().equals("a"))
			throw new UnsupportedOperationException("Current account is an admin");
		else {
			if (this.dbController.getUniversity2(school) == null) {
				throw new UnsupportedOperationException("Invalid school name");
			}
			boolean saved = false;
			for (University savedSchool : this.dbController.getSchoolList2(this.account)) {
				if (savedSchool.getName().equals(school)) {
					saved = true;
				}
			}
			return saved;
		}
	}

	/**
	 * Toggles the status of the current user
	 * 
	 * @return Account account with activation status changed
	 */
	public Account toggleActivationStatus() {
		if (this.account.getUserStatus().equals("N")) {
			this.account.setUserStatus("Y");
			this.dbController.editAccount(account.getUsername(), account.getFirstName(), account.getLastName(),
					account.getPassword(), account.getUserType(), "Y");
			this.dbController.setAccount(this.account);
		} else {
			this.account.setUserStatus("N");
			this.dbController.editAccount(account.getUsername(), account.getFirstName(), account.getLastName(),
					account.getPassword(), account.getUserType(), "N");
			this.dbController.setAccount(this.account);
		}
		return this.account;
	}

	/**
	 * Checks if the password matches for the current user
	 * 
	 * @param password
	 *            password for the account trying to log in
	 * @return boolean true if password matches, else false
	 */
	public boolean checkPassword(String password) {
		// check to see if passwords match, if they do not then returns false
		if (password.equals("") || password.equals(null)) {
			throw new IllegalArgumentException("sorry, you need to provide a valid password");
		}

		if (this.account.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Randomly generates a password
	 * 
	 * @return randomPassword password generated to be sent to user and added to
	 *         profile
	 */
	public String makeRandomPassword() {
		String newPass = "";
		String[] character = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (int i = 0; i < 5; i++) {
			int newChar = (int) ((int) 35 * Math.random());
			newPass = newPass + character[newChar];
			// System.out.println(newPass);;
		}
		return newPass;
	}

	/**
	 * Updates the password of the current user
	 * 
	 * @param newPassword
	 *            new password to be put in to account
	 */
	public Account updatePassword(String newPassword) {
		if (newPassword.equals(null) || newPassword.equals("")) {
			throw new IllegalArgumentException("Sorry, new password has to have characters");
		} else if (newPassword.equals(dbController.getAccount(account.getUsername()).getPassword())) {
			throw new IllegalArgumentException("Sorry, new password has to be different from existing password");
		} else {
			account.setPassword(newPassword);
			dbController.setAccount(account);
		}
		return account;
	}

	/**
	 * Sends an email to the current user
	 * 
	 * @param message
	 *            content of email to send to user containing randomly generated
	 *            password
	 */
	public boolean sendEmail(String emailMessage, String emailAddress) {
		boolean sent = false;
		String host = "127.0.0.1";
		final String user = "csbsju.cmc@gmail.com";
		final String password = "jumpingfrog12";

		String to = emailAddress;

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		if (emailAddress.contains("@") && emailMessage != null) {
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("CMC Password Reset");
				message.setText(emailMessage);

				// send the message
				Transport.send(message);

				sent = true;

				return sent;
			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Updates the first name, last name, password, type, and status of the current
	 * user
	 * 
	 * @param fName
	 *            first name associated with account
	 * @param lName
	 *            last name associated with account
	 * @param password
	 *            password associated with account
	 * @param type
	 *            whether account is admin or user
	 * @param status
	 *            active status of user
	 * @return Account account with information edited
	 */
	public Account updateUserInfo(String fName, String lName, String password, String type, String status) {
		if (!fName.equals("") && fName != null) 
		{
			account.setFirstName(fName);
		}
		if (!lName.equals("") && lName != null) 
		{
			account.setLastName(lName);
		}
		if (!password.equals("") && password != null) 
		{
			account.setPassword(password);
		}
		if (!type.equals("") && type != null) {

				if (type.equals("u") || type.equals("U")) 
				{
					account.setUserType("u");
				} 
				else if (type.equals("a") || type.equals("A")) 
				{
					account.setUserType("a");
				} 
				else 
				{
					throw new UnsupportedOperationException("Account type can only be \" a\" or  \"u\" ");
				}
			
		}
		if (!status.equals("") && status != null) 
		{
			if (status.equals("Y") || status.equals("y")) 
			{
				account.setUserStatus("Y");
			} 
			else if (status.equals("N") || status.equals("n")) 
			{
				account.setUserStatus("N");
			} 
			else 
			{
				System.out.println(status);
				throw new UnsupportedOperationException("Account status can only be \" N\" or  \" Y\" ");
			}
		}
		return account;

	}

	/**
	 * Saves the specified school to the current users saved school list
	 * 
	 * @param schoolToSave
	 *            school user would like to add to saved school list
	 */
	public Boolean saveSchool(String school) {
		Boolean saved = false;
		University schoolToSave = dbController.getUniversity2(school);

		if (schoolToSave == null) {
			throw new UnsupportedOperationException("Invalid school to save");
		}
		if (this.account == null || this.account.getUserType().equals("a")) {
			throw new UnsupportedOperationException("Invalid account to save school");
		}
		for (University savedUni : this.dbController.getSchoolList2(this.account)) {
			if (savedUni.getName().equals(school)) {
				throw new UnsupportedOperationException("This school has already been saved");
			}
		}
		this.dbController.saveShool(account.getUsername(), school);
		saved = true;
		return saved;

	}

	/**
	 * Remove a saved school
	 * 
	 * @param school
	 */
	public Boolean removeSavedSchool(String school) {
		ArrayList<UserSavedSchool> savedSchools = this.dbController.getSchoolList2(this.account);
		University schoolToRemove = dbController.getUniversity2(school);
		if (this.checkIfSchoolSaved(school)) {
			if (schoolToRemove == null) {
				throw new UnsupportedOperationException("Invalid school to remove");
			}

			if (account == null || account.getUserType().equals("a")) {
				throw new UnsupportedOperationException("Invalid account to remove a saved school");
			}

			Boolean removed = false;
			for (University savedSchool : savedSchools) {
				if (savedSchool.getName().equals(school)) {
					removed = true;
					this.dbController.removeSavedSchool(account.getUsername(), school);
				}
			}
			return removed;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Creates a new account with the specified parameters
	 * 
	 * @param fName
	 *            first name associated with account
	 * @param lName
	 *            last name associated with account
	 * @param userName
	 *            user name associated with account
	 * @param password
	 *            password associated with account
	 * @param type
	 *            whether account is admin or user
	 * @param savedSchools
	 *            list of schools user has saved
	 * @return
	 */

	public Account createNewAccount(String fName, String lName, String userName, String password, String type,
			ArrayList<UserSavedSchool> savedSchools) {
		if (type.equals("a")) {
			account = new Admin(fName, lName, userName, password, type, "Y");
			return account;
		} else if (type.equals("u")) {
			account = new Student(fName, lName, userName, password, type, "Y", savedSchools);
			return account;
		} else {
			throw new IllegalArgumentException("Sorry you need to specify the type of user.");
		}
	}

	// comparing SAT math for now
	/**
	 * Compare saved schools with their satMath scores
	 */
	public ArrayList<String> compareSchoolsByScore() {

		if (this.account == null || this.account.getUserType().equals("a")) {
			throw new UnsupportedOperationException("Invalid account to compare scores");
		}

		ArrayList<UserSavedSchool> savedSchools = dbController.getSchoolList2(this.account);

		if (savedSchools.size() == 0) {
			throw new UnsupportedOperationException("No saved school to compare scores");
		}

		double[][] scores = new double[savedSchools.size()][2];
		ArrayList<String> returnList = new ArrayList<>();

		String[] savedSchoolNames = new String[savedSchools.size()];
		for (int i = 0; i < savedSchools.size(); i++) {
			scores[i][0] = Double.parseDouble(savedSchools.get(i).getSatMath());
			scores[i][1] = Double.parseDouble("" + i);
			savedSchoolNames[i] = savedSchools.get(i).getName();
		}

		java.util.Arrays.sort(scores, new java.util.Comparator<double[]>() {
			public int compare(double[] a, double[] b) {
				return Double.compare(a[0], b[0]);
			}
		});

		for (int j = 0; j < scores.length; j++) {
			int order = (int) Math.round(scores[j][1]);
			if (scores[j][0] != -1.0) {
				returnList.add(savedSchoolNames[order] + " " + scores[j][0]);
			}
		}

		return returnList;
	}

	public boolean removeAllSavedSchools() {
		ArrayList<UserSavedSchool> savedSchools = this.dbController.getSchoolList2(this.account);

		if (account == null || account.getUserType().equals("a")) {
			throw new UnsupportedOperationException("Invalid account to remove a saved school");
		}

		if (savedSchools.size() == 0) {
			return false;
		}

		for (University savedSchool : savedSchools) {
			this.dbController.removeSavedSchool(account.getUsername(), savedSchool.getName());
		}

		return true;
	}

}

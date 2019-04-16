/**
 * 
 */
package cmc.interaction;

import java.util.ArrayList;
import java.util.List;

import cmc.entity.Account;
import cmc.entity.Student;
import cmc.entity.University;
import cmc.functionality.AdminFunctionalityController;
import cmc.functionality.DBController;

/**
 * @author tzhang001
 *
 */
public class AdminInteraction extends AccountInteraction {

	/**
	 * 
	 */
	AdminFunctionalityController afCon;

	// constructer
	/**
	 * Create a new AdminInteraction
	 */
	public AdminInteraction() {
		this.afCon = new AdminFunctionalityController();
	}

	/**
	 * Create a new AdminInteraction with a given AdminFunctionalityController
	 * 
	 * @param afCon
	 */
	public AdminInteraction(AdminFunctionalityController afCon) {
		this.afCon = afCon;
	}

	/**
	 * Adds a new user to the database
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param userType
	 * @param userStatus
	 */
	public void addUser(String firstname, String lastname, String username, String password, String userType) {

		if (firstname.equals("") || lastname.equals("") || username.equals("") || password.equals("")
				|| userType.equals("")) {
			throw new IllegalArgumentException("Please input valid user information");
		} else if (!userType.equals("a") && !userType.equals("u")) {
			throw new IllegalArgumentException();
		} else {
			this.afCon.addUser(firstname, lastname, username, password, userType);
		}

	}

	/**
	 * Changes the status of the specified user
	 * 
	 * @param account
	 */
	public void toggleActivationStatus(String accountName) {
		if (accountName.equals("")) {
			throw new IllegalArgumentException();
		} else {
			afCon.toggleActivationStatus(accountName);
			System.out.println("Status for " + accountName + " changed.");
		}
	}

	/**
	 * Edits the specified university with the list of changes
	 * 
	 * @param university
	 * @param changes
	 */

	public void editUniversityInfo(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		if (name.equals("")) {
			throw new IllegalArgumentException("Please input valid university");
		}
		else{this.afCon.editUniversity(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost,
				percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife,
				emphases);
		}

	}

	/**
	 * Admin view a list of users, if no logged in print error message
	 */
	public ArrayList<Account> viewUsers() {
		ArrayList<Account> accounts = afCon.viewUsers();
		return accounts;
	}

	/**
	 * Admin view a list of users, if no logged in print error message
	 */
	public ArrayList<University> viewUniversities() {
		ArrayList<University> universities = afCon.viewUniversities();
		return universities;
		/*
		 * for (University uni : universities) { System.out.println("Name:" +
		 * uni.getName() + ", State: " + uni.getState() + ", Location: " +
		 * uni.getLocation() + ", Control: " + uni.getControl() + ", Enrollment: " +
		 * uni.getEnrollment() + ", %Female" + uni.getPercentFemale() + ", SAT Verbal: "
		 * + uni.getSatVerbal() + ", SAT Math: " + uni.getSatMath() + ", Cost: " +
		 * uni.getCost() + ", %Finantial Aid: " + uni.getPercentFinAid() +
		 * ", % Enrolled: " + uni.getPercentEnrolled() + ", Applicants: " +
		 * uni.getApplicants() + ", %Admitted: " + uni.getPercentAdmitted() +
		 * ", Academic Scale(1-5): " + uni.getAcademicScale() + ", Social Scale(1-5): "
		 * + uni.getSocialScale() + ", Quality of Lift(1-5): " + uni.getQualityOfLife()
		 * + ", Emphases(es): "); }
		 */

	}

	/**
	 * Add a new University to database
	 * 
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param enrollment
	 * @param percentFemale
	 * @param satVerbal
	 * @param satMath
	 * @param cost
	 * @param percentFinAid
	 * @param percentEnrolled
	 * @param applicants
	 * @param percentAdmitted
	 * @param academicScale
	 * @param socialScale
	 * @param qualityOfLife
	 * @param emphases
	 */
	public void addNewUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		this.afCon.addNewUniversity(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost,
				percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife,
				emphases);
	}

	/**
	 * Remove a University from database
	 * 
	 * @param name
	 */
	public void removeUniversity(String name) {
		this.afCon.removeUniversity(name);
	}

	/**
	 * Edit a user's profile
	 * 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param userType
	 */

	public void editProfile(String userName, String firstName, String lastName, String password, String userType,
			String userStatus) {
		if (firstName.equals("") || lastName.equals("") || userName.equals("") || password.equals("")
				|| userType.equals("") || userStatus.equals("")) {
			throw new IllegalArgumentException("");
		} else if (!userType.equals("a") && !userType.equals("u")) {
			throw new IllegalArgumentException();
		} else if (!userStatus.equals("Y") && !userStatus.equals("N")) {
			throw new IllegalArgumentException();
		} else {
			this.afCon.editUserProfile2(userName, firstName, password, lastName, userType, userStatus);
		}

	}
}

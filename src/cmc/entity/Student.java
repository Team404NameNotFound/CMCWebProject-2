/**
 * This class allows for the creation of Student objects
 */
package cmc.entity;

import java.util.*;

/**
 * @author kmendel001
 *
 */
public class Student extends Account {

	/**
	 * 
	 */
	private ArrayList<UserSavedSchool> savedSchools;

	/**
	 * This method creates a Student object with the following attributes
	 * 
	 * @param firstName
	 *            first name of the Account
	 * @param lasName
	 *            last name of the Account
	 * @param username
	 *            username of the Account
	 * @param password
	 *            password of the Account
	 * @param userType
	 *            type of account admin or student
	 * @param userStatus
	 *            whether account is active or inactive
	 * @param savedSchools
	 *            schools in the student's saved school list
	 */
	public Student(String firstName, String lastName, String username, String password, String userType,
			String userStatus, ArrayList<UserSavedSchool> savedSchools) {
		super(firstName, lastName, username, password, userType, userStatus);
		this.savedSchools = savedSchools;
	}

	/**
	 * This constructor generated a new Student by using an Account and that
	 * account's savedSchools
	 * 
	 * @param account
	 * @param savedSchools
	 */
	public Student(Account account, ArrayList<UserSavedSchool> savedSchools) {
		super(account.getFirstName(), account.getLastName(), account.getUsername(), account.getPassword(),
				account.getUserType(), account.getUserStatus());
		this.savedSchools = savedSchools;
	}

	/**
	 * @return list of schools that the student has saved
	 */
	public ArrayList<UserSavedSchool> getSavedSchools() {
		return savedSchools;
	}

	/**
	 * @param savedSchools
	 *            list of schools that the student has saved
	 */
	public void setSavedSchools(ArrayList<UserSavedSchool> savedSchools) {
		this.savedSchools = savedSchools;
	}

	/**
	 * Checks if a university that the user is trying to save is already in the list
	 * of saved schools
	 * 
	 * @param universityName
	 *            name of the university
	 * @return if the student has saved that particular university
	 */
	public boolean isSchoolSaved(String universityName) {
		boolean found = false;
		for (UserSavedSchool university : savedSchools) {
			if (university.getName().equals(universityName)) {
				found = true;
			}
		}
		return found;
	}

	/**
	 * Removes a university from the saved school list
	 * 
	 * @param universityName
	 *            name of a university
	 */
	public void removeSchool(String universityName) {
		for (int i = 0; i < savedSchools.size(); i++) {
			if (savedSchools.get(i).getName().equals(universityName)) {
				savedSchools.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException(universityName + " is not a saved school.");
	}

	/**
	 * Adds a university to the saved school list
	 * 
	 * @param university
	 *            university object
	 * @param dateAdded
	 *            date the school was saved
	 */
	public void saveSchool(University university, String dateAdded) {
		UserSavedSchool schoolToSave = new UserSavedSchool(university, dateAdded);

		if (this.isSchoolSaved(university.getName())) {
			throw new IllegalArgumentException("You connot save the same school more than once");
		}

		savedSchools.add(schoolToSave);
	}

}

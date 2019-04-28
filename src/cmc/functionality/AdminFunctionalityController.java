package cmc.functionality;

import java.util.ArrayList;
import cmc.entity.*;

/**
 * 
 * @author ajheroux
 *
 */
public class AdminFunctionalityController extends UserFunctionalityController {
	// constructor
	public AdminFunctionalityController() {
		super();
	}

	/**
	 * Calls the database controller to retrieve a list of university objects
	 * 
	 * @return a list of university objects
	 */
	public ArrayList<University> viewUniversities() {
		return this.DBCon.getUniversityList();
	}

	/**
	 * Calls the database controller to retrieve a list of account objects
	 * 
	 * @return a list of account objects
	 */
	public ArrayList<Account> viewUsers() {
		return this.DBCon.getAccountList();
	}

	/**
	 * This method add a new University in the database
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
	public int addNewUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String applicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		if (this.DBCon.getUniversity2(name) != null) {
			return 0;
		} else {
			int addResult = this.universityCon.createNewUniversity(name, state, location, control, enrollment,
					percentFemale, satVerbal, satMath, cost, percentFinAid, applicants, percentAdmitted,
					percentEnrolled, academicScale, socialScale, qualityOfLife, emphases);
			return addResult;
		}

	}

	/**
	 * Updated information for specified university to reflect the following
	 * information
	 * 
	 * @param name
	 *            name of university
	 * @param state
	 *            state university is located in
	 * @param location
	 *            setting the university is located in
	 * @param control
	 *            control the university is under
	 * @param enrollment
	 *            number of students that attend the university
	 * @param percentFemale
	 *            percentage of the student body that is female
	 * @param satVerbal
	 *            average verbal SAT score of student body
	 * @param satMath
	 *            average math SAT score of student body
	 * @param cost
	 *            average annual tuition
	 * @param percentFinAid
	 *            percentage of student body that receives financial aid
	 * @param percentEnrolled
	 *            percentage of applicants that receive financial aid
	 * @param applicants
	 *            average number of applicants annually
	 * @param percentAdmitted
	 *            percentage of applicants admitted annually
	 * @param academicScale
	 *            whole number between 1 and 5 indicating academic rigor of
	 *            university
	 * @param socialScale
	 *            whole number between 1 and 5 indicating social scene of university
	 * @param qualityOfLife
	 *            whole number between 1 and 5 indicating quality of life at
	 *            university
	 * @param emphases
	 *            up to five areas of studies which the university excels in
	 */
	public int editUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String applicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {

		University uniToChange = this.DBCon.getUniversity2(name);
		int result;

		String[] oldEmphases = uniToChange.getEmphases();
		if (oldEmphases.length > 0) {
			for (String oldOne : oldEmphases) {
				this.DBCon.removeEmphasis(uniToChange.getName(), oldOne);
			}
		}

		if (emphases.length > 0) {
			for (String newEmphase : emphases) {
				this.DBCon.addEmphasis(uniToChange.getName(), newEmphase);
			}
		}

		this.universityCon = new UniversityController(uniToChange);
		return  result = this.universityCon.updateUniversityInfo(name, state, location, control, enrollment, percentFemale, satVerbal,
				satMath, cost, percentFinAid, applicants, percentAdmitted, percentEnrolled, academicScale,
				socialScale, qualityOfLife, emphases);

		/*
		 * this.DBCon.setUniversity(universityCon.updateUniversityInfo(name, state,
		 * location, control, enrollment, percentFemale, satVerbal, satMath, cost,
		 * percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale,
		 * socialScale, qualityOfLife, emphases));
		 */
	}

	/**
	 * Remove specified university from a students saved school list
	 * 
	 * @param name
	 *            name of university
	 */
	public int removeUniversity(String name) {
		University schoolToRemove = this.DBCon.getUniversity2(name);
		if (schoolToRemove == null) {
			return 0;
		} else {
			if (this.DBCon.getUserSavedStatistics(name) > 0 || schoolToRemove.getEmphases().length > 0) {
				return -1;
			}
			return this.DBCon.removeUniversity(name);
		}
	}

	/**
	 * Create a new user with given information and add it to database
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param userType
	 * @return added
	 */
	public boolean addUser(String firstname, String lastname, String username, String password, String userType) {
		boolean added = false;
		ArrayList<UserSavedSchool> savedSchoolList = new ArrayList<UserSavedSchool>();

		if (this.DBCon.getAccount(username) == null) {
			AccountController acCon = new AccountController();
			Account account = acCon.createNewAccount(firstname, lastname, username, password, userType,
					savedSchoolList);
			DBCon.addUser(account);
			added = true;

		} else {
			throw new IllegalArgumentException("Sorry, this user already exists");
		}

		return added;
	}

	public boolean editUserProfile2(String userName, String firstName, String lastName, String password,
			String userType, String userStatus) {
		Boolean edit = false;
		Account accountToEdit = this.DBCon.getAccount(userName);
		if (accountToEdit == null) {
			throw new IllegalArgumentException("Valid User needed");
		} else {
			this.DBCon.editAccount(userName, firstName, lastName, password, userType, userStatus);
			edit = true;
		}
		return edit;
	}

	/**
	 * Changes activation status for specified account
	 * 
	 * @param accountName
	 *            user name associated with account being edited
	 */
	public void toggleActivationStatus(String accountName) {
		Account toggleAccount = this.DBCon.getAccount(accountName);
		if (toggleAccount != null) {
			AccountController ac = new AccountController(toggleAccount);
			ac.toggleActivationStatus();
		} else {
			throw new IllegalArgumentException("Cannot toggle null account");
		}

	}

}

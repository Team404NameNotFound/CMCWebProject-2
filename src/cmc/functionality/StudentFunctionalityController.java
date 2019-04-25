package cmc.functionality;

import java.util.ArrayList;
import cmc.entity.*;

/**
 * 
 * @author ajheroux
 *
 */
public class StudentFunctionalityController extends UserFunctionalityController {

	public SearchController searchCon;

	/**
	 * Creating a new StudentFunctionalityController
	 */
	public StudentFunctionalityController() {
		super();
		this.account = new AccountController();
		this.searchCon = new SearchController(this.DBCon.getUniversityList());
	}

	
	public int login(String userName, String password) {
		if (!loggedIn) {
			if (this.DBCon.checkUser(userName)) {
				if (this.DBCon.getAccount(userName).getUserStatus().equals("Y")) {
					AccountController userAcc = new AccountController(this.DBCon.getAccount(userName));
					if (userAcc.checkPassword(password)) {
						this.account = new AccountController(this.DBCon.getAccount(userName));
						this.loggedIn = true;
						return 0;
					} else {
						return -2;

					}
				} else {
					return -3;
				}
			} else {
				return -1;

			}
		}
		return -4;
	}
	/**
	 * returns the five most similar universities to the specified university
	 * 
	 * @param universityName
	 * @return rankedUniversities
	 */
	public ArrayList<University> rankUniversity(String universityName) {
		if (!this.DBCon.findUniversity(universityName)) {
			throw new IllegalArgumentException(universityName + "is not in this database");
		}
		University uni = this.DBCon.getUniversity(universityName);
		ArrayList<University> rankedUniversities = this.searchCon.rankUniversity(uni);
		return rankedUniversities;
	}

	/**
	 * Generates search results for the fields provided and returns a list of
	 * matches based on search parameters.
	 * 
	 * @param schoolName
	 * @param state
	 * @param location
	 * @param numStudentsMin
	 * @param numStudentsMax
	 * @param percentFemaleMin
	 * @param percentFemaleMax
	 * @param SATVerbalMin
	 * @param SATVerbalMax
	 * @param SATMatMin
	 * @param SATMathMax
	 * @param expensesMin
	 * @param expensesMax
	 * @param PercentFinancialAidMin
	 * @param percenetFinancialAidMax
	 * @param numberApplicantsMin
	 * @param numberApplicatnsMax
	 * @param percentAddmittedMin
	 * @param percentAdmittedMax
	 * @param percentEnrolledMin
	 * @param percentEnrolledMax
	 * @param academicScaleMin
	 * @param academicScaleMax
	 * @param socialScalemin
	 * @param socialScaleMax
	 * @param qualityOfLifeMin
	 * @param qualityOfLifeMax
	 * @param emphases
	 * @param control
	 * @return
	 */
	public ArrayList<University> search(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, int SATVerbalMax,
			int SATMatMin, int SATMathMax, int expensesMin, int expensesMax, float PercentFinancialAidMin,
			float percenetFinancialAidMax, int numberApplicantsMin, int numberApplicatnsMax, float percentAddmittedMin,
			float percentAdmittedMax, float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin,
			int academicScaleMax, int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax,
			String[] emphases, String control) {

		ArrayList<University> searchResults = this.searchCon.fieldSearch(schoolName, state, location, numStudentsMin,
				numStudentsMax, percentFemaleMin, percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMatMin, SATMathMax,
				expensesMin, expensesMax, PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin,
				numberApplicatnsMax, percentAddmittedMin, percentAdmittedMax, percentEnrolledMin, percentEnrolledMax,
				academicScaleMin, academicScaleMax, socialScalemin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax,
				emphases, control);
		
		return searchResults;
	}

	/**
	 * View a school's detail information
	 * 
	 * @param universityName
	 */
	public ArrayList<String> viewSchoolDetails(String universityName) {
		ArrayList<University> universityList = this.DBCon.getUniversityList();
		for (int i = 0; i < universityList.size(); i++) {
			if (universityList.get(i).getName().equals(universityName)) {
				this.universityCon = new UniversityController(this.DBCon.getUniversity2(universityName));
				return this.universityCon.getSchoolDetails();
			}
		}
		throw new IllegalArgumentException(universityName + " is not a school in the database");
	}

	/**
	 * Save a school for current user
	 * 
	 * @param school
	 */
	public void saveSchool(String schoolName) {
		ArrayList<UserSavedSchool> savedSchols = DBCon.getSchoolList2(account.account);
		if (!this.DBCon.findUniversity(schoolName)) {
			throw new IllegalArgumentException("School is not in database");
		}
		for (UserSavedSchool school : savedSchols) {
			if (school.getName().equals(schoolName)) {
				throw new IllegalArgumentException("School is already saved");
			}
		}
		account.saveSchool(schoolName);
	}

	public void setAccountController(Account account) {
		this.account = new AccountController(account);
	}

	/**
	 * View current user's saved schools list
	 */
	public ArrayList<UserSavedSchool> viewSavedSchools() {
		//this.account.viewSavedSchools();
		System.out.println("SF Controller this.viewSavedSchools: "+ this.getAccount());
		return this.account.viewSavedSchools();
	}

	/**
	 * Remove a school from the saved schools list
	 * 
	 * @param school
	 *            String, the name of school to remove
	 */
	public void removeSavedSchool(String school) {
		this.setAccount(account);
		// if(this.account == null) System.out.println("the account is null");
		this.account.removeSavedSchool(school);
	}

	/**
	 * View a saved school's detail information
	 * 
	 * @param school
	 *            String, saved school name to view details
	 */
	public ArrayList<String> viewSavedSchoolDetails(String school) {
		this.setAccount(account);
		Boolean schoolSaved = super.account.checkIfSchoolSaved(school);
		ArrayList<String> returnSchool;
		ArrayList<String> savedDetails = new ArrayList();
		if (schoolSaved) {
			// this.setUniversityCon(new
			// UniversityController(this.DBCon.getUniversity2(school)));
			// System.out.println(this.universityCon.getSchoolDetails());
			// message = this.universityCon.getSchoolDetails();

			ArrayList<UserSavedSchool> savedSchools = DBCon
					.getSchoolList2(DBCon.getAccount(account.account.getUsername()));
			int index = 0;
			for (int i = 0; i < savedSchools.size(); i++) {

				if (savedSchools.get(i).getName().equals(school)) {
					index = i;
					savedDetails.add(savedSchools.get(i).getName());
					savedDetails.add(savedSchools.get(i).getState());
					savedDetails.add(savedSchools.get(i).getLocation());
					savedDetails.add(savedSchools.get(i).getControl());
					savedDetails.add(savedSchools.get(i).getEnrollment());
					savedDetails.add(savedSchools.get(i).getPercentFemale());
					savedDetails.add(savedSchools.get(i).getSatVerbal());
					savedDetails.add(savedSchools.get(i).getSatMath());
					savedDetails.add(savedSchools.get(i).getCost());
					savedDetails.add(savedSchools.get(i).getPercentFinAid());
					savedDetails.add(savedSchools.get(i).getApplicants());
					savedDetails.add(savedSchools.get(i).getPercentAdmitted());
					savedDetails.add(savedSchools.get(i).getAcademicScale());
					savedDetails.add(savedSchools.get(i).getSocialScale());
					savedDetails.add(savedSchools.get(i).getQualityOfLife());
					for (int e = 0; e < savedSchools.get(i).getEmphases().length; e++)
						savedDetails.add(savedSchools.get(i).getEmphases()[e]);
					savedDetails.add(savedSchools.get(i).getDateAdded());
					return savedDetails;
				}
			}

		} else {
			throw new IllegalArgumentException();
		}
		return savedDetails;

	}

	private void setUniversityCon(UniversityController universityController) {
		// TODO Auto-generated method stub
		UniversityController universityCon = super.universityCon;
	}

	/**
	 * View how many times a school being saved by users
	 * 
	 * @param school
	 */
	public String viewUserSavedStatistics(String school) {
		if (!this.DBCon.findUniversity(school)) {
			throw new IllegalArgumentException(school + "does not exist");
		}
		String[] stats = { "", "" };
		int savedTimes = this.DBCon.getUserSavedStatistics(school);
		System.out.println(school + " has been saved for " + savedTimes + " times");
		stats[0] = school;
		stats[1] = savedTimes + "";
		return stats[0] + " " + stats[1];
	}

	/**
	 * Compare saved schools with their required SatMath scores
	 * 
	 * @return
	 */
	public ArrayList<String> compareSchoolsByScore() {
		return super.account.compareSchoolsByScore();
	}
	
	public void setAccount(String username) {
		this.account.setAccount(username);
	}

}

/**
 * 
 */
package cmc.interaction;

import java.util.ArrayList;
import java.util.List;

import cmc.entity.University;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;
import cmc.functionality.SearchController;
import cmc.functionality.StudentFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class StudentInteraction extends AccountInteraction {

	StudentFunctionalityController sfCon;
	DBController dbCon = new DBController();
	/**
	 * Create a new StudentInteraction
	 */
	public StudentInteraction() {
		super();
		sfCon = new StudentFunctionalityController();
	}

	/**
	 * Student take the personal quiz
	 * 
	 * @param location
	 * @param characteristic
	 * @param control
	 * @param emphasis
	 */
	public ArrayList<University> takeQuiz(String location, String characteristic, String control, String[] emphasis) {
		ArrayList<University> personalMatches = new ArrayList<University>();

		if (location.equals("") || control.equals("") || characteristic.equals("")) {
			throw new IllegalArgumentException("Sorry, you must answer all questions");
		} else {
			if (characteristic.equals("academic")) {

				personalMatches = sfCon.search("", "-1", location, -1, -1, (float) -1.0, (float) -1.0, -1, -1, -1, -1,
						-1, -1, (float) -1.0, (float) -1.0, -1, -1, (float) -1.0, (float) -1.0, (float) -1.0,
						(float) -1.0, 3, -1, -1, -1, -1, -1, emphasis, control);
			} else if (characteristic.equals("social")) {
				personalMatches = sfCon.search("", "-1", location, -1, -1, (float) -1.0, (float) -1.0, -1, -1, -1, -1,
						-1, -1, (float) -1.0, (float) -1.0, -1, -1, (float) -1.0, (float) -1.0, (float) -1.0,
						(float) -1.0, -1, -1, 3, -1, -1, -1, emphasis, control);
			} else if (characteristic.equals("qualityOfLife")) {
				personalMatches = sfCon.search("", "-1", location, -1, -1, (float) -1.0, (float) -1.0, -1, -1, -1, -1,
						-1, -1, (float) -1.0, (float) -1.0, -1, -1, (float) -1.0, (float) -1.0, (float) -1.0,
						(float) -1.0, -1, -1, -1, -1, 3, -1, emphasis, control);
			}

		}

		for (int i = 0; i < personalMatches.size(); i++) {
			System.out.println("Match: " + personalMatches.get(i).getName());

		}
		return personalMatches;
	}

	/**
	 * Only test search for schools by the combination of state and number of
	 * students right now, for testing purposes, other parameters are setting as
	 * fixed number. search should return University[] instead of Double[][]
	 * 
	 * @param String
	 *            state
	 * @param int
	 *            numStudentsMin, minimal number of students
	 * @param int
	 *            numStduentsMax, maximal number of students
	 */

	public ArrayList<University> fieldSearch(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, int SATVerbalMax,
			int SATMathMin, int SATMathMax, int expensesMin, int expensesMax, float PercentFinancialAidMin,
			float percenetFinancialAidMax, int numberApplicantsMin, int numberApplicatnsMax, float percentAddmittedMin,
			float percentAdmittedMax, float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin,
			int academicScaleMax, int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax,
			String[] emphases, String control) {
		ArrayList<University> matchSchools;

		if (!sfCon.loggedIn) {

			if (schoolName.equals("") && state.equals("") && location.equals("") && numStudentsMin == -1
					&& numStudentsMax == -1 && percentFemaleMin == -1 && percentFemaleMax == -1 && SATVerbalMin == -1
					&& SATVerbalMax == -1 && SATMathMin == -1 && SATMathMax == -1 && expensesMin == -1
					&& expensesMax == -1 && PercentFinancialAidMin == -1 && percenetFinancialAidMax == -1
					&& numberApplicantsMin == -1 && numberApplicatnsMax == -1 && percentAddmittedMin == -1
					&& percentAdmittedMax == -1 && percentEnrolledMin == -1 && percentEnrolledMax == -1
					&& academicScaleMin == -1 && academicScaleMax == -1 && socialScalemin == -1 && socialScaleMax == -1
					&& qualityOfLifeMin == -1 && qualityOfLifeMax == -1 && control.equals("")) {
				throw new IllegalArgumentException("Sorry, you must input at least one search field");
			}

			else if ((numStudentsMax < numStudentsMin && numStudentsMax != -1)
					|| (percentFemaleMax < percentFemaleMin && percentFemaleMax != -1)
					|| (SATVerbalMax < SATVerbalMin && SATVerbalMax != -1)
					|| (SATMathMax < SATMathMin && SATMathMax != -1) || (expensesMax < expensesMin && expensesMax != -1)
					|| (percenetFinancialAidMax < PercentFinancialAidMin && percenetFinancialAidMax != -1)
					|| (numberApplicatnsMax < numberApplicatnsMax && numberApplicatnsMax != -1)
					|| (percentAdmittedMax < percentAddmittedMin && percentAdmittedMax != -1)
					|| (percentEnrolledMax < percentEnrolledMin && percentEnrolledMax != -1)
					|| (academicScaleMax < academicScaleMin && academicScaleMax != -1)
					|| (socialScaleMax < socialScalemin && socialScaleMax != -1)
					|| (qualityOfLifeMax < qualityOfLifeMin && qualityOfLifeMax != -1)) {
				throw new IllegalArgumentException("Sorry, your no minimum can be greater than a maximum");
			}

			else {
				matchSchools = sfCon.search(schoolName, state, location, numStudentsMin, numStudentsMax,
						percentFemaleMin, percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMathMin, SATMathMax,
						expensesMin, expensesMax, PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin,
						numberApplicatnsMax, percentAddmittedMin, percentAdmittedMax, percentEnrolledMin,
						percentEnrolledMax, academicScaleMin, academicScaleMax, socialScalemin, socialScaleMax,
						qualityOfLifeMin, qualityOfLifeMax, emphases, control);
				for (int i = 0; i < matchSchools.size(); i++) {
					System.out.println(matchSchools.get(i).getName());
				}
			}
		}

		else {
			throw new IllegalArgumentException("Sorry, you must be logged in to access this functionality");
		}

		return matchSchools;
	}

	/**
	 * Returns the five most similar schools to the specified school
	 * 
	 * @param schoolToCompare
	 */
	public ArrayList<University> findRecommended(String schoolToCompare) {
		ArrayList<University> closeMatch = sfCon.rankUniversity(schoolToCompare);
		for (int i = 0; i < 5; i++) {
			System.out.println(closeMatch.get(i).getName());
		}

		return closeMatch;
	}

	/**
	 * User save a school
	 * 
	 * @param school
	 */
	public ArrayList<UserSavedSchool> saveSchool(String school) {
		//this.sfCon.setAccount(this.UFCon.getAccount());
		this.sfCon.saveSchool(school);
		return sfCon.viewSavedSchools();
	}

	/**
	 * View a specific school's detail information
	 */
	public ArrayList<String> viewSchoolDetails(String universityName) {
		this.sfCon.viewSchoolDetails(universityName);
		return this.sfCon.viewSchoolDetails(universityName);
	}

	/**
	 * View a specific saved school's detail information
	 * 
	 * @param school
	 */
	public ArrayList<String> viewSavedSchoolDetails(String school) {
		this.sfCon.viewSavedSchoolDetails(school);
		return this.sfCon.viewSavedSchoolDetails(school);
	}

	/**
	 * View all the schools on current use's saved school list
	 */
	public ArrayList<UserSavedSchool> viewSavedSchools() {
		this.sfCon.viewSavedSchools();
		return this.sfCon.viewSavedSchools();
	}

	/**
	 * View how many times that a school is being saved by users
	 * 
	 * @param school
	 * @return
	 */
	public String viewUserSavedStatistics(String school) {
		this.sfCon.viewUserSavedStatistics(school);
		return this.sfCon.viewUserSavedStatistics(school);
	}

	/**
	 * Get the current StudentFunctionalityController
	 * 
	 * @return the sfCon
	 */
	public StudentFunctionalityController getSfCon() {
		return sfCon;
	}

	/**
	 * Set the current StudentFunctionalityController
	 * 
	 * @param sfCon
	 *            the sfCon to set
	 */
	public void setSfCon(StudentFunctionalityController sfCon) {
		this.sfCon = sfCon;
	}
	
	/**
	 * Remove a school from user's saved schools list
	 * 
	 * @param school
	 */
	public void removeSavedSchool(String school) {
		this.sfCon.removeSavedSchool(school);
	}

	/**
	 * Compare saved school with their Sat Math Scores
	 * 
	 * @return
	 */
	public ArrayList<String> compareSchoolsByScore() {
		return sfCon.compareSchoolsByScore();
	}

	public ArrayList<String> editProfile(String userName, String firstName, String lastName, String password, String userType, String activeStatus) {
		if (firstName == "" || lastName == "" || password == "") {
			throw new IllegalArgumentException();
		} else {
			UFCon.editUserProfile(userName, firstName, lastName, password, "u", activeStatus);
		}

		return UFCon.viewUserProfile(userName);
	}
	
//	public void setAccount(String username) {
//		this.sfCon.setAccount(username);
//	}

}

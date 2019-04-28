/**
 * 
 */
package cmc.interaction;

import java.util.ArrayList;
import java.util.List;

import cmc.entity.University;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import cmc.functionality.AdminFunctionalityController;
import cmc.functionality.DBController;
import cmc.functionality.SearchController;
import cmc.functionality.StudentFunctionalityController;

public class StudentInteraction extends AccountInteraction {

	StudentFunctionalityController sfCon;
	DBController dbCon = new DBController();

	/**
	 * Create a new StudentInteraction
	 */
	public StudentInteraction() {
		//super();
		this.sfCon = new StudentFunctionalityController();
	}
	
	public StudentInteraction(StudentFunctionalityController sfCon) {
		this.sfCon = sfCon;
	}


	/**
	 * Student take the personal quiz
	 * 
	 * @param location
	 * @param characteristic
	 * @param control
	 * @param emphasis
	 */
	public ArrayList<University> takeQuiz(String location, String characteristic, String control, String emphasis) {
		ArrayList<University> personalMatches = new ArrayList<University>();

		if (location.equals("") || control.equals("") || characteristic.equals("")) {
			throw new IllegalArgumentException("Sorry, you must answer all questions");
		}
		else
		{
			//question 1
			if(control.equals("LARGE"))
			{
				control = "STATE";
			}
			else if(control.equals("SEMI-LARGE"))
			{
				control = "STATE";
			}
			else if(control.equals("-1"))
			{
				control = "-1";
			}
			else if(control.equals("SEMI-SMALL"))
			{
				control = "PRIVATE";
			}
			else if(control.equals("SMALL"))
			{
				control = "PRIVATE";
			}
			
			//question 4
			String[] searchList = {};
			if(emphasis.equals("BUSINESS"))
			{
				String[] emphasesList = {"ACCOUNTING", "BUSINESS-ADMINISTRATION", "BUSINESS-EDUCATION", "ECONOMICS",
						"COMMUNICATIONS", "COMMERCE", "MANAGEMENT", "MARKETING"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("MEDICINE"))
			{
				String[] emphasesList = {"BIOLOGY", "BIOMED", "CHEMISTRY", "HEALTH-MEDICINE", "HEALTH-PROFESSIONS",
						"HEALTH-SCIENCE", "MEDICAL-SCHOOL", "MEDICAL", "MEDICINE", "MOLECULAR-BIOLOGY", "NATURAL-SCIENCES",
						"NURSING", "PHARMACY", "PRE-MED"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("ENGINEERING"))
			{
				String[] emphasesList = {"APPLIED-SCIENCE", "ARCHITECTURE", "APPLIED-TECHNOLOGY", "ARTS-AND-SCIENCES",
						"CHEMICAL-ENGINEERING", "COMPUTER-SCIENCE", "ELECTRICAL-ENGINEERING", "ENGINEERING",
						"MATH", "MATH-AND-SCIENCE", "MECHANICAL-ENGINEERING", "PHYSICAL-SCIENCES", "PHYSICS"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("MUSIC"))
			{
				String[] emphasesList = {"ARTS-AND-HUMANITIES", "FINE-ARTS", "FINE-AND-PERFORMING-ARTS", "PERFORMING-ARTS",
						"MUSIC", "MUSIC-COMPOSITION", "MUSIC-EDUCATION", "MUSIC-PERFORMANCE"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("EDUCATION"))
			{
				String[] emphasesList = {"BUSINESS-EDUCATION", "EDUCATION", "MUSIC-EDUCATION", "TEACHER-EDUCATION"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("LAW"))
			{
				String[] emphasesList = {"GOVERNMENT", "INTERNATIONAL-AFFAIRS", "LAW", "PHILOSOPHY", "POLITICAL-SCIENCE",
						"PRE-LAW", "SOCIAL-SCIENCE", "SOCIAL-WORK"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("ENGLISH"))
			{
				String[] emphasesList = {"ARTS-AND-HUMANITIES", "ENGLISH", "HUMANITIES"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("LIBERAL-ARTS"))
			{
				String[] emphasesList = {"LIBERAL-ARTS"};
				searchList = emphasesList;
			}
			else if(emphasis.equals("-1"))
			{
				String[] emphasesList = {};
				searchList = emphasesList;
			}
			
			//question 3
			if (characteristic.equals("academic")) {

				personalMatches = this.fieldSearch("", "", location, "", "", "", "", "", "", "", "", "",
						"", "", "", "", "", "", "", "", "",
						"3", "", "", "", "", "", searchList, control);
			} else if (characteristic.equals("social")) {
				personalMatches = this.fieldSearch("", "", location, "", "", "", "", "", "", "", "", "",
						"", "", "", "", "", "", "", "", "",
						"", "", "3", "", "", "", searchList, control);
			} else if (characteristic.equals("qualityOfLife")) {
				personalMatches = this.fieldSearch("", "", location, "", "", "", "", "", "", "", "", "",
						"", "", "", "", "", "", "", "", "",
						"", "", "", "", "3", "", searchList, control);
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

	public ArrayList<University> fieldSearch(String schoolName, String state, String location, String numStudentsMinS,
			String numStudentsMaxS, String percentFemaleMinS, String percentFemaleMaxS, String SATVerbalMinS,
			String SATVerbalMaxS, String SATMathMinS, String SATMathMaxS, String expensesMinS, String expensesMaxS,
			String PercentFinancialAidMinS, String percenetFinancialAidMaxS, String numberApplicantsMinS,
			String numberApplicatnsMaxS, String percentAddmittedMinS, String percentAdmittedMaxS,
			String percentEnrolledMinS, String percentEnrolledMaxS, String academicScaleMinS, String academicScaleMaxS,
			String socialScaleminS, String socialScaleMaxS, String qualityOfLifeMinS, String qualityOfLifeMaxS,
			String[] emphases, String control) {

		ArrayList<University> matchSchools = new ArrayList<University>();
		
		//Check if all the parameters are empty
		if (schoolName.length() < 1 && state.length() < 1 && location.length() < 1 && numStudentsMinS.length() < 1
				&& numStudentsMaxS.length() < 1 && percentFemaleMinS.length() < 1 && percentFemaleMaxS.length() < 1
				&& SATVerbalMinS.length() < 1 && SATVerbalMaxS.length() < 1 && SATMathMinS.length() < 1
				&& SATMathMaxS.length() < 1 && expensesMinS.length() < 1 && expensesMaxS.length() < 1
				&& PercentFinancialAidMinS.length() < 1 && percenetFinancialAidMaxS.length() < 1
				&& numberApplicantsMinS.length() < 1 && numberApplicatnsMaxS.length() < 1
				&& percentAddmittedMinS.length() < 1 && percentAdmittedMaxS.length() < 1
				&& percentEnrolledMinS.length() < 1 && percentEnrolledMaxS.length() < 1
				&& academicScaleMinS.length() < 1 && academicScaleMaxS.length() < 1 && socialScaleminS.length() < 1
				&& socialScaleMaxS.length() < 1 && qualityOfLifeMinS.length() < 1 && qualityOfLifeMaxS.length() < 1
				&& control.length() < 1) {
			throw new IllegalArgumentException("Sorry, you must input at least one search field");
		}
		
		//Check if number parameters are valid
		String[] numParameters = { numStudentsMinS, numStudentsMaxS, SATVerbalMinS, SATVerbalMaxS, SATMathMinS,
				SATMathMaxS, expensesMinS, expensesMaxS, numberApplicantsMinS, numberApplicatnsMaxS };

		String[] percentParameters = { percentFemaleMinS, percentFemaleMaxS, PercentFinancialAidMinS,
				percenetFinancialAidMaxS, percentAddmittedMinS, percentAdmittedMaxS, percentEnrolledMinS,
				percentEnrolledMaxS };

		String[] scales = { academicScaleMinS, academicScaleMaxS, socialScaleminS, socialScaleMaxS, qualityOfLifeMinS,
				qualityOfLifeMaxS };

		for (String n : numParameters) {
			if(n.length() > 0 && !n.matches("\\d+(\\.\\d+)?")) {
				throw new IllegalArgumentException("Sorry, need to be positive integer");
			}
		}

		for (String p : percentParameters) {
			if(p.length() > 0 && (!p.matches("\\d+(\\.\\d+)?") || Float.parseFloat(p) < 0 || Float.parseFloat(p) > 100) 
				){
				throw new IllegalArgumentException("Sorry, need to be percentage");
			}
		}

		for (String c : scales) {
			if(c.length() > 0 &&!c.matches("[12345]")){
				throw new IllegalArgumentException("Sorry, need to be 12345");
			}
		}
		
		
		//Assign values for number Parameters
		int numStudentsMin = -1;
		int numStudentsMax = -1;
		float percentFemaleMin = -1;
		float percentFemaleMax = -1;
		int SATVerbalMin = -1;
		int SATVerbalMax = -1;
		int SATMathMin = -1;
		int SATMathMax = -1;
		int expensesMin = -1;
		int expensesMax = -1;
		float PercentFinancialAidMin = -1;
		float percenetFinancialAidMax = -1;
		int numberApplicantsMin = -1;
		int numberApplicatnsMax = -1;
		float percentAddmittedMin = -1;
		float percentAdmittedMax = -1;
		float percentEnrolledMin = -1;
		float percentEnrolledMax = -1;
		int academicScaleMin = -1;
		int academicScaleMax = -1;
		int socialScalemin = -1;
		int socialScaleMax = -1;
		int qualityOfLifeMin = -1;
		int qualityOfLifeMax = -1;

		
		if(numStudentsMinS.length() > 0) {
			numStudentsMin = Integer.parseInt(numStudentsMinS);
		}else {
			numStudentsMin = -1;
		}
		if(numStudentsMaxS.length() > 0) {
			numStudentsMax = Integer.parseInt(numStudentsMaxS);
		}else {
			numStudentsMax = -1;
		}
		
		if(percentFemaleMinS.length() > 0) {
			percentFemaleMin = Float.parseFloat(percentFemaleMinS); //
		}else {
			percentFemaleMin = -1;
		}
		if(percentFemaleMaxS.length() > 0) {
			percentFemaleMax = Float.parseFloat(percentFemaleMaxS); //
		}else {
			percentFemaleMax = -1;
		}
		
		if(SATVerbalMinS.length() > 0) {
			SATVerbalMin = Integer.parseInt(SATVerbalMinS); //
		}else {
			SATVerbalMin = -1;
		}
		if(SATVerbalMaxS.length() > 0) {
			SATVerbalMax = Integer.parseInt(SATVerbalMaxS); //
		}else {
			SATVerbalMax = -1;
		}
		
		if(SATMathMinS.length() > 0) {
			SATMathMin = Integer.parseInt(SATMathMinS); //
		}else {
			SATMathMin = -1;
		}
		if(SATMathMaxS.length() > 0) {
			SATMathMax = Integer.parseInt(SATMathMaxS); //
		}else {
			SATMathMax = -1;
		}
		
		if(expensesMinS.length() > 0) {
			expensesMin = Integer.parseInt(expensesMinS);//
		}else {
			expensesMin = -1;
		}
		if(expensesMaxS.length() > 0) {
			expensesMax = Integer.parseInt(expensesMaxS); //
		}else {
			expensesMax = -1;
		}
		
		if(PercentFinancialAidMinS.length() > 0) {
			PercentFinancialAidMin = Float.parseFloat(PercentFinancialAidMinS); //
		}else {
			PercentFinancialAidMin = -1;
		}
		if(percenetFinancialAidMaxS.length() > 0) {
			percenetFinancialAidMax = Float.parseFloat(percenetFinancialAidMaxS); //
		}else {
			percenetFinancialAidMax = -1;
		}
		
		if(numberApplicantsMinS.length() > 0) {
			numberApplicantsMin = Integer.parseInt(numberApplicantsMinS); //
		}else {
			numberApplicantsMin = -1;
		}
		if(numberApplicatnsMaxS.length() > 0) {
			numberApplicatnsMax = Integer.parseInt(numberApplicatnsMaxS); //
		}else {
			numberApplicatnsMax = -1;
		}
		
		if(percentAddmittedMinS.length() > 0) {
			percentAddmittedMin = Float.parseFloat(percentAddmittedMinS); //
		}else {
			percentAddmittedMin = -1;
		}
		if(percentAdmittedMaxS.length() > 0) {
			percentAdmittedMax = Float.parseFloat(percentAdmittedMaxS); //
		}else {
			percentAdmittedMax = -1;
		}
		
		if(percentEnrolledMinS.length() > 0) {
			percentEnrolledMin = Float.parseFloat(percentEnrolledMinS); //
		}else {
			percentEnrolledMin = -1;
		}
		if(percentEnrolledMaxS.length() > 0) {
			percentEnrolledMax = Float.parseFloat(percentEnrolledMaxS); //
		}else {
			percentEnrolledMax = -1;
		}
		
		if(academicScaleMinS.length() > 0) {
			academicScaleMin = Integer.parseInt(academicScaleMinS); //
		}else {
			academicScaleMin = -1;
		}
		if(academicScaleMaxS.length() > 0) {
			academicScaleMax = Integer.parseInt(academicScaleMaxS); //
		}else {
			academicScaleMax = -1;
		}
		
		if(socialScaleminS.length() > 0) {
			socialScalemin = Integer.parseInt(socialScaleminS); //
		}else {
			socialScalemin = -1;
		}
		if(socialScaleMaxS.length() > 0) {
			socialScaleMax = Integer.parseInt(socialScaleMaxS);//
		}else {
			socialScaleMax = -1;
		}
		
		if(qualityOfLifeMinS.length() > 0) {
			qualityOfLifeMin = Integer.parseInt(qualityOfLifeMinS); //
		}else {
			qualityOfLifeMin = -1;
		}
		if(qualityOfLifeMaxS.length() > 0) {
			qualityOfLifeMax = Integer.parseInt(qualityOfLifeMaxS); //
		}else {
			qualityOfLifeMax = -1;
		}
		if(schoolName.length() < 1) {
			schoolName = "-1";
		}
		if(state.length() < 1) {
			state = "-1";
		}
		if(location.length() < 1) {
			location = "-1";
		}
		if(control.length() < 1) {
			control = "-1";
		}
		
			
		//check it min < max
		if ((numStudentsMax < numStudentsMin && numStudentsMaxS.length() > 0)
				|| (percentFemaleMax < percentFemaleMin && percentFemaleMaxS.length() > 0)
				|| (SATVerbalMax < SATVerbalMin && SATVerbalMaxS.length() > 0)
				|| (SATMathMax < SATMathMin && SATMathMaxS.length() > 0)
				|| (expensesMax < expensesMin && expensesMaxS.length() > 0)
				|| (percenetFinancialAidMax < PercentFinancialAidMin && percenetFinancialAidMaxS.length() > 0)
				|| (numberApplicatnsMax < numberApplicatnsMax && numberApplicatnsMaxS.length() > 0)
				|| (percentAdmittedMax < percentAddmittedMin && percentAdmittedMaxS.length() > 0)
				|| (percentEnrolledMax < percentEnrolledMin && percentEnrolledMaxS.length() > 0)
				|| (academicScaleMax < academicScaleMin && academicScaleMaxS.length() > 0)
				|| (socialScaleMax < socialScalemin && socialScaleMaxS.length() > 0)
				|| (qualityOfLifeMax < qualityOfLifeMin && qualityOfLifeMaxS.length() > 0)) {
			throw new IllegalArgumentException("Sorry, your no minimum can be greater than a maximum");
		}

		matchSchools = sfCon.search(schoolName, state, location, numStudentsMin, numStudentsMax, percentFemaleMin,
				percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMathMin, SATMathMax, expensesMin, expensesMax,
				PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin, numberApplicatnsMax,
				percentAddmittedMin, percentAdmittedMax, percentEnrolledMin, percentEnrolledMax, academicScaleMin,
				academicScaleMax, socialScalemin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax, emphases,
				control);

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
		// this.sfCon.setAccount(this.UFCon.getAccount());
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
	
	public String[] getSchoolEmphases(String universityName) {
		return this.dbCon.getUniversity2(universityName).getEmphases();
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
		return this.sfCon.viewSavedSchools();
	}

	public int login(String username, String password) {
		isLoggedIn = true;
		return this.sfCon.login(username, password);

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

	public ArrayList<String> editProfile(String userName, String firstName, String lastName, String password,
			String userType, String activeStatus) {
		if (firstName == "" || lastName == "" || password == "") {
			throw new IllegalArgumentException("Sorry, no field  could be empty");
		} else {
			UFCon.editUserProfile(userName, firstName, lastName, password, "u", activeStatus);
		}

		return UFCon.viewUserProfile(userName);
	}

	// public void setAccount(String username) {
	// this.sfCon.setAccount(username);
	// }

}

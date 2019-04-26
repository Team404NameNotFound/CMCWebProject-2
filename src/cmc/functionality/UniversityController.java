/**
 * 
 */
package cmc.functionality;

import cmc.entity.*;
import java.util.ArrayList;

/**
 * @author kmendel001
 *
 */
public class UniversityController {

	University school;
	DBController DBCon = new DBController();

	/**
	 * constructs a new UniversityController with the school provided
	 * 
	 * @param schooltoChange
	 *            the University object that will be changed/updated
	 */
	public UniversityController(University schoolToChange) {
		this.school = schoolToChange;
	}

	public UniversityController() {
		this.school = new University();
	}

	/**
	 * returns a string of all the school's attributes
	 * 
	 * @return String the string for the school
	 */
	public ArrayList<String> getSchoolDetails() {
		ArrayList<String> schoolDetails = new ArrayList<String>();
		schoolDetails.add(school.getName());
		schoolDetails.add(school.getState());
		schoolDetails.add(school.getLocation());
		schoolDetails.add(school.getControl());
		schoolDetails.add(school.getEnrollment());
		schoolDetails.add(school.getPercentFemale());
		schoolDetails.add(school.getSatVerbal());
		schoolDetails.add(school.getSatMath());
		schoolDetails.add(school.getCost());
		schoolDetails.add(school.getPercentFinAid());
		schoolDetails.add(school.getApplicants());
		schoolDetails.add(school.getPercentAdmitted());
		schoolDetails.add(school.getPercentEnrolled());
		schoolDetails.add(school.getAcademicScale());
		schoolDetails.add(school.getSocialScale());
		schoolDetails.add(school.getQualityOfLife());
		for(int i = 0; i < school.getEmphases().length; i++)
		{
			schoolDetails.add(school.getEmphases()[i]);
		}
		return schoolDetails;

	}

	/**
	 * updates the information for a school from what the admin provided
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
	 * @param savedSchool
	 * @return
	 */
	public int updateUniversityInfo(String name, String state, String location, String control,
			String enrollment, String percentFemale, String satVerbal, String satMath, String cost,
			String percentFinAid, String applicants, String percentAdmitted, String percentEnrolled,
			String academicScale, String socialScale, String qualityOfLife, String[] emphases) {
		// goes through and tests every parameter to see if it has a value so that only
		// the parameters with new values are updated
		
		if (state == null || state.length() < 1) {
			school.setState("-1");
		} else {
			school.setState(state);
		}

		if (location == null || location.length() < 1) {
			school.setLocation("-1");
			;
		} else {
			school.setLocation(location);
		}

		if (control == null || control.length() < 1) {
			school.setControl("-1");
		} else {
			school.setControl(control);
		}

		if (enrollment.matches("\\d+")) {
			school.setEnrollment(enrollment);
		} else if (enrollment == null || enrollment.length() < 1) {
			school.setEnrollment("-1");
		} else {
			return -2;
		}

		if (percentFemale.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentFemale) >= 0.0
				&& Double.parseDouble(percentFemale) <= 100.0) {
			school.setPercentFemale(percentFemale);
		} else if (percentFemale == null || percentFemale.length() < 1) {
			school.setPercentFemale("-1.0");
		} else {
			return -3;
		}

		if (satVerbal.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(satVerbal) >= 200
				&& Double.parseDouble(satVerbal) <= 800) {
			school.setSatVerbal(satVerbal);
		} else if (satVerbal == null || satVerbal.length() < 1) {
			school.setSatVerbal("-1.0");
		} else {
			return -4;
		}

		if (satMath.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(satMath) >= 200
				&& Double.parseDouble(satMath) <= 800) {
			school.setSatMath(satMath);
		} else if (satMath == null || satMath.length() < 1) {
			school.setSatMath("-1.0");
		} else {
			return -5;
		}

		if (cost.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(cost) >= 0.0) {
			school.setCost(cost);
		} else if (cost == null || cost.length() < 1) {
			school.setCost("-1.0");
		} else {
			return -6;
		}

		if (percentFinAid.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentFinAid) >= 0.0
				&& Double.parseDouble(percentFinAid) <= 100.0) {
			school.setPercentFinAid(percentFinAid);
		} else if (percentFinAid == null || percentFinAid.length() < 1) {
			school.setPercentFinAid("-1.0");
		} else {
			return -7;
		}

		if (applicants.matches("\\d+")) {
			school.setApplicants(applicants);
		} else if (applicants == null || applicants.length() < 1) {
			school.setApplicants("-1");
		} else {
			return -8;
		}

		if (percentAdmitted.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentAdmitted) >= 0
				&& Double.parseDouble(percentAdmitted) <= 100) {
			school.setPercentAdmitted(percentAdmitted);
		} else if (percentAdmitted == null || percentAdmitted.length() < 1) {
			school.setPercentAdmitted("-1.0");
		} else {
			return -9;
		}

		if (percentEnrolled.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentEnrolled) >= 0
				&& Double.parseDouble(percentEnrolled) <= 100) {
			school.setPercentEnrolled(percentEnrolled);
		} else if (percentEnrolled == null || percentEnrolled.length() < 1) {
			school.setPercentEnrolled("-1.0");
		} else {
			return -10;
		}

		if (academicScale.matches("[12345]")) {
			school.setAcademicScale(academicScale);
		} else if (academicScale == null || academicScale.length() < 1) {
			school.setAcademicScale("-1");
		} else {
			return -11;
		}

		if (socialScale.matches("[12345]")) {
			school.setSocialScale(socialScale);
		} else if (socialScale == null || socialScale.length() < 1) {
			school.setSocialScale("-1");
		} else {
			return -11;
		}

		if (qualityOfLife.matches("[12345]")) {
			school.setQualityOfLife(qualityOfLife);
		} else if (qualityOfLife == null || qualityOfLife.length() < 1) {
			school.setQualityOfLife("-1");
		} else {
			return -11;
		}


		this.DBCon.editUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(),
				school.getEnrollment(), school.getPercentFemale(), school.getSatVerbal(), school.getSatMath(),
				school.getCost(), school.getPercentFinAid(), school.getApplicants(), school.getPercentAdmitted(),
				school.getPercentEnrolled(), school.getAcademicScale(), school.getSocialScale(),
				school.getQualityOfLife());

		return 1;
	}

	/**
	 * Create a new University
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
	 * @return
	 */
	public int createNewUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String applicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		/*
		 * University newSchool; newSchool = new University(name, state, location,
		 * control, enrollment, percentFemale, satVerbal, satMath, cost, percentFinAid,
		 * percentEnrolled, applicants, percentAdmitted, academicScale, socialScale,
		 * qualityOfLife, emphases); this.school = newSchool; return newSchool;
		 */

		if (name == null || name.length() < 1) {
			return -1;
		} else {
			school.setName(name);
		}

		if (state == null || state.length() < 1) {
			school.setState("-1");
		} else {
			school.setState(state);
		}

		if (location == null || location.length() < 1) {
			school.setLocation("-1");
			;
		} else {
			school.setLocation(location);
		}

		if (control == null || control.length() < 1) {
			school.setControl("-1");
		} else {
			school.setControl(control);
		}

		if (enrollment.matches("\\d+")) {
			school.setEnrollment(enrollment);
		} else if (enrollment == null || enrollment.length() < 1) {
			school.setEnrollment("-1");
		} else {
			return -2;
		}

		if (percentFemale.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentFemale) >= 0.0
				&& Double.parseDouble(percentFemale) <= 100.0) {
			school.setPercentFemale(percentFemale);
		} else if (percentFemale == null || percentFemale.length() < 1) {
			school.setPercentFemale("-1.0");
		} else {
			return -3;
		}

		if (satVerbal.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(satVerbal) >= 200
				&& Double.parseDouble(satVerbal) <= 800) {
			school.setSatVerbal(satVerbal);
		} else if (satVerbal == null || satVerbal.length() < 1) {
			school.setSatVerbal("-1.0");
		} else {
			return -4;
		}

		if (satMath.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(satMath) >= 200
				&& Double.parseDouble(satMath) <= 800) {
			school.setSatMath(satMath);
		} else if (satMath == null || satMath.length() < 1) {
			school.setSatMath("-1.0");
		} else {
			return -5;
		}

		if (cost.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(cost) >= 0.0) {
			school.setCost(cost);
		} else if (cost == null || cost.length() < 1) {
			school.setCost("-1.0");
		} else {
			return -6;
		}

		if (percentFinAid.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentFinAid) >= 0.0
				&& Double.parseDouble(percentFinAid) <= 100.0) {
			school.setPercentFinAid(percentFinAid);
		} else if (percentFinAid == null || percentFinAid.length() < 1) {
			school.setPercentFinAid("-1.0");
		} else {
			return -7;
		}

		if (applicants.matches("\\d+")) {
			school.setApplicants(applicants);
		} else if (applicants == null || applicants.length() < 1) {
			school.setApplicants("-1");
		} else {
			return -8;
		}

		if (percentAdmitted.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentAdmitted) >= 0
				&& Double.parseDouble(percentAdmitted) <= 100) {
			school.setPercentAdmitted(percentAdmitted);
		} else if (percentAdmitted == null || percentAdmitted.length() < 1) {
			school.setPercentAdmitted("-1.0");
		} else {
			return -9;
		}

		if (percentEnrolled.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(percentEnrolled) >= 0
				&& Double.parseDouble(percentEnrolled) <= 100) {
			school.setPercentEnrolled(percentEnrolled);
		} else if (percentEnrolled == null || percentEnrolled.length() < 1) {
			school.setPercentEnrolled("-1.0");
		} else {
			return -10;
		}

		if (academicScale.matches("[12345]")) {
			school.setAcademicScale(academicScale);
		} else if (academicScale == null || academicScale.length() < 1) {
			school.setAcademicScale("-1");
		} else {
			return -11;
		}

		if (socialScale.matches("[12345]")) {
			school.setSocialScale(socialScale);
		} else if (socialScale == null || socialScale.length() < 1) {
			school.setSocialScale("-1");
		} else {
			return -11;
		}

		if (qualityOfLife.matches("[12345]")) {
			school.setQualityOfLife(qualityOfLife);
		} else if (qualityOfLife == null || qualityOfLife.length() < 1) {
			school.setQualityOfLife("-1");
		} else {
			return -11;
		}

		this.DBCon.addUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(),
				school.getEnrollment(), school.getPercentFemale(), school.getSatVerbal(), school.getSatMath(),
				school.getCost(), school.getPercentFinAid(), school.getApplicants(), school.getPercentAdmitted(),
				school.getPercentEnrolled(), school.getAcademicScale(), school.getSocialScale(),
				school.getQualityOfLife());

		if (emphases == null || emphases.length == 0) {
			school.setEmphases(null);
		} else {
			school.setEmphases(emphases);
			for (String e : emphases) {
				this.DBCon.addEmphasis(name, e);
			}
		}
		return 1; // create a new university successfully
	}

}

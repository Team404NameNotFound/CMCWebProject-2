/**
 * Allows for the creation of UserSavedSchool objects (a type of University)
 */
package cmc.entity;

import java.util.ArrayList;

public class UserSavedSchool extends University {

	/**
	 * @author kmendel001
	 * 
	 */

	private String dateAdded;

	/**
	 * Creates a UserSavedSchool object with the following attributes
	 * 
	 * @param name
	 *            name of the university
	 * @param state
	 *            state where the university is located
	 * @param location
	 *            setting where the university is located
	 * @param control
	 *            what type of control the university is under
	 * @param enrollment
	 *            number of students enrolled at the university
	 * @param percentFemale
	 *            percentage of the study body that is female
	 * @param satVerbal
	 *            average verbal SAT score of student body
	 * @param satMath
	 *            average math SAT score of student body
	 * @param cost
	 *            annual tuition to attend university
	 * @param percentFinAid
	 *            percentage of study body that received financial aid
	 * @param percentEnrolled
	 *            percent of applicants that decide to enroll
	 * @param applicants
	 *            annual number of applicants
	 * @param percentAdmitted
	 *            percent of applicants that get admitted
	 * @param academicScale
	 *            integer value between 1 and 5 indicating academic scale of the
	 *            university
	 * @param socialScale
	 *            integer value between 1 and 5 indicating social life at the
	 *            university
	 * @param qualityOfLife
	 *            integer value between 1 and 5 indicating quality of life at the
	 *            university
	 * @param emphases
	 *            up to five areas of study that the university excels in
	 * @param dateAdded
	 *            date when a student saves a school
	 */
	public UserSavedSchool(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases, String dateAdded) {
		super(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost, percentFinAid,
				percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases);
		this.dateAdded = dateAdded;
	}

	/**
	 * Creates a UserSaved school object with the following attributes
	 * 
	 * @param school
	 *            university object that users wants to add
	 * @param dateAdded
	 *            the date when a student saves the school
	 */
	public UserSavedSchool(University school, String dateAdded) {
		super(school.getName(), school.getState(), school.getLocation(), school.getControl(), school.getEnrollment(),
				school.getPercentFemale(), school.getSatVerbal(), school.getSatMath(), school.getCost(),
				school.getPercentFinAid(), school.getPercentEnrolled(), school.getApplicants(),
				school.getPercentAdmitted(), school.getAcademicScale(), school.getSocialScale(),
				school.getQualityOfLife(), school.getEmphases());
		this.dateAdded = dateAdded;
	}

	/**
	 * @return date the student saved the school
	 */
	public String getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded
	 *            date the student saved the school
	 */
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

}

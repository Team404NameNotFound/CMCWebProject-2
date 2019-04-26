/**
g * This class allows for the creation of University objects
 */
package cmc.entity;

import java.util.*;

/**
 * @author kmendel001
 *
 */
public class University {

	/**
	 * 
	 */
	private String name;
	private String state;
	private String location;
	private String control;
	private String enrollment;
	private String percentFemale;
	private String satVerbal;
	private String satMath;
	private String cost;
	private String percentFinAid;
	private String percentEnrolled;
	private String applicants;
	private String percentAdmitted;
	private String academicScale;
	private String socialScale;
	private String qualityOfLife;
	private String[] emphases;
	// private ArrayList<String> students = new ArrayList<>();

	/**
	 * Creates a new university object with the following attributes
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
	 */

	public University() {
		this.name = "";
		this.state = "";
		this.location = "";
		this.control = "";
		this.enrollment = "";
		this.percentFemale = "";
		this.satVerbal = "";
		this.satMath = "";
		this.cost = "";
		this.percentFinAid = "";
		this.percentEnrolled = "";
		this.applicants = "";
		this.percentAdmitted = "";
		this.academicScale = "";
		this.socialScale = "";
		this.qualityOfLife = "";
		this.emphases = null;
	}

	public University(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String applicants, String percentAdmitted, String percentEnrolled,  String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		super();
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.enrollment = enrollment;
		this.percentFemale = percentFemale;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.cost = cost;
		this.percentFinAid = percentFinAid;
		this.percentEnrolled = percentEnrolled;
		this.applicants = applicants;
		this.percentAdmitted = percentAdmitted;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualityOfLife = qualityOfLife;
		this.emphases = emphases;
	}

	/**
	 * @return university name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            university name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return state where the university is located
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            where the university is located
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return what setting the university is located in
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            what setting the university is located in
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the type of control a university is under
	 */
	public String getControl() {
		return control;
	}

	/**
	 * @param control
	 *            the type of control a university is under
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * @return the number of students that attend a university
	 */
	public String getEnrollment() {
		return enrollment;
	}

	/**
	 * @param enrollment
	 *            the number of students that attend a university
	 */
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	/**
	 * @return percentage of the student body at the university that is female
	 */
	public String getPercentFemale() {
		return percentFemale;
	}

	/**
	 * @param percentFemale
	 *            percentage of the student body at the university that is female
	 */
	public void setPercentFemale(String percentFemale) {
		this.percentFemale = percentFemale;
	}

	/**
	 * @return average verbal SAT score of the student body
	 */
	public String getSatVerbal() {
		return satVerbal;
	}

	/**
	 * @param satVerbal
	 *            average verbal SAT score of the student body
	 */
	public void setSatVerbal(String satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * @return average math SAT score of the student body
	 */
	public String getSatMath() {
		return satMath;
	}

	/**
	 * @param satMath
	 *            average math SAT score of the student body
	 */
	public void setSatMath(String satMath) {
		this.satMath = satMath;
	}

	/**
	 * @return annual tuition of a university
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            annual tuition of a university
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}

	/**
	 * @return percentage of the student body that received financial aid
	 */
	public String getPercentFinAid() {
		return percentFinAid;
	}

	/**
	 * @param percentFinAid
	 *            percentage of the student body that received financial aid
	 */
	public void setPercentFinAid(String percentFinAid) {
		this.percentFinAid = percentFinAid;
	}

	/**
	 * @return percentage of applicants that enroll
	 */
	public String getPercentEnrolled() {
		return percentEnrolled;
	}

	/**
	 * @param percentEnrolled
	 *            percentage of applicants that enroll
	 */
	public void setPercentEnrolled(String percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}

	/**
	 * @return percentage of applicants that enroll
	 */
	public String getApplicants() {
		return applicants;
	}

	/**
	 * @param applicants
	 *            percentage of applicants that enroll
	 */
	public void setApplicants(String applicants) {
		this.applicants = applicants;
	}

	/**
	 * @return percentage of total applicants that are admitted
	 */
	public String getPercentAdmitted() {
		return percentAdmitted;
	}

	/**
	 * @param percentAdmitted
	 *            percentage of total applicants that are admitted
	 */
	public void setPercentAdmitted(String percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}

	/**
	 * @return academic scale of school
	 */
	public String getAcademicScale() {
		return academicScale;
	}

	/**
	 * @param academicScale
	 *            academic scale of school
	 */
	public void setAcademicScale(String academicScale) {
		this.academicScale = academicScale;
	}

	/**
	 * @return social scale of school
	 */
	public String getSocialScale() {
		return socialScale;
	}

	/**
	 * @param socialScale
	 *            social scale of school
	 */
	public void setSocialScale(String socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * @return quality of life scale at school
	 */
	public String getQualityOfLife() {
		return qualityOfLife;
	}

	/**
	 * @param qualityOfLife
	 *            quality of life scale at school
	 */
	public void setQualityOfLife(String qualityOfLife) {
		this.qualityOfLife = qualityOfLife;
	}

	/**
	 * @return list of up to five areas that the university excels in
	 */
	public String[] getEmphases() {
		return emphases;
	}

	/**
	 * @param emphases
	 *            list of up to five areas that the university excels in
	 */
	public void setEmphases(String[] emphases) {
		this.emphases = emphases;
	}
	
	public String negOneStripper(String value) {
		if (value.equals("-1")) {
			return "";
		}
		return value;
	}

}

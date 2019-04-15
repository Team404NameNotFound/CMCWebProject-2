/**
 * 
 */
package cmc.functionality;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import cmc.entity.Student;
import cmc.entity.University;

/**
 * @author kmendel001
 *
 */
public class SearchController {

	String[] quizQuestions = { "How would you describe the location of your ideal college?",
			"Which characteristics are most important to you when looking for a college",
			"I prefer large lectures where I can observe and be anonymous, rather than small discussions with participation and my professors know my name ",
			"Do you know what you would like to study?" };
	University[] universityList;

	/**
	 * This constructor will create a new SearchController with a list of all
	 * University
	 * 
	 * @param allSchools
	 */
	public SearchController(ArrayList<University> allSchools) {
		this.universityList = new University[allSchools.size()];
		for (int i = 0; i < allSchools.size(); i++) {

			this.universityList[i] = allSchools.get(i);
		}

	}

	/**
	 * Retrieve all the quiz questions in SearchController
	 * 
	 * @return quizQuestions
	 */
	public String[] getQuizQuestions() {
		return quizQuestions;
	}

	/**
	 * Searching a school use some fields
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
	 * @param SATMathMin
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
	 * @return returnSchools
	 */
	public ArrayList<University> fieldSearch(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, int SATVerbalMax,
			int SATMathMin, int SATMathMax, int expensesMin, int expensesMax, float PercentFinancialAidMin,
			float percenetFinancialAidMax, int numberApplicantsMin, int numberApplicatnsMax, float percentAddmittedMin,
			float percentAdmittedMax, float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin,
			int academicScaleMax, int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax,
			String[] emphases, String control) {
		ArrayList<University> returnSchools = new ArrayList<University>();
		for (int i = 0; i < this.universityList.length; i++) {
			Boolean emphMatch = false;
			for (int j = 0; j < emphases.length; j++) {
				String emph = emphases[j];
				String[] testList = universityList[i].getEmphases();
				for (int k = 0; k < testList.length; k++) {
					if (emph.equals(testList[k])) {
						emphMatch = true;
					}
				}
			}
			if(numStudentsMin<-1|| numStudentsMax <-1|| percentFemaleMin<-1 || percentFemaleMin>100 || percentFemaleMax<-1|| percentFemaleMax>100
			|| SATVerbalMin<-1 || SATVerbalMin>800 || SATVerbalMax <-1 || SATVerbalMax >800|| SATMathMin < -1 || SATMathMin > 100 ||
			SATMathMax< -1 || SATMathMax> 800 || expensesMin<-1 ||expensesMax<-1 || PercentFinancialAidMin <-1||
			percenetFinancialAidMax <-1 || numberApplicantsMin <-1 || numberApplicatnsMax <-1 || percentAddmittedMin<-1 ||
			percentAdmittedMax <-1 || percentEnrolledMin <-1 || percentEnrolledMax <-1|| academicScaleMin <-1 ||
			academicScaleMax <-1 || socialScalemin <-1 || socialScaleMax<-1 || qualityOfLifeMin <-1 || qualityOfLifeMax <-1)
			{
				throw new IllegalArgumentException("Sorry, invalid parameters");
			}
			
			if (emphMatch || emphases.length == 0) {

				if ((Integer.parseInt(this.universityList[i].getEnrollment()) > numStudentsMin
						&& Integer.parseInt(this.universityList[i].getEnrollment()) < numStudentsMax)
						|| (Integer.parseInt(this.universityList[i].getEnrollment()) > numStudentsMin
								&& numStudentsMax == -1)
						|| (Integer.parseInt(this.universityList[i].getEnrollment()) < numStudentsMax
								&& numStudentsMax == -1 || numStudentsMax == -1 && numStudentsMax == -1)) {
					if ((Float.parseFloat(this.universityList[i].getPercentFemale()) > percentFemaleMin
							&& (Float.parseFloat(this.universityList[i].getPercentFemale()) < percentFemaleMax)
							|| (Float.parseFloat(this.universityList[i].getEnrollment()) > percentFemaleMin
									&& percentFemaleMax == -1)
							|| (Float.parseFloat(this.universityList[i].getEnrollment()) < percentFemaleMax
									&& percentFemaleMin == -1)
							|| percentFemaleMin == -1 && percentFemaleMax == -1)) {
						if ((Integer.parseInt(this.universityList[i].getSatVerbal()) > SATVerbalMin
								&& Integer.parseInt(this.universityList[i].getSatVerbal()) < SATVerbalMax)
								|| (Integer.parseInt(this.universityList[i].getSatVerbal()) > SATVerbalMin
										&& SATVerbalMin == -1)
								|| (Integer.parseInt(this.universityList[i].getSatVerbal()) < SATVerbalMax
										&& SATVerbalMax == -1)
								|| SATVerbalMin == -1 && SATVerbalMax == -1) {
							if ((Integer.parseInt(this.universityList[i].getSatMath()) > SATMathMin
									&& Integer.parseInt(this.universityList[i].getSatMath()) < SATMathMax)
									|| (Integer.parseInt(this.universityList[i].getSatMath()) > SATMathMin
											&& SATMathMin == -1)
									|| (Integer.parseInt(this.universityList[i].getSatVerbal()) < SATMathMax
											&& SATMathMax == -1)
									|| SATMathMin == -1 && SATMathMax == -1) {
								if ((Integer.parseInt(this.universityList[i].getCost()) > expensesMin
										&& Integer.parseInt(this.universityList[i].getCost()) < expensesMax)
										|| (Integer.parseInt(this.universityList[i].getCost()) > expensesMin
												&& expensesMax == -1)
										|| (Integer.parseInt(this.universityList[i].getCost()) < expensesMax
												&& expensesMin == -1)
										|| expensesMin == -1 && expensesMax == -1) {
									if ((Float.parseFloat(
											this.universityList[i].getPercentFinAid()) > PercentFinancialAidMin
											&& (Float.parseFloat(this.universityList[i]
													.getPercentFinAid()) < percenetFinancialAidMax)
											|| (Float.parseFloat(
													this.universityList[i].getPercentFinAid()) > PercentFinancialAidMin
													&& percenetFinancialAidMax == -1)
											|| (Float.parseFloat(
													this.universityList[i].getPercentFinAid()) < percenetFinancialAidMax
													&& PercentFinancialAidMin == -1)
											|| percenetFinancialAidMax == -1 && PercentFinancialAidMin == -1)) {
										if ((Integer
												.parseInt(this.universityList[i].getApplicants()) > numberApplicantsMin
												&& Integer.parseInt(
														this.universityList[i].getApplicants()) < numberApplicatnsMax)
												|| (Integer.parseInt(
														this.universityList[i].getApplicants()) > numberApplicantsMin
														&& numberApplicatnsMax == -1)
												|| (Integer.parseInt(
														this.universityList[i].getApplicants()) < numberApplicatnsMax
														&& numberApplicantsMin == -1
														|| numberApplicantsMin == -1 && numberApplicatnsMax == -1)) {
											if ((Float.parseFloat(
													this.universityList[i].getPercentAdmitted()) > percentAddmittedMin
													&& (Float.parseFloat(this.universityList[i]
															.getPercentFinAid()) < percentAddmittedMin)
													|| (Float
															.parseFloat(this.universityList[i]
																	.getPercentAdmitted()) > percentAddmittedMin
															&& percentAdmittedMax == -1)
													|| (Float
															.parseFloat(this.universityList[i]
																	.getPercentAdmitted()) < percentAdmittedMax
															&& percentAddmittedMin == -1)
													|| percentAddmittedMin == -1 && percentAdmittedMax == -1)) {
												if ((Float
														.parseFloat(this.universityList[i]
																.getPercentEnrolled()) > percentEnrolledMin
														&& (Float.parseFloat(this.universityList[i]
																.getPercentEnrolled()) < percentEnrolledMin)
														|| (Float
																.parseFloat(this.universityList[i]
																		.getPercentEnrolled()) > percentEnrolledMin
																&& percentEnrolledMax == -1)
														|| (Float
																.parseFloat(this.universityList[i]
																		.getPercentEnrolled()) < percentEnrolledMax
																&& percentEnrolledMin == -1)
														|| percentEnrolledMin == -1 && percentEnrolledMax == -1)) {
													if ((Integer
															.parseInt(this.universityList[i]
																	.getAcademicScale()) > academicScaleMin
															&& Integer.parseInt(this.universityList[i]
																	.getAcademicScale()) < academicScaleMax)
															|| (Integer
																	.parseInt(this.universityList[i]
																			.getAcademicScale()) > academicScaleMin
																	&& academicScaleMax == -1)
															|| (Integer
																	.parseInt(this.universityList[i]
																			.getAcademicScale()) < academicScaleMax
																	&& academicScaleMin == -1)
															|| academicScaleMin == -1 && academicScaleMax == -1) {
														if ((Integer
																.parseInt(this.universityList[i]
																		.getSocialScale()) > socialScalemin
																&& Integer.parseInt(this.universityList[i]
																		.getSocialScale()) < socialScaleMax)
																|| (Integer
																		.parseInt(this.universityList[i]
																				.getSocialScale()) > socialScalemin
																		&& academicScaleMax == -1)
																|| (Integer
																		.parseInt(this.universityList[i]
																				.getSocialScale()) < socialScaleMax
																		&& socialScalemin == -1)
																|| socialScalemin == -1 && socialScaleMax == -1) {
															if ((Integer
																	.parseInt(this.universityList[i]
																			.getQualityOfLife()) > qualityOfLifeMin
																	&& Integer.parseInt(this.universityList[i]
																			.getQualityOfLife()) < qualityOfLifeMax)
																	|| (Integer.parseInt(this.universityList[i]
																			.getQualityOfLife()) > qualityOfLifeMin
																			&& qualityOfLifeMax == -1)
																	|| (Integer.parseInt(this.universityList[i]
																			.getQualityOfLife()) < qualityOfLifeMax
																			&& qualityOfLifeMin == -1)
																	|| qualityOfLifeMin == -1
																			&& qualityOfLifeMax == -1) {
																if (state.toLowerCase().trim()
																		.equals(this.universityList[i].getState()
																				.toLowerCase().trim())
																		|| state.equals("-1")) {
																	if (this.universityList[i].getName().toLowerCase()
																			.trim()
																			.contains(schoolName.toLowerCase().trim())
																			|| schoolName.equals("-1")) {
																		if (location.toLowerCase().trim()
																				.equals(this.universityList[i]
																						.getLocation().toLowerCase()
																						.trim())
																				|| location.equals("-1")) {
																			if (control.toLowerCase().trim()
																					.equals(this.universityList[i]
																							.getControl().toLowerCase()
																							.trim())
																					|| control.equals("-1")) {
																				returnSchools
																						.add(this.universityList[i]);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return returnSchools;
	}

	/**
	 * Rank the university
	 * 
	 * @param university
	 * @return returnUniversity
	 */
	public ArrayList<University> rankUniversity(University university) {
		ArrayList<University> returnUniversity = new ArrayList<University>();
		int numStudents = Integer.parseInt(university.getEnrollment());
		float percentFemale = Float.parseFloat(university.getPercentFemale());
		int SatVerbal = Integer.parseInt(university.getSatVerbal());
		int SatMath = Integer.parseInt(university.getSatMath());
		int expenses = Integer.parseInt(university.getCost());
		float percentFinAid = Float.parseFloat(university.getPercentFinAid());
		int numApplicants = Integer.parseInt(university.getApplicants());
		float percentAdmitted = Float.parseFloat(university.getPercentAdmitted());
		float percentEnrolled = Float.parseFloat(university.getPercentEnrolled());
		int academicScale = Integer.parseInt(university.getAcademicScale());
		int socialScale = Integer.parseInt(university.getSocialScale());
		int qualityOfLifeScale = Integer.parseInt(university.getQualityOfLife());

		double[][] schoolMatches = new double[this.universityList.length][2];
		// finding closest schools to provided school
		for (int i = 0; i < this.universityList.length; i++) {
			Double score = 0.0;

			// testing distance based on enrollment
			score = score
					+ (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudents)) / (numStudents));

			// testing distance based on percent female
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemale))
					/ (percentFemale));

			// testing distance based on SATVerbal
			score = score
					+ (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SatVerbal)) / (SatVerbal));

			// testing distance based on SATMath
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SatMath)) / (SatMath));

			// calculating score based on epenses
			score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) - expenses)) / (expenses));

			// testing distance based on FinancialAid
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - percentFinAid))
					/ (percentFinAid));

			// testing distance based on numberApplicants

			score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numApplicants))
					/ (numApplicants));

			// testing distance based on percentAdmitted
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAdmitted))
					/ (percentAdmitted));

			// testing distance based on percentEnrolled
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentEnrolled))
					/ (percentEnrolled));

			// testing distance based on academicSclae
			score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScale))
					/ (academicScale));

			// testing distance based on socialScale
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScale))
					/ (socialScale));

			// tesing distance distance based on qualityoflife
			score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeScale))
					/ (qualityOfLifeScale));

			// setting final score of university
			schoolMatches[i][0] = score;// i};
			schoolMatches[i][1] = Double.parseDouble("" + i);
		}

		java.util.Arrays.sort(schoolMatches, new java.util.Comparator<double[]>() {
			public int compare(double[] a, double[] b) {
				return Double.compare(a[0], b[0]);
			}
		});

		for (int i = 0; i < 5; i++) {
			int position = (int) schoolMatches[i + 1][1];
			returnUniversity.add(universityList[position]);
		}

		return returnUniversity;
	}

	public ArrayList<University> rankUniversity2(University university) {
		ArrayList<University> returnUniversity = new ArrayList<University>();
		String state = university.getState();
		String location = university.getLocation();
		String control = university.getControl();
		double numStudents = Integer.parseInt(university.getEnrollment());
		double numStudMin = Integer.parseInt(university.getEnrollment());
		double numStudMax = Integer.parseInt(university.getEnrollment());
		double percentFemale = Float.parseFloat(university.getPercentFemale());
		double nperFemMin = Float.parseFloat(university.getPercentFemale());
		double perFemMax = Float.parseFloat(university.getPercentFemale());
		double SatVerbal = Integer.parseInt(university.getSatVerbal());
		double SatVerbalMin = Integer.parseInt(university.getSatVerbal());
		double SatVerbalMax = Integer.parseInt(university.getSatVerbal());
		double SatMath = Integer.parseInt(university.getSatMath());
		double SatMathMin = Integer.parseInt(university.getSatMath());
		double SatMathMax = Integer.parseInt(university.getSatMath());
		double expenses = Integer.parseInt(university.getCost());
		double expMin = Integer.parseInt(university.getCost());
		double expMax = Integer.parseInt(university.getCost());
		double percentFinAid = Float.parseFloat(university.getPercentFinAid());
		double perFinAidMin = Float.parseFloat(university.getPercentFinAid());
		double perFinAidMax = Float.parseFloat(university.getPercentFinAid());
		double numApplicants = Integer.parseInt(university.getApplicants());
		double numAppMin = Integer.parseInt(university.getApplicants());
		double numAppMax = Integer.parseInt(university.getApplicants());
		double percentAdmitted = Float.parseFloat(university.getPercentAdmitted());
		double perAdmitMin = Float.parseFloat(university.getPercentAdmitted());
		double perAdmitMax = Float.parseFloat(university.getPercentAdmitted());
		double percentEnrolled = Float.parseFloat(university.getPercentEnrolled());
		double perEnrollMin = Float.parseFloat(university.getPercentEnrolled());
		double perEnrollMax = Float.parseFloat(university.getPercentEnrolled());
		double academicScale = Integer.parseInt(university.getAcademicScale());
		double academicMin = Integer.parseInt(university.getAcademicScale());
		double academicMax = Integer.parseInt(university.getAcademicScale());
		double socialScale = Integer.parseInt(university.getSocialScale());
		double socialMin = Integer.parseInt(university.getSocialScale());
		double socialMax = Integer.parseInt(university.getSocialScale());
		double qualityOfLifeScale = Integer.parseInt(university.getQualityOfLife());
		double qolMin = Integer.parseInt(university.getQualityOfLife());
		double qolMax = Integer.parseInt(university.getQualityOfLife());

		double[][] schoolMatches = new double[this.universityList.length][2];

		for (int i = 0; i < this.universityList.length; i++) {
			// testing distance based on enrollment
			if (Math.abs((Double.parseDouble(universityList[i].getEnrollment()))) <= numStudMin) {
				numStudMin = Math.abs((Double.parseDouble(universityList[i].getEnrollment())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getEnrollment()))) >= numStudMax) {
				numStudMax = Math.abs((Double.parseDouble(universityList[i].getEnrollment())));
			}

			// testing distance based on percent female
			if (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()))) <= nperFemMin) {
				nperFemMin = Math.abs((Double.parseDouble(universityList[i].getPercentFemale())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()))) >= perFemMax) {
				perFemMax = Math.abs((Double.parseDouble(universityList[i].getPercentFemale())));
			}

			// testing distance based on SATVerbal
			if (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()))) <= SatVerbalMin) {
				SatVerbalMin = Math.abs((Double.parseDouble(universityList[i].getSatVerbal())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()))) >= SatVerbalMax) {
				SatVerbalMax = Math.abs((Double.parseDouble(universityList[i].getSatVerbal())));
			}

			// testing distance based on SATMath
			if (Math.abs((Double.parseDouble(universityList[i].getSatMath()))) <= SatMathMin) {
				SatMathMin = Math.abs((Double.parseDouble(universityList[i].getSatMath())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getSatMath()))) >= SatMathMax) {
				SatMathMax = Math.abs((Double.parseDouble(universityList[i].getSatMath())));
			}

			// calculating score based on expenses
			if (Math.abs((Double.parseDouble(universityList[i].getCost()))) <= expMin) {
				expMin = Math.abs((Double.parseDouble(universityList[i].getCost())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getCost()))) >= expMax) {
				expMax = Math.abs((Double.parseDouble(universityList[i].getCost())));
			}

			// testing distance based on FinancialAid
			if (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()))) <= perFinAidMin) {
				perFinAidMin = Math.abs((Double.parseDouble(universityList[i].getPercentFinAid())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()))) >= perFinAidMax) {
				perFinAidMax = Math.abs((Double.parseDouble(universityList[i].getPercentFinAid())));
			}

			// testing distance based on numberApplicants

			if (Math.abs((Double.parseDouble(universityList[i].getApplicants()))) <= numAppMin) {
				numAppMin = Math.abs((Double.parseDouble(universityList[i].getApplicants())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getApplicants()))) >= numAppMax) {
				numAppMax = Math.abs((Double.parseDouble(universityList[i].getApplicants())));
			}

			// testing distance based on percentAdmitted
			if (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()))) <= perAdmitMin) {
				perAdmitMin = Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()))) >= perAdmitMax) {
				perAdmitMax = Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted())));
			}

			// testing distance based on percentEnrolled
			if (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()))) <= perEnrollMin) {
				perEnrollMin = Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()))) >= perEnrollMax) {
				perEnrollMax = Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled())));
			}

			// testing distance based on academicSclae
			if (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()))) <= academicMin) {
				academicMin = Math.abs((Double.parseDouble(universityList[i].getAcademicScale())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()))) >= academicMax) {
				academicMax = Math.abs((Double.parseDouble(universityList[i].getAcademicScale())));
			}

			// testing distance based on socialScale
			if (Math.abs((Double.parseDouble(universityList[i].getSocialScale()))) <= socialMin) {
				socialMin = Math.abs((Double.parseDouble(universityList[i].getSocialScale())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getSocialScale()))) >= socialMax) {
				socialMax = Math.abs((Double.parseDouble(universityList[i].getSocialScale())));
			}

			// tesing distance distance based on qualityoflife
			if (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()))) <= qolMin) {
				qolMin = Math.abs((Double.parseDouble(universityList[i].getQualityOfLife())));
			}
			if (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()))) >= qolMax) {
				qolMax = Math.abs((Double.parseDouble(universityList[i].getQualityOfLife())));
			}
		}

		for (int i = 0; i < this.universityList.length; i++) {
			Double score = 0.0;

			// testing distance based on enrollment
			score = score + (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudents))
					/ (numStudMax - numStudMin));

			// testing distance based on percent female
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemale))
					/ (perFemMax - nperFemMin));

			// testing distance based on SATVerbal
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SatVerbal))
					/ (SatVerbalMax - SatVerbalMin));

			// testing distance based on SATMath
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SatMath))
					/ (SatMathMax - SatMathMin));

			// calculating score based on expenses
			score = score
					+ (Math.abs((Double.parseDouble(universityList[i].getCost()) - expenses)) / (expMax - expMin));

			// testing distance based on FinancialAid
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - percentFinAid))
					/ (perFinAidMax - perFinAidMin));

			// testing distance based on numberApplicants

			score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numApplicants))
					/ (numAppMax - numAppMin));

			// testing distance based on percentAdmitted
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAdmitted))
					/ (perAdmitMax - perAdmitMin));

			// testing distance based on percentEnrolled
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentEnrolled))
					/ (perEnrollMax - perEnrollMin));

			// testing distance based on academicSclae
			score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScale))
					/ (academicMax - academicMin));

			// testing distance based on socialScale
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScale))
					/ (socialMax - socialMin));

			// testing distance distance based on qualityoflife
			score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeScale))
					/ (qolMax - qolMin));
			
			//testing state
			int stateScore;
			if(universityList[i].getState().equals(state)) {
				stateScore = 0;
			}else {
				stateScore = 1;
			}
			//testing location
			int locationScore;
			if(universityList[i].getLocation().equals(location)) {
				locationScore = 0;
			}else {
				locationScore = 1;
			}
			//testing control
			int controlScore;
			if(universityList[i].getControl().equals(control)) {
				controlScore = 0;
			}else {
				controlScore = 1;
			}
			

			// setting final score of university
			schoolMatches[i][0] = score + stateScore + locationScore + controlScore;// i};
			schoolMatches[i][1] = Double.parseDouble("" + i);
		}

		// java.util.Arrays.sort(schoolMatches, new java.util.Comparator<double[]>() {
		// public int compare(double[] a, double[] b) {
		// return Double.compare(a[0], b[0]);
		// }
		// });

		java.util.Arrays.sort(schoolMatches, new java.util.Comparator<double[]>() {
			public int compare(double[] a, double[] b) {
				return Double.compare(a[0], b[0]);
			}
		});
		
		for (int i = 0; i < 5; i++) {
			int position = (int) schoolMatches[i + 1][1];
			System.out.println(schoolMatches[i + 1][0]);
			returnUniversity.add(universityList[position]);
		}
		System.out.println("Five recommendation schools for " + university.getName() + " are");
		for(University uni: returnUniversity) {
			System.out.println(uni.getName());
		}
		
		return returnUniversity;
	}
	

	/**
	 * @param schoolName
	 * @param state
	 * @param location
	 * @param numStudentsMin
	 * @param numStudentsMax
	 * @param percentFemaleMin
	 * @param percentFemaleMax
	 * @param SATVerbalMin
	 * @param SATVerbalMax
	 * @param SATMathMin
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
	 * @param qualityOfLifeMine
	 * @param qualityOfLifeMax
	 * @param emphases
	 * @param control
	 * @return
	 */
	// public ArrayList<University> search(String schoolName, String state, String
	// location, int numStudentsMin,
	// int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int
	// SATVerbalMin,
	// int SATVerbalMax, int SATMathMin, int SATMathMax, int expensesMin, int
	// expensesMax,
	// float PercentFinancialAidMin, float percenetFinancialAidMax, int
	// numberApplicantsMin,
	// int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
	// float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int
	// academicScaleMax,
	// int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int
	// qualityOfLifeMax, String[] emphases, String control
	// )
	// {
	// double[][] schoolMatches = new double[this.universityList.length][2];
	// int schoolNumStudentMin = 10000000;
	// int schoolNumStudentMax = 0;
	// float schoolPerFemaleMin = (float) 1.0;
	// float schoolPerFemaleMax = (float) 0.0;
	// int schoolSATVMin = 800;
	// int schoolSATVMax = 0;
	// int schoolSATMMin = 800;
	// int schoolSATMMax = 0;
	// int schoolExpensesMin = 10000000;
	// int schoolExpensesMax = 0;
	// float schoolFinAidMin = 10000000;
	// float schoolFinAidMax = 0;
	// int schoolApplicantsMin = 10000000;
	// int schoolApplicantsMax = 0;
	// float schoolAdmittedMin = (float)1.0;
	// float schoolAdmittedMax = (float) 0.0;
	// float schoolEnrolledMin = (float)1.0;
	// float schoolEnrolledMax = (float) 0.0;
	// int schoolAcademicScaleMin = 6;
	// int schoolAcademicScaleMax = 0;
	// int schoolSocialScaleMin = 6;
	// int schoolSocialScaleMax = 0;
	// int schoolQualityofLifeMin = 6;
	// int schoolQualityofLifeMax = 0;
	// for(University testSchool: universityList)
	// {
	// // System.out.println(testSchool.getPercentFemale());
	// if(Integer.parseInt(testSchool.getEnrollment()) < (schoolNumStudentMin))
	// {
	// schoolNumStudentMin = Integer.parseInt(testSchool.getEnrollment());
	// }
	// if(Integer.parseInt(testSchool.getEnrollment()) > schoolNumStudentMax)
	// {
	// schoolNumStudentMax = Integer.parseInt(testSchool.getEnrollment());
	// }
	// if(Float.parseFloat(testSchool.getPercentFemale()) < schoolPerFemaleMin)
	// {
	// schoolPerFemaleMin = Float.parseFloat(testSchool.getEnrollment());
	// }
	// if(Float.parseFloat(testSchool.getPercentFemale()) > schoolPerFemaleMax)
	// {
	// schoolPerFemaleMax = Float.parseFloat(testSchool.getPercentFemale());
	// }
	// if(Integer.parseInt(testSchool.getSatVerbal()) < schoolSATVMin)
	// {
	// schoolSATVMin = Integer.parseInt(testSchool.getSatVerbal());
	// }
	// if(Integer.parseInt(testSchool.getSatVerbal()) > schoolSATVMax)
	// {
	// schoolSATVMax = Integer.parseInt(testSchool.getSatVerbal());
	// }
	// if(Integer.parseInt(testSchool.getSatMath()) < schoolSATMMin)
	// {
	// schoolSATMMin = Integer.parseInt(testSchool.getSatMath());
	// }
	// if(Integer.parseInt(testSchool.getSatMath()) > schoolSATMMax)
	// {
	// schoolSATMMax = Integer.parseInt(testSchool.getSatMath());
	// }
	// if(Integer.parseInt(testSchool.getCost()) > schoolExpensesMin)
	// {
	// schoolExpensesMin = Integer.parseInt(testSchool.getCost());
	// }
	// if(Integer.parseInt(testSchool.getCost()) > schoolExpensesMax)
	// {
	// schoolExpensesMax = Integer.parseInt(testSchool.getCost());
	// }
	// if(Float.parseFloat(testSchool.getPercentFinAid()) < schoolFinAidMin)
	// {
	// schoolFinAidMin = Integer.parseInt(testSchool.getPercentFinAid());
	// }
	// if(Float.parseFloat(testSchool.getPercentFinAid()) > schoolFinAidMax)
	// {
	// schoolFinAidMax = Float.parseFloat(testSchool.getPercentFinAid());
	// }
	// if(Integer.parseInt(testSchool.getPercentFinAid()) < schoolApplicantsMin)
	// {
	// schoolApplicantsMin = Integer.parseInt(testSchool.getApplicants());
	// }
	// if(Integer.parseInt(testSchool.getPercentFinAid()) > schoolApplicantsMax)
	// {
	// schoolApplicantsMax = Integer.parseInt(testSchool.getApplicants());
	// }
	// if(Float.parseFloat(testSchool.getPercentAdmitted()) < schoolAdmittedMin)
	// {
	// schoolAdmittedMin = Float.parseFloat(testSchool.getPercentAdmitted());
	// }
	// if(Float.parseFloat(testSchool.getPercentAdmitted()) > schoolAdmittedMax)
	// {
	// schoolAdmittedMax = Float.parseFloat(testSchool.getPercentAdmitted());
	// }
	// if(Float.parseFloat(testSchool.getPercentEnrolled()) < schoolEnrolledMin)
	// {
	// schoolAdmittedMin = Float.parseFloat(testSchool.getPercentEnrolled());
	// }
	// if(Float.parseFloat(testSchool.getPercentEnrolled()) > schoolEnrolledMax)
	// {
	// schoolEnrolledMax = Float.parseFloat(testSchool.getPercentEnrolled());
	// }
	// if(Integer.parseInt(testSchool.getSocialScale()) < schoolAcademicScaleMin)
	// {
	// schoolAcademicScaleMin = Integer.parseInt(testSchool.getAcademicScale());
	// }
	// if(Integer.parseInt(testSchool.getAcademicScale()) > schoolAcademicScaleMax)
	// {
	// schoolAcademicScaleMax = Integer.parseInt(testSchool.getAcademicScale());
	// }
	// if(Integer.parseInt(testSchool.getSocialScale()) < schoolSocialScaleMin)
	// {
	// schoolSocialScaleMin = Integer.parseInt(testSchool.getSocialScale());
	// }
	// if(Integer.parseInt(testSchool.getSocialScale()) > schoolSocialScaleMax)
	// {
	// schoolSocialScaleMax = Integer.parseInt(testSchool.getSocialScale());
	// }
	// if(Integer.parseInt(testSchool.getSocialScale()) < schoolQualityofLifeMin)
	// {
	// schoolQualityofLifeMin = Integer.parseInt(testSchool.getQualityOfLife());
	// }
	// if(Integer.parseInt(testSchool.getSocialScale()) > schoolQualityofLifeMax)
	// {
	// schoolQualityofLifeMax = Integer.parseInt(testSchool.getQualityOfLife());
	// }
	// }
	//
	//
	// for(int i = 0; i < this.universityList.length; i++)
	// {
	// double score = 0.0;
	// //testing distance based on enrollment
	// if(numStudentsMin != -1 && numStudentsMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) -
	// numStudentsMin)) / (schoolNumStudentMax-schoolNumStudentMin)) + (
	// Math.abs((numStudentsMax -
	// (Double.parseDouble(universityList[i].getEnrollment())))) /
	// (schoolNumStudentMax-schoolNumStudentMin));
	// }
	// else if(numStudentsMin == -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) -
	// numStudentsMax)) / (schoolNumStudentMax-schoolNumStudentMin));// + (
	// Math.abs((numStudentsMax -
	// (Double.parseDouble(universityList[i].getEnrollment())))) /
	// (schoolNumStudentMax-schoolNumStudentMin));
	// }
	// else if(numStudentsMax == -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) -
	// numStudentsMin)) / (schoolNumStudentMax-schoolNumStudentMin));// + (
	// Math.abs((numStudentsMin -
	// (Double.parseDouble(universityList[i].getEnrollment())))) /
	// (schoolNumStudentMax-schoolNumStudentMin));
	// }
	//
	// //testing distance based on percent female
	// if(percentFemaleMin != -1 && percentFemaleMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) -
	// percentFemaleMin)) / (schoolPerFemaleMax-schoolPerFemaleMin)) + (
	// Math.abs((percentFemaleMax -
	// (Double.parseDouble(universityList[i].getPercentFemale())))) /
	// (schoolPerFemaleMax-schoolPerFemaleMin));
	// }
	// else if(percentFemaleMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) -
	// percentFemaleMax)) / (schoolPerFemaleMax-schoolPerFemaleMin));// + (
	// Math.abs((percentFemaleMax -
	// (Double.parseDouble(universityList[i].getPercentFemale())))) /
	// (schoolPerFemaleMax-schoolPerFemaleMin));
	// }
	// else if(percentFemaleMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) -
	// percentFemaleMin)) / (schoolPerFemaleMax-schoolPerFemaleMin));// + (
	// Math.abs((percentFemaleMin -
	// (Double.parseDouble(universityList[i].getPercentFemale())))) /
	// (schoolPerFemaleMax-schoolPerFemaleMin));
	// }
	//
	// // //testing distance based on SATVerbal
	// if(SATVerbalMin != -1 && SATVerbalMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) -
	// SATVerbalMin)) / (schoolSATVMax-schoolSATVMin)) + ( Math.abs((numStudentsMax
	// - (Double.parseDouble(universityList[i].getSatVerbal())))) /
	// (schoolSATVMax-schoolSATVMin));
	// }
	// else if(SATVerbalMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) -
	// SATVerbalMax)) / (schoolSATVMax-schoolSATVMin));// + ( Math.abs((SATVerbalMax
	// - (Double.parseDouble(universityList[i].getSatVerbal())))) /
	// (schoolSATVMax-schoolSATVMin));
	// }
	// else if(SATVerbalMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) -
	// SATVerbalMin)) / (schoolSATVMax-schoolSATVMin));// + ( Math.abs((SATVerbalMin
	// - (Double.parseDouble(universityList[i].getSatVerbal())))) /
	// (schoolSATVMax-schoolSATVMin));/
	// }
	//
	// // //testing distance based on SATMath
	// if(SATMathMin != -1 && SATMathMax != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath())
	// - SATMathMin)) / (schoolSATMMax-schoolSATMMin)) + ( Math.abs((SATMathMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) /
	// (schoolSATMMax-schoolSATMMin));
	// }
	// else if(SATVerbalMin != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath())
	// - SATMathMax)) / (schoolSATMMax-schoolSATMMin));// + ( Math.abs((SATMathMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) /
	// (schoolSATMMax-schoolSATMMin));
	// }
	// else if(SATVerbalMax != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath())
	// - SATMathMin)) / (schoolSATMMax-schoolSATMMin));// + ( Math.abs((SATMathMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) /
	// (schoolSATMMax-schoolSATMMin));
	// }
	//
	// // //testing distance based on expenses
	// if(expensesMin != -1 && expensesMax != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) -
	// expensesMin)) / (schoolExpensesMax - schoolExpensesMin)) + (
	// Math.abs((expensesMax - (Double.parseDouble(universityList[i].getCost())))) /
	// (schoolExpensesMax - schoolExpensesMin));
	// }
	// else if(expensesMin != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) -
	// expensesMax)) / (schoolExpensesMax - schoolExpensesMin));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(expensesMax != -1)
	// {
	// score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) -
	// expensesMin)) / (schoolExpensesMax - schoolExpensesMin));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on FinancialAid
	// if(PercentFinancialAidMin != -1 && percenetFinancialAidMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) -
	// PercentFinancialAidMin)) / (schoolFinAidMax - schoolFinAidMin)) + (
	// Math.abs((percenetFinancialAidMax -
	// (Double.parseDouble(universityList[i].getPercentFinAid())))) /
	// (schoolFinAidMax - schoolFinAidMin));
	// }
	// else if(PercentFinancialAidMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) -
	// percenetFinancialAidMax)) / (schoolFinAidMax - schoolFinAidMin));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(percenetFinancialAidMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) -
	// PercentFinancialAidMin)) / (schoolFinAidMax - schoolFinAidMin));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on numberApplicants
	// if(numberApplicantsMin != -1 && numberApplicatnsMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getApplicants()) -
	// numberApplicantsMin)) / (schoolApplicantsMin - schoolApplicantsMax)) + (
	// Math.abs((numberApplicatnsMax -
	// (Double.parseDouble(universityList[i].getApplicants())))) /
	// (schoolApplicantsMin - schoolApplicantsMax));
	// }
	// else if(numberApplicantsMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getApplicants()) -
	// numberApplicatnsMax)) / (schoolApplicantsMin - schoolApplicantsMax));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(numberApplicatnsMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getApplicants()) -
	// numberApplicantsMin)) / (schoolApplicantsMin - schoolApplicantsMax));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on percentAdmitted
	// if(percentAddmittedMin != -1 && percentAdmittedMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) -
	// percentAddmittedMin)) / (schoolAdmittedMax - schoolAdmittedMin)) + (
	// Math.abs((percentAdmittedMax -
	// (Double.parseDouble(universityList[i].getPercentAdmitted())))) /
	// (schoolApplicantsMin - schoolApplicantsMax));
	// }
	// else if(numberApplicantsMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) -
	// percentAdmittedMax)) / (schoolAdmittedMax - schoolAdmittedMin));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(numberApplicatnsMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) -
	// percentAddmittedMin)) / (schoolAdmittedMax - schoolAdmittedMin));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on percentEnrolled
	// if(percentEnrolledMin != -1 && percentEnrolledMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) -
	// percentEnrolledMin)) / (schoolEnrolledMin - schoolEnrolledMax)) + (
	// Math.abs((percentEnrolledMax -
	// (Double.parseDouble(universityList[i].getPercentEnrolled())))) /
	// (schoolEnrolledMin - schoolEnrolledMax));
	// }
	// else if(percentEnrolledMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) -
	// percentEnrolledMax)) / (schoolEnrolledMin - schoolEnrolledMax));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(percentEnrolledMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) -
	// percentAddmittedMin)) / (schoolEnrolledMin - schoolEnrolledMax));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on academicSclae
	// if(academicScaleMin != -1 && academicScaleMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) -
	// academicScaleMin)) / (schoolAcademicScaleMax - schoolAcademicScaleMin)) + (
	// Math.abs((academicScaleMax -
	// (Double.parseDouble(universityList[i].getAcademicScale())))) /
	// (schoolAcademicScaleMax - schoolAcademicScaleMin));
	// }
	// else if(percentEnrolledMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) -
	// academicScaleMax)) / (schoolAcademicScaleMax - schoolAcademicScaleMin));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(percentEnrolledMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) -
	// academicScaleMin)) / (schoolAcademicScaleMax - schoolAcademicScaleMin));// +
	// ( Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on socialScale
	// if(socialScalemin != -1 && socialScaleMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) -
	// socialScalemin)) / (schoolSocialScaleMax - schoolSocialScaleMin)) + (
	// Math.abs((socialScaleMax -
	// (Double.parseDouble(universityList[i].getSocialScale())))) /
	// (schoolSocialScaleMax - schoolSocialScaleMin));
	// }
	// else if(socialScalemin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) -
	// socialScaleMax)) / (schoolSocialScaleMax - schoolSocialScaleMin));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(socialScaleMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) -
	// socialScalemin)) / (schoolSocialScaleMax - schoolSocialScaleMin));// + (
	// Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// // //testing distance based on qualityOfLife
	// if(qualityOfLifeMin != -1 && qualityOfLifeMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) -
	// qualityOfLifeMin)) / (schoolQualityofLifeMax - schoolQualityofLifeMax)) + (
	// Math.abs((qualityOfLifeMax -
	// (Double.parseDouble(universityList[i].getQualityOfLife())))) /
	// (schoolQualityofLifeMax - schoolQualityofLifeMax));
	// }
	// else if(qualityOfLifeMin != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) -
	// qualityOfLifeMax)) / (schoolQualityofLifeMax - schoolQualityofLifeMax));//+ (
	// Math.abs((expensesMax -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	// else if(qualityOfLifeMax != -1)
	// {
	// score = score +
	// (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) -
	// qualityOfLifeMin)) / (schoolQualityofLifeMax - schoolQualityofLifeMax));// +
	// ( Math.abs((expensesMin -
	// (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax -
	// schoolExpensesMin));
	// }
	//
	// //testing distance based on schoolName
	// if(!universityList[i].getName().toLowerCase().trim().contains(schoolName.toLowerCase().trim())
	// && !schoolName.equals(""))
	// {
	// score = score + 1;
	// }
	//
	// //testing distance based on location
	// if(!universityList[i].getLocation().toLowerCase().trim().equals(location.toLowerCase().trim())
	// && !location.equals(""))
	// {
	// score = score + 1;
	// }
	//
	// //testing distance based on state
	// if(!universityList[i].getState().toLowerCase().trim().equals(state.toLowerCase().trim())
	// && !state.equals(""))
	// {
	// score = score + 1;
	// }
	//
	// //testing distance based on control
	// if(!universityList[i].getControl().toLowerCase().trim().equals(control.toLowerCase().trim())
	// && !control.equals(""))
	// {
	// score = score + 1;
	// }
	//
	// //setting final score of university
	// schoolMatches[i][0] = score;//i};
	// schoolMatches[i][1] = Double.parseDouble(""+i);
	// }
	//
	// //Arrays.sort(schoolMatches);
	//
	// java.util.Arrays.sort(schoolMatches, new java.util.Comparator<double[]>() {
	// public int compare(double[] a, double[] b) {
	// return Double.compare(a[0], b[0]);
	// }
	// });
	//
	//
	// ArrayList<University> returnUniversity = new ArrayList<University>();
	// for (int i =0; i<universityList.length; i++)
	// {
	// int position = (int)schoolMatches[i][1];
	// returnUniversity.add(universityList[position]);
	// }
	// return returnUniversity;
	// }
}

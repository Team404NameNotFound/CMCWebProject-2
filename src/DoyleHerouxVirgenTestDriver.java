
import cmc.*;
import cmc.entity.*;
import cmc.functionality.DBController;
import cmc.interaction.*;
import java.util.ArrayList;

public class DoyleHerouxVirgenTestDriver {

	/**
	 * @author kmendel001
	 *
	 */
	static AccountInteraction user = new AccountInteraction();
	static StudentInteraction student = new StudentInteraction();
	static AdminInteraction admin = new AdminInteraction();
	static AdminInteraction adInt = new AdminInteraction();

	public static void main(String[] args) {

		// successful login (user)
		System.out.println("Successful login (user):");
		System.out.println("-------------------------");
		String userUsername = "juser";
		String userPassword = "user";
		user.login(userUsername, userPassword);

		System.out.println("\nSearching and Matching on Fields:");
		System.out.println("-------------------------");
		String state = "Minnesota";
		int numStudentsLower = 2000;
		int numStudentsUpper = 30000;
		String[] emphases = {};
		student.fieldSearch("", state, "", numStudentsLower, numStudentsUpper, (float) -1.0, (float) -1.0, -1, -1, -1,
				-1, -1, -1, (float) -1.0, (float) -1.0, -1, -1, (float) -1.0, (float) -1.0, (float) -1.0, (float) -1.0,
				-1, -1, -1, -1, -1, -1, emphases, "");

		// printing a school's details
		System.out.println("\n Testing printing  a school's details\n");
		user.viewSchoolDetails("UNIVERSITY OF MINNESOTA");

		System.out.println("Testing Adding a university");
		admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1",
				"5", "1", "3", "4", "5", emphases);
		System.out.println("\nPrinting Dummy school added details: \n");
		user.viewSchoolDetails("Dummy");

		// editing a univeristy information
		admin.editUniversityInfo("Dummy", "State2", "location2", "-1", "-1", "-1", "-1", "-1", "10000000", "-1", "-1",
				"-1", "-1", "-1", "-1", "-1", emphases);
		System.out.println("\n");
		// printing new university details
		user.viewSchoolDetails("Dummy");
		System.out.println("\n");
		System.out.println("\n Testing removing a school");
		admin.removeUniversity("Dummy");

		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.toggleActivationStatus("Zhang");

		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.addUser("Carrie", "Zhang", "cz001", "", "u");
	}
}

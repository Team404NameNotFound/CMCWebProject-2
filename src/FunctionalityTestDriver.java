
/**
 * 
 */
import java.util.ArrayList;

import cmc.*;
import cmc.entity.*;
import cmc.functionality.DBController;
import cmc.interaction.*;

/**
 * @author kmendel001
 *
 */
public class FunctionalityTestDriver {

	static AccountInteraction user = new AccountInteraction();
	static StudentInteraction student = new StudentInteraction();
	static AdminInteraction admin = new AdminInteraction();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// successful login (user)
		System.out.println("Successful login (user):");
		System.out.println("-------------------------");
		String userUsername = "juser";
		String userPassword = "user";
		user.login(userUsername, userPassword);
		user.logout();
		System.out.println("-------------------------");
		System.out.println();

		// successful login (admin)
		System.out.println("Successful login (admin):");
		System.out.println("-------------------------");
		String adminUsername = "nadmin";
		String adminPassword = "a";
		user.login(adminUsername, adminPassword);
		user.logout();
		System.out.println("-------------------------");
		System.out.println();

		// failed login - invalid credentials (admin and user)
		System.out.println("Failed login (invalid credentials):");
		System.out.println("-------------------------");
		String username1 = "Team";
		String password1 = "404";
		user.login(username1, password1);
		user.logout();
		System.out.println("-------------------------");
		System.out.println();

		// failed login - inactive status (admin and user)
		System.out.println("Failed login (inactive credentials):");
		System.out.println("-------------------------");
		String username2 = "luser";
		String password2 = "user";
		user.login(username2, password2);
		user.logout();
		System.out.println("-------------------------");
		System.out.println();

		// view profile (user)
		System.out.println("View profile:");
		System.out.println("-------------------------");
		String username3 = "cuser";
		String password3 = "user";
		user.login(username3, password3);

		user.viewProfile(username3);
		System.out.println("-------------------------");
		System.out.println();

		// edit profile (user)
		System.out.println("Edit profile:");
		System.out.println("-------------------------");
		// user.editProfile("cuser", "Tired", "Person", "sleep");

		user.viewProfile(username3);

		// user.editProfile("cuser", "Cool", "User", "user");

		user.logout();
		System.out.println();
		user.viewSchoolList();
		System.out.println("-------------------------");
		System.out.println();
		//
		// //view profile (admin)
		// user.login(adminUsername, adminPassword);
		//
		// user.viewProfile();
		//
		// //edit profile (admin)
		// user.editProfile("","","","", "", "");
		// user.viewProfile();
		//
		// user.logout();
		//
		// Search for schools - state, # of students (user)
		student.login(userUsername, userPassword);

		// print(results);

		// find top 5 recommended schools (user)
		System.out.println("\n5 Closest Matches From Selected University:");
		System.out.println("-------------------------");
		DBController db = new DBController();
		ArrayList<University> uniSchools = db.getUniversityList();
		University university = uniSchools.get(9);
		student.findRecommended(university.getName());
		// print(recommended);
		//
		// user.logout();
		//
		// //view list of universities (admin)
		// user.login(adminUsername, adminPassword);
		// viewUniversityList(/*parameters*/);
		//
		// user.logout();

	}

}

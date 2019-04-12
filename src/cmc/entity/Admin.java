/**
 * This class allows for the creation of Admin objects
 */
package cmc.entity;

/**
 * @author kmendel001
 *
 */
public class Admin extends Account {

	/**
	 * This constructor creates Admin objects
	 * 
	 * @param firstName
	 *            first name of the Admin
	 * @param lasName
	 *            last name of the Admin
	 * @param username
	 *            username of the Admin
	 * @param password
	 *            password of the Admin
	 * @param userType
	 *            type of account ('a')
	 * @param userStatus
	 *            whether account is active or inactive
	 */
	public Admin(String firstName, String lastName, String username, String password, String userType,
			String userStatus) {
		super(firstName, lastName, username, password, userType, userStatus);
		// TODO Auto-generated constructor stub
	}
}

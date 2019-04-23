/**
 * This class allows for the creation of Account objects
 */
package cmc.entity;

/**
 * @author kmendel001
 *
 */
public class Account {

	/**
	 * @param firstName
	 *            first name of the Account
	 * @param lasName
	 *            last name of the Account
	 * @param username
	 *            username of the Account
	 * @param password
	 *            password of the Account
	 * @param userType
	 *            type of account admin or student
	 * @param userStatus
	 *            whether account is active or inactive
	 */
	private String firstName = "";
	private String lastName = "";
	private String username = "";
	private String password = "";
	private String userType = "";
	private String userStatus = "";

	/**
	 * Creates a new Account object with the following attributes
	 * 
	 * @param firstName
	 *            first name of the Account
	 * @param lasName
	 *            last name of the Account
	 * @param username
	 *            username of the Account
	 * @param password
	 *            password of the Account
	 * @param userType
	 *            type of account admin or student
	 * @param userStatus
	 *            whether account is active or inactive
	 */
	public Account(String firstName, String lastName, String username, String password, String userType,
			String userStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.userStatus = userStatus;
	}
	
	public Account() {
		
	}
	

	// /**
	// * Allows user with the correspoding username and password to access the
	// system
	// * @param firstName first name of the Account
	// * @param lasName last name of the Account
	// * @param username username of the Account
	// * @param password password of the Account
	// * @param userType type of account admin or student
	// * @param userStatus whether account is active or inactive
	// * @return Account the account object of the user who will be logged on
	// */
	// public Account logon(String firstName, String lastName, String username,
	// String password, String userType,
	// String userStatus) {
	// Account user = new Account(firstName, lastName, username, password, userType,
	// userStatus);
	// return user;
	// }

	/**
	 * @return first name of the Account
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            first name of the Account
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return last name of the Account
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastNamelast
	 *            name of the Account
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return lastNamelast name of the Account
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            username of the Account
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return username of the Account
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            password of the Account
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return type of account admin or student
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            type of account admin or student
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return whether account is active or inactive
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            whether account is active or inactive
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String toString() {
		return username + " " + firstName + " " + lastName + " " + password + " " + userType + " " + userStatus;
	}

}

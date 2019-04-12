package cmc.interaction;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AccountInteractionTest {
	AccountInteraction ac;
	@Before
	public void setUp() throws Exception {
		ac = new AccountInteraction();
	}


	@Test
	public void testAccountInteractionUserFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		assertTrue(ac.login("cz001", "password"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginFailsUserDNE()
	{
		ac.login("DNE", "afsd");
	}

	@Test(expected = NullPointerException.class)
	public void testLoginFailsUserInactive()
	{
		ac.login("luser", "user");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginFailsInvalidPassword()
	{
		ac.login("cz001", "asdf");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testViewSchoolDetailsFailsSchoolDNE()
	{
		ac.viewSchoolDetails("DNE");
	}
	
	@Test
	public void testViewSchoolDetails() {
		//BARUCH 	NEW YORK 	URBAN 	STATE 	25000 	50 	450 	400 	11833 	80 	5500 	60 	50 	3 	2 	3
		ArrayList<String> info = ac.viewSchoolDetails("BARUCH");
		assertTrue(info.get(0).equals("BARUCH"));
		assertTrue(info.get(1).equals("NEW YORK"));
		assertTrue(info.get(2).equals("URBAN"));
		assertTrue(info.get(3).equals("STATE"));
		assertTrue(info.get(4).equals("25000"));
		assertTrue(info.get(5).equals("50"));
		assertTrue(info.get(6).equals("450"));
		assertTrue(info.get(7).equals("400"));
		assertTrue(info.get(8).equals("11833"));
		assertTrue(info.get(9).equals("80"));
		assertTrue(info.get(10).equals("5500"));
		assertTrue(info.get(11).equals("60"));
		assertTrue(info.get(12).equals("50"));
		assertTrue(info.get(13).equals("3"));
		assertTrue(info.get(14).equals("2"));
		assertTrue(info.get(15).equals("3"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testViewProfileFailsUserDNE()
	{
		ac.viewProfile("Dne");
	}

	@Test
	public void testViewProfile() {
		ArrayList<String> userInfo = ac.viewProfile("cz001");
		assertTrue(userInfo.get(0).equals("Carrie"));
		assertTrue(userInfo.get(1).equals("Zhang"));
		assertTrue(userInfo.get(2).equals("cz001"));
		assertTrue(userInfo.get(3).equals("password"));
		assertTrue(userInfo.get(0).equals("u"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditProfileFailsMissingName() {
		ac.editProfile("cz001", "", "las", "pass", "u");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditProfileFailsMissingLastName() {
		ac.editProfile("cz001", "fisrt", "", "pass", "u");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditProfileFailsMissingPass() {
		ac.editProfile("cz001", "fisrt", "las", "", "u");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditProfileFailsMissingType() {
		ac.editProfile("cz001", "", "las", "pass", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditProfileFailsWrongType() {
		ac.editProfile("cz001", "", "las", "pass", "a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditProfile()
	{
		ArrayList<String> userInfo = ac.viewProfile("cz001");
		ac.editProfile("cz001", "cart", "last", "no", "a");
		assertTrue(userInfo.get(0).equals("cz001"));
//		ArrayList<String> userInfo1 = ac.viewProfile("cz001");
		assertTrue(userInfo.get(1).equals("cart"));
		assertTrue(userInfo.get(2).equals("last"));
		assertTrue(userInfo.get(3).equals("no"));
		assertTrue(userInfo.get(4).equals("a"));
		
		ac.editProfile("cz001", "Carrie", "Zhang", "password", "u");
	}
	@Test
	public void testLogout() {
		ac.login("cz001", "password");
		assertTrue(ac.logout());
	}

	@Test
	public void testForgotPsw() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolList() {
		fail("Not yet implemented");
	}

}

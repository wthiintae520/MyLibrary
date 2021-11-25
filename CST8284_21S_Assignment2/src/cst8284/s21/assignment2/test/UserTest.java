package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cst8284.s21.assignment2.User;

public class UserTest {
	private int default_id = 1000;
	private String default_firstName = "Willy";
	private String default_lastName = "Trump";
	private String default_address = "30 Jamie Avenue, Ottawa";
	private int default_age = 31;
	private String default_toString = "************ User id: " + default_id + "\n" +
									  "************ User name: " + default_lastName + " " + default_firstName + "\n" +
									  "************ Age: " + default_age + "\n" +
									  "************ Address: " + default_address + "\n";
	private int second_id = 1001;
	private String second_firstName = "Abby";
	private String second_lastName = "Hill";
	private String second_address = "1490 Bankfield Road, Ottawa";
	private int second_age = 32;
	private String second_toString = "************ User id: " + second_id + "\n" +
									 "************ User name: " + second_lastName + " " + second_firstName + "\n" +
									 "************ Age: " + second_age + "\n" +
									 "************ Address: " + second_address + "\n";
	User defaultUser;
	
	@Before
	public void setUp() throws Exception {
		defaultUser = new User(default_id, default_firstName, default_lastName, default_address, default_age);
	}
	
	@Test
	public void testGetId_true() {
		int result = defaultUser.getId();
		assertTrue(default_id == result);
	}
	
	@Test
	public void testGetId_false() {
		int result = defaultUser.getId();
		assertFalse(second_id == result);
	}

	@Test
	public void testGetFirstName_true() {
		String result = defaultUser.getFirstName();
		assertEquals(default_firstName, result);
	}

	@Test
	public void testGetFirstName_false() {
		String result = defaultUser.getFirstName();
		assertFalse(second_firstName.equals(result));
	}
	
	@Test
	public void testGetLastName_true() {
		String result = defaultUser.getLastName();
		assertEquals(default_lastName, result);
	}
	
	@Test
	public void testGetLastName_false() {
		String result = defaultUser.getLastName();
		assertFalse(second_lastName.equals(result));
	}

	@Test
	public void testGetAddress_true() {
		String result = defaultUser.getAddress();
		assertEquals(default_address, result);
	}
	
	@Test
	public void testGetAddress_false() {
		String result = defaultUser.getAddress();
		assertFalse(second_address.equals(result));
	}

	@Test
	public void testGetAge_true() {
		int result = defaultUser.getAge();
		assertTrue(default_age == result);
	}
	
	@Test
	public void testGetAge_false() {
		int result = defaultUser.getAge();
		assertFalse(second_age == result);
	}

	@Test
	public void testToString_true() {
		String result = defaultUser.toString();
		assertEquals(default_toString, result);
	}

	@Test
	public void testToString_false() {
		String result = defaultUser.toString();
		assertFalse(second_toString.equals(result));
	}
	
	@Test
	public void testEqualsUser_true() {
		User compareUser = new User(default_id, default_firstName, default_lastName, default_address, default_age);
		boolean result = defaultUser.equals(defaultUser, compareUser);
        assertEquals(true, result);
	}

	@Test
	public void testEqualsUser_false() {
		User compareUser = new User(second_id, second_firstName, second_lastName, second_address, second_age);
		boolean result = defaultUser.equals(defaultUser, compareUser);
        assertFalse(result);
	}
}
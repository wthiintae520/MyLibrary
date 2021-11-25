package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cst8284.s21.assignment2.Book;
import cst8284.s21.assignment2.User;
import cst8284.s21.assignment2.BookLoan;

public class BookLoanTest {
	private String default_title = "First Book";
	private String default_author = "First Authora";
	private String default_publicationDate = "1111";
	private String default_isbnNumber = "1111111111";
	private Book default_book = new Book(default_title, default_author, default_publicationDate, default_isbnNumber);
	private int default_id = 1000;
	private String default_firstName = "Willy";
	private String default_lastName = "Trump";
	private String default_address = "30 Jamie Avenue, Ottawa";
	private int default_age = 31;
	private User default_user = new User(default_id, default_firstName, default_lastName, default_address, default_age);
	private String default_dueDate = "2021-08-01";
	private String default_toString = "************ User name:" + default_lastName + " " + default_firstName + "\n" +
									  "************ Title: " + default_title + "\n" +
									  "************ Author: "  + default_author + "\n" +
									  "************ ISBN: " + default_isbnNumber + "\n" +
									  "************ Due date: " + default_dueDate;
	
	private String second_title = "Second Book";
	private String second_author = "Second Authorb";
	private String second_publicationDate = "2222";
	private String second_isbnNumber = "2222222222";
	private Book second_book = new Book(second_title, second_author, second_publicationDate, second_isbnNumber);
	private int second_id = 1001;
	private String second_firstName = "Abby";
	private String second_lastName = "Hill";
	private String second_address = "1490 Bankfield Road, Ottawa";
	private int second_age = 32;
	private User second_user = new User(second_id, second_firstName, second_lastName, second_address, second_age);
	private String second_dueDate = "2021-08-02";
	private String second_toString = "************ User name:" + second_lastName + " " + second_firstName + "\n" +
									 "************ Title: " + second_title + "\n" +
									 "************ Author: "  + second_author + "\n" +
									 "************ ISBN: " + second_isbnNumber + "\n" +
									 "************ Due date: " + second_dueDate;
	
	BookLoan defaultBookLoan;
	
	@Before
	public void setUp() throws Exception {
		defaultBookLoan = new BookLoan(default_user, default_book, default_dueDate);
	}
	
	@Test
	public void testGetBook_true() {
		Book result = defaultBookLoan.getBook();
		assertEquals(default_book, result);
	}
	
	@Test
	public void testGetBook_false() {
		Book result = defaultBookLoan.getBook();
		assertFalse(second_book.equals(result));
	}

	@Test
	public void testGetUser_true() {
		User result = defaultBookLoan.getUser();
		assertEquals(default_user, result);
	}
	
	@Test
	public void testGetUser_false() {
		User result = defaultBookLoan.getUser();
		assertFalse(second_user.equals(result));
	}

	@Test
	public void testGetDueDate_true() {
		String result = defaultBookLoan.getDueDate();
		assertEquals(default_dueDate, result);
	}
	
	@Test
	public void testGetDueDate_false() {
		String result = defaultBookLoan.getDueDate();
		assertFalse(second_dueDate.equals(result));
	}

	@Test
	public void testToString_true() {
		String result = defaultBookLoan.toString();
		assertEquals(default_toString, result);
	}
	
	@Test
	public void testToString_false() {
		String result = defaultBookLoan.toString();
		assertFalse(second_toString.equals(result));
	}

	@Test
	public void testEqualsBookLoan_true() {
		BookLoan compareBookLoan = new BookLoan(default_user, default_book, default_dueDate);
		boolean result = defaultBookLoan.equals(defaultBookLoan, compareBookLoan);
        assertEquals(true, result);
	}

	@Test
	public void testEqualsBookLoan_false() {
		BookLoan compareBookLoan = new BookLoan(second_user, second_book, second_dueDate);
		boolean result = defaultBookLoan.equals(defaultBookLoan, compareBookLoan);
		assertFalse(result);
	}
}

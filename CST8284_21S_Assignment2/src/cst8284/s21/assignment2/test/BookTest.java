package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cst8284.s21.assignment2.Book;

public class BookTest {
	private String default_title = "First Book";
	private String default_author = "First Authora";
	private String default_publicationDate = "1111";
	private String default_isbnNumber = "1111111111";
	private String default_toString = "************ Title: " + default_title + "\n" +
									  "************ Author: "  + default_author + "\n" +
									  "************ Publication Year: " + default_publicationDate +"\n" +
									  "************ ISBN: " + default_isbnNumber;
	private String second_title = "Second Book";
	private String second_author = "Second Authorb";
	private String second_publicationDate = "2222";
	private String second_isbnNumber = "2222222222";
	private String second_toString = "************ Title: " + second_title + "\n" +
									 "************ Author: "  + second_author + "\n" +
									 "************ Publication Year: " + second_isbnNumber +"\n" +
									 "************ ISBN: " + second_isbnNumber;
	Book defaultBook;
	
	@Before
	public void setUp() throws Exception {
		defaultBook = new Book(default_title, default_author, default_publicationDate, default_isbnNumber);
	}

	@Test
	public void testBook_true() {
		String result = defaultBook.getTitle();
		assertEquals(default_title, result);
	}
	
	@Test
	public void testBook_false() {
		String result = defaultBook.getTitle();
		assertFalse(second_title.equals(result));
	}

	@Test
	public void testGetTitle_true() {
		String result = defaultBook.getTitle();
		assertEquals(default_title, result);
	}
	
	@Test
	public void testGetTitle_false() {
		String result = defaultBook.getTitle();
		assertFalse(second_title.equals(result));
	}

	@Test
	public void testGetAuthor_true() {
		String result = defaultBook.getAuthor();
		assertEquals(default_author, result);
	}
	
	@Test
	public void testGetAuthor_false() {
		String result = defaultBook.getAuthor();
		assertFalse(second_author.equals(result));
	}

	@Test
	public void testGetPublicationDate_true() {
		String result = defaultBook.getPublicationDate();
		assertEquals(default_publicationDate, result);
	}
	
	@Test
	public void testGetPublicationDate_false() {
		String result = defaultBook.getPublicationDate();
		assertFalse(second_publicationDate.equals(result));
	}

	@Test
	public void testGetIsbnNumber_true() {
		String result = defaultBook.getIsbnNumber();
		assertEquals(default_isbnNumber, result);
	}
	
	@Test
	public void testGetIsbnNumber_false() {
		String result = defaultBook.getIsbnNumber();
		assertFalse(second_isbnNumber.equals(result));
	}

	@Test
	public void testToString_true() {
		String result = defaultBook.toString();
		assertEquals(default_toString, result);
	}
	
	@Test
	public void testToString_false() {
		String result = defaultBook.toString();
		assertFalse(second_toString.equals(result));
	}

	@Test
	public void testEqualsBook_true() {
		Book compareBook = new Book(default_title, default_author, default_publicationDate, default_isbnNumber);
		boolean result = defaultBook.equals(defaultBook, compareBook);
        assertEquals(true, result);
	}

	@Test
	public void testEqualsBook_false() {
		Book compareBook = new Book(second_title, second_author, second_publicationDate, second_isbnNumber);
		boolean result = defaultBook.equals(defaultBook, compareBook);
		assertFalse(result);
	}
}
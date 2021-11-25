/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class LendingLibraryController {
	private static final int ISBN_LENGTH = 10;
	private LendingLibrary library;
	private static Scanner in = new Scanner(System.in);
	
	//constructor, instantiate a library
	public LendingLibraryController() {
		library = new LendingLibrary(); 
	}
	
	//ask user to input user information to add a new user into the library, only positive age allow
	public void addUser() {
		System.out.println("New User Entry");
		String lastName = getResponseTo("Last name: ");
		String firstName = getResponseTo("First name: ");
		String ageString = getResponseTo("Age: ");
		int age = -1;
		if(isValidNumber(ageString)) {
			age = Integer.parseInt(ageString);
		}
		if(age > 0) {
			String address = getResponseTo("User address: ");
			if(library.findUser(firstName, lastName) != null) {
				System.out.println("This user already exists");
			} else {
				User user1 = new User(firstName, lastName, address, age);
				if(library.addUser(user1)) {
					System.out.println("User was added");
				} else {
					System.out.println("User could not be added");
				}
			}
		} else {
			System.out.println("Invalid age value for age.");
		}
	}

	//ask user to input user's last name, first name and new address to modify that user's information
	public void changeUser() {
		System.out.println("User Modification");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");
		User user = library.findUser(firstName, lastName);
		if(user != null) {
			String address = getResponseTo("New address: ");
			user.setAddress(address);
			System.out.println("Address changed");
		} else {
			System.out.println("User doesn't exist");
		}
	}
	
	//ask user to input user's last name, first name to find that user in the library
	public void findUser() { 
		System.out.println("Find User");
		String lastName = getResponseTo("Last name: ");
		String firstName = getResponseTo("First name: ");
		User user = library.findUser(firstName, lastName);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("No user with this name!");
		}
	}
	
	//Output the user list of the library
	public void listUsers() {
		outputUserData(library.getUserReg());
	}
	
	//ask user to input book information to add a new book into the library, only correct ISBN number allow
	public void addBook() {
		System.out.println("New Book Entry");
		String title = getResponseTo("Title: ");
		String author = getResponseTo("Author: ");
		String publicationDate = getResponseTo("Publication date (year in NNNN format): ");
		String isbnNumber = getResponseTo("ISBN number (10 digits): ");
		if(verifyISBNNumber(isbnNumber)) {
			if(library.findBook(isbnNumber) != null) {
				System.out.println("This book already exists! Not added");
			} else {
				Book book1 = new Book(title, author, publicationDate, isbnNumber);
				if(!library.addBook(book1)) {
					System.out.println("Book could not be added");
				}
			}
		} else {
			System.out.println("Invalid ISBN number");
		}
	}
	
	//ask user to input book's ISBN number and new title and/or new author to modify that book's information
	public void changeBook() {
		System.out.println("Modify a Book.");
		String isbn = getResponseTo("ISBN number of the book to find: ");
		Book book = library.findBook(isbn);
		if(book == null) {
			System.out.println("Could not find a book with this isbn");
		} else {
			String title = getResponseTo("New Title (Hit Enter key for no change): ");
			if (!title.isEmpty()) {
				book.setTitle(title);
			}
			String author = getResponseTo("New Author (Hit Enter key for no change): ");
			if (!author.isEmpty()) {
				book.setAuthor(author);			
			}
		}
	}
	
	//ask user to input book's isbn to find that book in the library
	public void findBook() {
		Book book = null;
		System.out.println("Find a Book.");
		String isbn = getResponseTo("Enter the book isbn number: ");
		book = library.findBook(isbn);
		if(book != null) {
			System.out.println(book);
		} else {
			System.out.println("No book with this isbn!" );
		}
	}
	
	//Output the book list of the library
	public void listBooks() {
		outputBookData(library.getBookReg());
	}
	
	//ask user to input loan information to add a new loan into the library
	public void addBookLoan() {
		System.out.println("New Loan Entry");
		String lastName = getResponseTo("User last name: ");
		String firstName = getResponseTo("User first name: ");
		User user = null;
		Book book = null;
		user = library.findUser(firstName, lastName);
		if(user != null) {	 
			String isbn = getResponseTo("Book isbn number: ");
			book = library.findBook(isbn);
			if(book != null) {
				String date = getResponseTo("Loan date (format yyyy-mm-dd): ");
				executeBookLoan(user, book, date);
			} else {
				System.out.println("Could not find a book with this isbn!");
			}
		} else {
			System.out.println("Invalid user!");
		}
	}
	
	//ask user to input bookloan's isbn to find that bookloan in the library
	public void findBookLoan() {
		System.out.println("Find a book loan.");
		Book book = null;
		BookLoan bookLoan = null;
		String isbn = getResponseTo("Book isbn number: ");
		book = library.findBook(isbn);
		if(book != null) {
			bookLoan = library.findLoan(isbn);
			if(bookLoan != null) {
				System.out.println(bookLoan);
			} else {
				System.out.println("No book loan found.");
			}
		} else {
			System.out.println("No loan found with this isbn number!");
		}
	}
	
	//ask user to input bookloan's ISBN number and new date to modify that bookloan's information
	public void changeBookLoan() {
		System.out.println("Modify loan details.");
		String isbn = getResponseTo("ISBN number for the loan you want to modify: ");
		BookLoan bookLoan = library.findLoan(isbn);
		if(bookLoan != null) {
			String date = getResponseTo("Change due date (Hit Enter key for no change): ");
			if(date.isEmpty()) {
				System.out.println("Date not changed");
			} else {
				bookLoan.setDueDate(date);
			}
		} else {
			System.out.println("No loan found with this isbn number!");
		}
	}

	//Output the book loan list of the library
	public void listBookLoans() {
		outputLoanData(library.getLoanReg());
	}

	//ask user to input user's last name and first name to delete that user from the library, only user without a loan allow
	public void deleteUser() {
		System.out.println("Enter the user name should be deleted.");
		String lastName = getResponseTo("Last name: ");
		String firstName = getResponseTo("First name: ");
		if(library.findUser(firstName, lastName) != null) {
			if(library.findLoanByName(firstName, lastName) == null) {
				library.deleteUser(firstName, lastName);
				System.out.println("This user has been deleted.");
			} else {
				System.out.println("This user has book loan, cannot be deleted.");
			}
		} else {
			System.out.println("This user does not exist.");
		}
	}
	
	//ask user to input book's ISBN number to delete that book from the library, only book without a loan allow
	public void deleteBook() {
		System.out.println("Enter the ISBN number of book should be deleted.");
		String isbn = getResponseTo("ISBN number (10 digits): ");
		if(library.findBook(isbn) != null) {
			if(library.findLoan(isbn) == null) {
				library.deleteBook(isbn);
				System.out.println("This book has been deleted.");
			} else {
				System.out.println("This book has book loan, cannot be deleted.");
			}
		} else {
			System.out.println("This book does not exist.");
		}
	}

	//ask user to input book loan's ISBN number to delete that book loan from the library
	public void deleteBookLoan() {
		System.out.println("Enter the ISBN number of book loan should be deleted.");
		String isbn = getResponseTo("ISBN number (10 digits): ");
		if(library.findLoan(isbn) != null) {
			library.deleteLoan(isbn);
			System.out.println("This book loan has been deleted.");
		} else {
			System.out.println("This book loan does not exist.");
		}
	}
	
	//input loan information to create a loan, only user has no loan or has one loan allow
	private void executeBookLoan(User user, Book book, String date) {
		for(BookLoan bookloan: library.getLoanReg()) {
			if(bookloan != null && bookloan.getBook().getIsbnNumber().equals(book.getIsbnNumber())) {
				System.out.println("Book is already loaned.");
				return;
			}
		}
		if(library.userCanBorrow(user)) {
			BookLoan bookloan1 = new BookLoan(user, book, date);
			if(library.addBookLoan(bookloan1)) {
				System.out.println("Loan added.");
				System.out.println(bookloan1);
			} else {
				System.out.println("Could not add this loan.");
			}
		} else {
			System.out.println("User is not allowed to borrow more books.");
		}	
	}
	
	//display book list
	private void outputBookData(ArrayList<Book> bookList) {
		int i = 1;
		for(Book element : bookList) {
			if(element != null) {
				System.out.println("Book #" + i++);
				System.out.println(element);
			}
		}
	}
	
	//display user list
	private void outputUserData(ArrayList<User> userList) {
		int i = 1;
		for(User element: userList) {
			if(element != null) {
				System.out.println("User #" + i++);
				System.out.println(element);
			}
		}
	}
	
	//display loan list
	private void outputLoanData(ArrayList<BookLoan> loanList) {
		int i = 1;
		for(BookLoan element: loanList) {
			if(element != null) {
				System.out.println("Loan #" + i++);
				System.out.println(element);
			}
		}
	}

	/**
	 * get user input from the given String
	 * @param: String
	 * @return: String: user input
	 */
	private static String getResponseTo(String s) {
		System.out.print(s);
		return(in.nextLine());
	}
 	
	
	/**
	 * check the given String is null or empty
	 * @param: String
	 * @return: true: the given String is null or empty
	 * @return: false: the given String is not null or empty
	 */
  	public static boolean isNullOrEmpty(String s) {
  		return s == null || s.equals("");
  	}
  	
  	/**
  	 * check the given String is number only
  	 * @param: String
  	 * @return: true: the given String is number only
  	 * @return: false: the given String is not number only
  	 */
	public static boolean isDigitsOnly(String digits) {
   		return digits.matches("^[0-9]*$");
   	}
	
	/**
	 * check the given String is valid number(not null or empty and is number only)
	 * @param: String
	 * @return: true: the given String is valid number
	 * @return: false: the given String is not valid number
	 */
	private static boolean isValidNumber(String s) {
		return (!isNullOrEmpty(s) && isDigitsOnly(s));
	}
	
	/**
	 * check the given String is isbn number(valid number and the length is 10)
	 * @param: String
	 * @return: true: the given String is isbn number
	 * @return: false: the given String is not isbn number
	 */
	private static boolean verifyISBNNumber(String s) {
		return (isValidNumber(s) && s.length() == ISBN_LENGTH);
	}
}
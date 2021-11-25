/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

import java.util.ArrayList;

public class LendingLibrary {
	private static final int MAX_LOAN_PER_USER = 2;
	private ArrayList<Book> bookReg = new ArrayList<Book>();
	private ArrayList<User> userReg = new ArrayList<User>();
	private ArrayList<BookLoan> loanReg = new ArrayList<BookLoan>();

	//constructor
	public LendingLibrary() {
	}
	
	/**
	 * Add a book to the book array list
	 * @param: Object: Book
	 * @return: true: the book can be added into the book array list
	 * @return: false: the book cannot be added into the book array list
	 */
	public boolean addBook(Book book) {
		if(bookReg.add(book)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Add a user to the user array list
	 * @param: Object: User
	 * @return: true: the user can be added into the user array list
	 * @return: false: the user cannot be added into the user array list
	 */
	public boolean addUser(User user) {
		if(userReg.add(user)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Add a book loan to the book loan array list
	 * @param: Object: BookLoan
	 * @return: true: the book loan can be added into the book loan array list
	 * @return: false: the book loan cannot be added into the book loan array list
	 */
	public boolean addBookLoan(BookLoan bookLoan) {
		if(loanReg.add(bookLoan)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Find the book with the isbn number
	 * @param: String: isbn
	 * @return: Object: Book, find out the book
	 * @return: null: does not find out the book
	 */
	public Book findBook(String isbnNumber) {
		for(Book book : bookReg) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				return book;
			}
		}
		return null;
	}

	/**
	 * Find the user with the first name and the last name
	 * @param: String: first name and last name
	 * @return: Object: User, find out the user
	 * @return: null: does not find out the user
	 */
	public User findUser(String firstName, String lastName) {
		for(User user : userReg) {
			if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				return user;
			} 
		}
		return null;
	}
	
	/**
	 * Find the user loan with the isbn
	 * @param: String: isbn
	 * @return: Object: BookLoan, find out the loan
	 * @return: null: does not find out the loan
	 */
	public BookLoan findLoan(String isbnNumber) {
		for(BookLoan bookloan : loanReg) {
			if(bookloan.getBook().getIsbnNumber().equals(isbnNumber)) {
				return bookloan;
			} 
		}	
		return null;
	}
	
	/**
	 * Find the user loan with the user first name and the last name
	 * @param: String: first name and last name
	 * @return: Object: BookLoan, find out the loan
	 * @return: null: does not find out the loan
	 */
	public BookLoan findLoanByName(String firstName, String lastName) {
		for(BookLoan bookloan : loanReg) {
			if(bookloan.getUser().getFirstName().equals(firstName) && bookloan.getUser().getLastName().equals(lastName)) {
				return bookloan;
			} 
		}	
		return null;
	}
	
	/**
	 * delete a book from the book array list
	 * @param: String: isbn
	 * @return: true: the book can be deleted from the book array list
	 * @return: false: the book cannot be deleted from the book array list
	 */
	public boolean deleteBook(String isbnNumber) {
		Book bookShouldBeDeleted = findBook(isbnNumber);
		bookReg.remove(bookShouldBeDeleted);
		return true;
	}
	
	/**
	 * delete a user from the user array list
	 * @param: String: first name and the last name
	 * @return: true: the user can be deleted from the user array list
	 * @return: false: the user cannot be deleted from the user array list
	 */
	public boolean deleteUser(String firstName, String lastName) {
		User userShouldBeDeleted = findUser(firstName, lastName);
		userReg.remove(userShouldBeDeleted);
		return true;
	}
	
	/**
	 * delete a loan from the loan array list
	 * @param: String: isbn
	 * @return: true: the loan can be deleted from the loan array list
	 * @return: false: the loan cannot be deleted from the loan array list
	 */
	public boolean deleteLoan(String isbnNumber) {
		BookLoan bookLoanShouldBeDeleted = findLoan(isbnNumber);
		loanReg.remove(bookLoanShouldBeDeleted);
		return true;
	}
	
	/**
	 * check a book has been loaned or not
	 * @param: Object: Book
	 * @return: true:  the book has been loaned
	 * @return: false: the book has not been loaned
	 */
	public boolean isBookLoaned(Book b) {
		for(BookLoan bookloan : getLoanReg()) {
			if(bookloan != null && bookloan.getBook().equals(b)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * check a user can borrow more book or not
	 * @param: Object: User
	 * @return: true: the user can borrow more book
	 * @return: false: the user cannot borrow more book
	 */
	public boolean userCanBorrow(User u) {
		int numBook = 0;		
		for(BookLoan bookloan: getLoanReg()) {
			if(bookloan != null && u.equals(bookloan.getUser())) {
				numBook++;	
			}
		}
		return (numBook < MAX_LOAN_PER_USER);
	}
	
	//getter of ArrayList<Book>
	public ArrayList<Book> getBookReg() {
		return bookReg;
	}
	
	//getter of ArrayList<User>
	public ArrayList<User> getUserReg() {
		return userReg;
	}
	
	//getter of ArrayList<BookLoan>
	public ArrayList<BookLoan> getLoanReg() {
		return loanReg;
	}
	
	//setter of ArrayList<Book>
	public void setBookReg(ArrayList<Book> bookReg) {
		this.bookReg = bookReg;
	}
	
	//setter of ArrayList<User>
	public void setUserReg(ArrayList<User> userReg) {
		this.userReg = userReg;
	}
	
	//setter of ArrayList<BookLoan>
	public void setLoanReg(ArrayList<BookLoan> loanReg) {
		this.loanReg = loanReg;
	}
}
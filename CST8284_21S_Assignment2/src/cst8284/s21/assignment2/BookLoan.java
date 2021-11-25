/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

public class BookLoan {
	private Book book;
	private User user;
	private String dueDate;
	
	//constructor
	public BookLoan(User User, Book book,  String dueDate) {
		setBook(book);
		setUser(User);
		setDueDate(dueDate);
	}
	
	//getter of book
	public Book getBook() {
		return book;
	}
	
	//getter of user
	public User getUser() {
		return user;
	}
	
	//getter of dueDate
	public String getDueDate() {
		return dueDate;
	}
	
	//setter of book
	public void setBook(Book book) {
		this.book = book;
	}

	//setter of user
	public void setUser(User user) {
		this.user = user;
	}

	//setter of dueDate
	public void setDueDate(String dueDate)  {
		this.dueDate = dueDate;
	}
	
	//print the loan information in a specific format
	@Override
	public String toString() {
		return "************ User name:" + getUser().getLastName() + " " + getUser().getFirstName() + "\n" +
			   "************ Title: " + getBook().getTitle() + "\n" +
			   "************ Author: "  + getBook().getAuthor() + "\n" +
			   "************ ISBN: " + getBook().getIsbnNumber() + "\n" +
			   "************ Due date: " + getDueDate();
	}
	
	/**
	 * check the two given loans are totally as same as each other
	 * @param: Object: BookLoan
	 * @return: true: the two given loans are totally as same as each other
	 * @return: false: the two given loans are not totally as same as each other
	 */
	public boolean equals(BookLoan bookLoan1, BookLoan bookLoan2) {
		return (bookLoan1.getBook().equals(bookLoan2.getBook()) &&
				bookLoan1.getUser().equals(bookLoan2.getUser()) &&
				bookLoan1.getDueDate().equals(bookLoan2.getDueDate()));
	}
}
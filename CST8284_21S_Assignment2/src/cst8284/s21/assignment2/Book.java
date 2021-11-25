/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

public class Book{
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;
	
	//constructor
	public Book(String title, String author, String publicationDate, String isbnNumber) {
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setIsbnNumber(isbnNumber);
	}
	
	//getter of title
	public String getTitle() {
		return title;
	}
	
	//getter of author
	public String getAuthor() {
		return author;
	}
	
	//getter of publicationDate
	public String getPublicationDate() {
		return publicationDate;
	}
	
	//getter of isbnNumber
	public String getIsbnNumber() {
		return isbnNumber;
	}
	
	//setter of title
	public void setTitle(String title) {
		this.title = title;
	}
	
	//setter of author
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//setter of publicationDate
	public void setPublicationDate(String publicationDate)  {
		this.publicationDate = publicationDate;
	}
	
	//setter of isbnNumber
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	//print the book information in a specific format
	@Override
	public String toString() {
		return "************ Title: " + getTitle() + "\n" +
			   "************ Author: "  + getAuthor() + "\n" +
			   "************ Publication Year: " + getPublicationDate() +"\n" +
			   "************ ISBN: " + getIsbnNumber();
	}
	
	/**
	 * check the two given books are totally as same as each other
	 * @param: Object: Book
	 * @return: true: the two given books are totally as same as each other
	 * @return: false: the two given books are not totally as same as each other
	 */
	public boolean equals(Book book1, Book book2) {
		return (book1.getTitle().equals(book2.getTitle()) &&
				book1.getAuthor().equals(book2.getAuthor()) &&
				book1.getPublicationDate().equals(book2.getPublicationDate()) &&
				book1.getIsbnNumber().equals(book2.getIsbnNumber()));
	}
}
/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

import java.util.Scanner;

public class AppDriver {
	private static final int APP_EXIT = 0;
	private static final int APP_ADD_BOOK = 1;
	private static final int APP_MOD_BOOK = 2;
	private static final int APP_FIND_BOOK = 3;
	private static final int APP_LIST_BOOKS = 4;
	private static final int APP_ADD_USER = 5;
	private static final int APP_MOD_USER = 6;
	private static final int APP_FIND_USER = 7;
	private static final int APP_LIST_USERS = 8;
	private static final int APP_ADD_LOAN = 9;
	private static final int APP_MOD_LOAN = 10;
	private static final int APP_FIND_LOAN = 11;
	private static final int APP_LIST_LOANS = 12;
	private static final int APP_DEL_BOOK = 13;
	private static final int APP_DEL_USER = 14;
	private static final int APP_DEL_LOAN = 15;
	private static Scanner input = new Scanner(System.in);
	LendingLibraryController appControl;
	
	//constructor, instantiate a controller
	public AppDriver() {
		appControl = new LendingLibraryController();
	}
	
	//display a menu to user, then execute the choice from user until user decide to exit the application
	public void startApp() {
		int choice = -1;
		do {
			choice = displayAppMenu();
			executeMenuItem(choice);
		} while (choice != APP_EXIT);
	}
	
	//display the menu and return the result from user, any invalid choice will be ignored
	private static int displayAppMenu() {
		StringBuilder sb = new StringBuilder("Enter a selection from the following menu:\n");
		sb.append(APP_ADD_BOOK + ". Enter a new book\n" + 
				  APP_MOD_BOOK + ". Modify book details. Enter the book isbn number\n" +				
				  APP_FIND_BOOK + ". Find a book by isbn number\n" + 
				  APP_LIST_BOOKS + ". Display list of all books\n" + 
				  "\n" +
				  APP_ADD_USER + ". Add a new user\n" + 
				  APP_MOD_USER + ". Modify user details\n" + 				
				  APP_FIND_USER + ". Find a user by name\n" + 
				  APP_LIST_USERS + ". Display all users\n" + 
				  "\n" +
				  APP_ADD_LOAN + ". Add a loan. Link a user name to a book by isbn number\n" + 
				  APP_MOD_LOAN + ". Modify a loan. Loan is identified by isbn number \n" + 
				  APP_FIND_LOAN + ". Find a loan. Loan is identified by isbn number\n" + 
				  APP_LIST_LOANS + ". Display all loans\n" + 
				  "\n" +
				  APP_DEL_BOOK + ". Delete a book\n" +
				  APP_DEL_USER + ". Delete a user\n" +
				  APP_DEL_LOAN + ". Delete a loan\n" +
				  "\n" +
				  APP_EXIT + ". Exit program\n\n");
		int choiceInt = 0;
		try {
			System.out.println(sb.toString());
			String choiceString = input.nextLine();
			choiceInt = Integer.parseInt(choiceString);
		} catch(Exception ex) {
			choiceInt = -1;
		}
	 	return choiceInt;
	}
	
	//executes the action requested by user
	private void executeMenuItem(int choice) {
		switch(choice) { 
			case APP_ADD_BOOK:
				appControl.addBook();
				break;
			case APP_MOD_BOOK:
				appControl.changeBook();
				break;
			case APP_FIND_BOOK:
				appControl.findBook();
				break;
			case APP_LIST_BOOKS:
				appControl.listBooks();
				break;
			case APP_ADD_USER:;
				appControl.addUser();
				break;
			case APP_MOD_USER:
				appControl.changeUser();
				break;
			case APP_FIND_USER:
				appControl.findUser();
				break;
			case APP_LIST_USERS:
				appControl.listUsers();
				break;				
			case APP_ADD_LOAN:
				appControl.addBookLoan();
				break;
			case APP_MOD_LOAN:
				appControl.changeBookLoan();
				break;
			case APP_FIND_LOAN:
				appControl.findBookLoan();
				break;
			case APP_LIST_LOANS:
				appControl.listBookLoans();
				break;
			case APP_DEL_BOOK:
				appControl.deleteBook();
				break;
			case APP_DEL_USER:
				appControl.deleteUser();
				break;
			case APP_DEL_LOAN:
				appControl.deleteBookLoan();
				break;
			case APP_EXIT:
				System.out.println("Good Bye!");
				break;
			default:
				System.out.println("Unknown command!");
				break;
		}
		System.out.println(); 
	}
}
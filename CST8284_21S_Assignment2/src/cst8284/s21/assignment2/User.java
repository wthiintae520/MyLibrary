/**
Course Name: CST8284
Author Name: Yunting Yin
Class Name: 303
Date: July 20, 2021
*/

package cst8284.s21.assignment2;

public class User {
	private static final int DEFAULT_AGE = 18;
	private static int userNextId=1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	
	//first constructor
	public User(int id, String firstName, String lastName, String address, int age) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setAge(age);
	}
	
	//second constructor, chain to first constructor
	public User(String firstName, String lastName, String address, int age) {
		this(userNextId++, firstName, lastName, address, age);		
	}
	
	//third constructor, chain to second constructor
	public User(String firstName, String lastName, String address) {
		this(firstName, lastName, address, DEFAULT_AGE);		
	}
	
	//getter of id
	public int getId() {
		return id;
	}
	
	//getter of firstName
	public String getFirstName() {
		return firstName;
	}
	
	//getter of lastName
	public String getLastName() {
		return lastName;
	}
	
	//getter of address
	public String getAddress() {
		return address;
	}
	
	//getter of age
	public int getAge() {
		return age;
	}
	
	//setter of id
	public void setId(int id) {
		this.id = id;
	}
	
	//setter of firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//setter of lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//setter of address
	public void setAddress(String address) {
		this.address = address;
	}

	//setter of age
	public void setAge(int age) {
		this.age = age;
	}
	
	//print the user information in a specific format
	@Override
	public String toString() {
		return "************ User id: " + getId() + "\n" +
			   "************ User name: " + getLastName() + " " +getFirstName() + "\n" +
			   "************ Age: " + getAge() + "\n" +
			   "************ Address: " + getAddress() + "\n";
	}
	
	/**
	 * check the two given users are totally as same as each other
	 * @param: Object: User
	 * @return: true: the two given users are totally as same as each other
	 * @return: false: the two given users are not totally as same as each other
	 */
	public boolean equals(User user1, User user2) {
		return (user1.getFirstName().equals(user2.getFirstName()) &&
				user1.getLastName().equals(user2.getLastName()) &&
				user1.getAddress().equals(user2.getAddress()) &&
				user1.getAge() == user2.getAge());
	}
}

package edu.northeastern.cs5200.models.person;

import java.sql.Date;

public class Developer extends Person {
	
	private String developerKey;
	
	@Override
	public String toString() {
		return super.toString() + "Developer [developerKey=" + developerKey + "]";
	}

	public Developer(int id, String firstName, String lastName, String username, String password, String email, Date dob, String developerKey) {
		super(id, firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}
	
	public Developer(String firstName, String lastName, String username, String password, String email, Date dob, String developerKey) {
		super(firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}
	
	public Developer(String firstName, String lastName, String username, String password, String email, String developerKey) {
		super(firstName, lastName, username, password, email);
		this.developerKey = developerKey;
	}
	
	public Developer() {
		super();
	}
	
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
}

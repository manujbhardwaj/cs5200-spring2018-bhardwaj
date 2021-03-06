package edu.northeastern.cs5200.models.person;

import java.sql.Date;

public class User extends Person{
	
	private String userKey;
	private boolean userAgreement;
	
	@Override
	public String toString() {
		return super.toString() + "User [userKey=" + userKey + ", userAgreement=" + userAgreement + "]";
	}

	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob, String userKey, boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userKey = userKey;
		this.userAgreement= userAgreement;
	}
	
	public User(String firstName, String lastName, String username, String password, String email, Date dob, String userKey, boolean userAgreement) {
		super(firstName, lastName, username, password, email, dob);
		this.userKey = userKey;
		this.userAgreement= userAgreement;
	}
	
	public User(String firstName, String lastName, String username, String password, String email, String userKey, boolean userAgreement) {
		super(firstName, lastName, username, password, email);
		this.userKey = userKey;
		this.userAgreement= userAgreement;
	}
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public boolean isUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	
}

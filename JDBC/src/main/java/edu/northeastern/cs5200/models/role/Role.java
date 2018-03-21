package edu.northeastern.cs5200.models.role;

public class Role {
	private int id;
	private String role;
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role(String role) {
		super();
		this.role = role;
	}
	
	public Role() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

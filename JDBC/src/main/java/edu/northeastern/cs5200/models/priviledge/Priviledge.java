package edu.northeastern.cs5200.models.priviledge;

public class Priviledge {
	private int id;
	private String priviledge;

	@Override
	public String toString() {
		return "Priviledge [priviledge=" + priviledge + "]";
	}

	public Priviledge(String priviledge) {
		super();
		this.priviledge = priviledge;
	}
	
	public Priviledge(int id, String priviledge) {
		super();
		this.id = id;
		this.priviledge = priviledge;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Priviledge() {
		super();
	}

	public String getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
}

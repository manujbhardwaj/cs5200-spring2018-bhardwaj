package edu.northeastern.cs5200.models.website;

import java.sql.Date;

public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	
	@Override
	public String toString() {
		return "Website [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created
				+ ", updated=" + updated + ", visits=" + visits + "]";
	}
	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	public Website(String name, String description, int visits) {
		super();
		this.name = name;
		this.description = description;
		this.visits = visits;
	}
	public Website() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
}

package edu.northeastern.cs5200.models.phone;

public class Phone {
	private int id;
	private String phone;
	private boolean primary;
	
	@Override
	public String toString() {
		return "Phone [id=" + id + ", phone=" + phone + ", primary=" + primary + "]";
	}
	
	public Phone(int id, String phone, boolean primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}
	
	public Phone(String phone, boolean primary) {
		super();
		this.phone = phone;
		this.primary = primary;
	}
	
	public Phone() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}

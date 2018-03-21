package edu.northeastern.cs5200.models.pageWebsiteRole;

public class PageWebsiteRole {
	private int id;
	private int roleId;
	private int developerId;
	private int pageWebsiteId;
	
	@Override
	public String toString() {
		return "PageWebsiteRole [id=" + id + ", roleId=" + roleId + ", developerId=" + developerId + ", pageWebsiteId="
				+ pageWebsiteId + "]";
	}
	public PageWebsiteRole(int roleId, int developerId, int pageWebsiteId) {
		super();
		this.roleId = roleId;
		this.developerId = developerId;
		this.pageWebsiteId = pageWebsiteId;
	}
	public PageWebsiteRole(int id, int roleId, int developerId, int pageWebsiteId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.developerId = developerId;
		this.pageWebsiteId = pageWebsiteId;
	}
	public PageWebsiteRole() {
		super();
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getPageWebsiteId() {
		return pageWebsiteId;
	}
	public void setPageWebsiteId(int pageWebsiteId) {
		this.pageWebsiteId = pageWebsiteId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

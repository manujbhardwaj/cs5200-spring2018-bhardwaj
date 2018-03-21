package edu.northeastern.cs5200.dao.pageWebsiteRole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.pageWebsiteRole.PageWebsiteRole;

public class PageWebsiteRoleDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static PageWebsiteRoleDao instance = null;
	public static PageWebsiteRoleDao getInstance() {
		if(instance == null) {
			instance = new PageWebsiteRoleDao();
		}
		return instance;
	}
	private PageWebsiteRoleDao() {
	}
	
	public int assignWebsiteRole(int developerId, int websiteId, int roleId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into websiteRole(roleId, websiteId, developerId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, roleId);
			statement.setInt(2, websiteId);
			statement.setInt(3, developerId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int assignPageRole(int developerId, int pageId, int roleId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into pageRole(roleId, pageId, developerId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, roleId);
			statement.setInt(2, pageId);
			statement.setInt(3, developerId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteWebsiteRole(int developerId, int websiteId, int roleId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from websiteRole where roleId = ? and websiteId = ? and developerId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, roleId);
			statement.setInt(2, websiteId);
			statement.setInt(3, developerId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deletePageRole(int developerId, int pageId, int roleId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from pageRole where roleId = ? and pageId = ? and developerId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, roleId);
			statement.setInt(2, pageId);
			statement.setInt(3, developerId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Collection<PageWebsiteRole> findRoleByPage(int pageId) {
		ResultSet result = null;
		PreparedStatement statement = null;
		List<PageWebsiteRole> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from pageRole where pageId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				int page = result.getInt("pageId");
				int developerId = result.getInt("developerId");
				int roleId = result.getInt("roleId");
				PageWebsiteRole roleObj = new PageWebsiteRole(id, roleId, developerId, page);
				list.add(roleObj);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int updatePageRole(int pageRoleId, PageWebsiteRole role) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "update pageRole set developerId = ?, pageId = ?, roleId = ? where id = ?";
			statement = connection.prepareStatement(sqlPerson);
			statement.setInt(1, role.getDeveloperId());
			statement.setInt(2, role.getPageWebsiteId());
			statement.setInt(3, role.getRoleId());
			statement.setInt(4, pageRoleId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}

package edu.northeastern.cs5200.dao.website;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.website.Website;

public class WebsiteDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	private WebsiteDao() {
	}
	
	public int deleteWebsite(int websiteId) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from website where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
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

	public int updateWebsite(int websiteId, Website website) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "update website set name = ?, description = ?, visits = ? where id = ?";
			statement = connection.prepareStatement(sqlPerson);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setInt(3, website.getVisits());
			statement.setInt(4, websiteId);
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
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		int result = 0;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into website(name, description, visits) values(?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setInt(3, website.getVisits());
			result = statement.executeUpdate();
			if(result != 1)
				return result;
			rs = statement.getGeneratedKeys();
			int websiteId = 0;
			if(rs.next()) {
				websiteId = rs.getInt(1);
		    } else {
	            throw new SQLException("Error in insert website");
	        }
			sql = "select id from role where role = 'owner'";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			int roleId = 0;
			if(rs.next()) {
				roleId = rs.getInt("id");
			}
			if(roleId == 0)
				throw new IllegalArgumentException("role id not found");
			sql = "insert into websiteRole(developerId, websiteId, roleId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, roleId);
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
	
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		List<Website> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select id from role where role = 'owner'";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			int roleId = 0;
			if(result.next()) {
				roleId = result.getInt("id");
			}
			if(roleId == 0)
				throw new IllegalArgumentException("role id not found");
			sql = "select * from website w join websiteRole wr on w.id = wr.website where wr.roleId = ? and wr.developerId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, roleId);
			statement.setInt(2, developerId);
			result = statement.executeQuery();
			while(result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int id = result.getInt("id");
				int visits = result.getInt("visits");
				Website website = new Website(id, name, description, created, updated, visits);
				list.add(website);
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
	
	public Website findWebsiteById(int websiteId) {
		Website website = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from website where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			result = statement.executeQuery();
			if(result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int id = result.getInt("id");
				int visits = result.getInt("visits");
				website = new Website(id, name, description, created, updated, visits);
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
		return website;
	}
	
	public Website findWebsiteByName(String websiteName) {
		Website website = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from website where name = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, websiteName);
			result = statement.executeQuery();
			if(result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int id = result.getInt("id");
				int visits = result.getInt("visits");
				website = new Website(id, name, description, created, updated, visits);
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
		return website;
	}
	
	public Collection<Website> findAllWebsite(){
		List<Website> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from website";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int id = result.getInt("id");
				int visits = result.getInt("visits");
				Website website = new Website(id, name, description, created, updated, visits);
				list.add(website);
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
}

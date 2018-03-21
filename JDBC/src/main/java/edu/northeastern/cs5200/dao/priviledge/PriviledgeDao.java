package edu.northeastern.cs5200.dao.priviledge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.models.priviledge.Priviledge;
import edu.northeastern.cs5200.models.role.Role;

public class PriviledgeDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static PriviledgeDao instance = null;
	public static PriviledgeDao getInstance() {
		if(instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	private PriviledgeDao() {
	}
	
	public int createPriviledge(Priviledge priviledge) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into priviledge(priviledge) values(?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, priviledge.getPriviledge());
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
	
	public Role findPriviledgeByName(String priviledgeName) {
		ResultSet result = null;
		PreparedStatement statement = null;
		Role roleObj = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from priviledge where priviledge = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, priviledgeName);
			result = statement.executeQuery();
			if(result.next()) {
				String priviledge = result.getString("priviledge");
				int id = result.getInt("id");
				roleObj = new Role(id, priviledge);
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
		return roleObj;
	}
	
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into websitePriviledge(priviledgeId, websiteId, developerId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, priviledgeId);
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
	
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into pagePriviledge(priviledgeId, pageId, developerId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, priviledgeId);
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
	
	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from websitePriviledge where priviledgeId = ? and websiteId = ? and developerId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, priviledgeId);
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
	
	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from pagePriviledge where priviledgeId = ? and pageId = ? and developerId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, priviledgeId);
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
}

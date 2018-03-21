package edu.northeastern.cs5200.dao.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.models.role.Role;

public class RoleDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	private RoleDao() {
	}
	
	public int createRole(Role role) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into role(role) values(?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, role.getRole());
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
	
	public Role findRoleByName(String roleName) {
		ResultSet result = null;
		PreparedStatement statement = null;
		Role roleObj = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from role where role = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, roleName);
			result = statement.executeQuery();
			if(result.next()) {
				String role = result.getString("role");
				int id = result.getInt("id");
				roleObj = new Role(id, role);
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
}

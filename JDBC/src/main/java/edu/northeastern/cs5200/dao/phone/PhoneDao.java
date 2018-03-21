package edu.northeastern.cs5200.dao.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.phone.Phone;

public class PhoneDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static PhoneDao instance = null;
	public static PhoneDao getInstance() {
		if(instance == null) {
			instance = new PhoneDao();
		}
		return instance;
	}
	private PhoneDao() {
	}
	
	public Collection<Phone> findAllPhoneOfPerson(int personId){
		List<Phone> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from phone ph join person p on p.id = ph.personId where p.id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, personId);
			result = statement.executeQuery();
			while(result.next()) {
				String phone = result.getString("phone");
				int id = result.getInt("id");
				Boolean primary = result.getBoolean("primary");
				Phone phoneObj = new Phone(id, phone, primary);
				list.add(phoneObj);
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
	
	public int createPhoneForDeveloper(int developerId, Phone phone){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into phone(phone, `primary`, personId) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, phone.getPhone());
			statement.setBoolean(2, phone.isPrimary());
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
	
	public int updatePhone(int phoneId, Phone phone){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update phone set phone = ?, `primary` = ? where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, phone.getPhone());
			statement.setBoolean(2, phone.isPrimary());
			statement.setInt(3, phoneId);
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
	
	public int deletePhone(int phoneId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from phone where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, phoneId);
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

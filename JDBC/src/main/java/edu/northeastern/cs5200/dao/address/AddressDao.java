package edu.northeastern.cs5200.dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.address.Address;

public class AddressDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static AddressDao instance = null;
	public static AddressDao getInstance() {
		if(instance == null) {
			instance = new AddressDao();
		}
		return instance;
	}
	private AddressDao() {
	}
	
	public Collection<Address> findAddressByPerson(int personId){
		List<Address> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from address where personId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, personId);
			result = statement.executeQuery();
			while(result.next()) {
				String street1 = result.getString("street1");
				String street2 = result.getString("street2");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				boolean primary = result.getBoolean("primary");
				int id = result.getInt("id");
				Address address = new Address(id, street1, street2, city, state, zip, primary);
				list.add(address);
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
	
	public int createAddressForDeveloper(int developerId, Address address){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into address(street1, street2, city, state, zip, `primary`, personId) values(?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, address.getStreet1());
			statement.setString(2, address.getStreet2());
			statement.setString(3, address.getCity());
			statement.setString(4, address.getState());
			statement.setString(5, address.getZip());
			statement.setBoolean(6, address.isPrimary());
			statement.setInt(7, developerId);
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
	
	public int updateAddress(int addressId, Address address){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update address set street1 = ?, street2 = ?, city = ?, state = ?, zip = ?, primary = ? where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, address.getStreet1());
			statement.setString(2, address.getStreet2());
			statement.setString(3, address.getCity());
			statement.setString(4, address.getState());
			statement.setString(5, address.getZip());
			statement.setBoolean(6, address.isPrimary());
			statement.setInt(7, addressId);
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
	
	public int deleteAddress(int addressId){
		int result = 0;; 
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from address where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, addressId);
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

package edu.northeastern.cs5200.dao.user;

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

import edu.northeastern.cs5200.models.person.User;

public class UserDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static UserDao instance = null;
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	private UserDao() {
	}
	
	public int deleteUser(int userId) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
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
	
	public int createUser(User user) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into person(firstName, lastName, username, password, email, dob) values(?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getEmail());
			statement.setDate(6, user.getDob());
			result = statement.executeUpdate();
			if(result != 1)
				return result;
			ResultSet rs = statement.getGeneratedKeys();
			int personId = 0;
			if(rs.next()) {
				personId = rs.getInt(1);
		    } else {
	            throw new SQLException("Error in insert person");
	        }
			sql = "insert into user(personId, userKey, userAgreement) values(?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, personId);
			statement.setString(2, user.getUserKey());
			statement.setBoolean(3, user.isUserAgreement());
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
	
	public int updateUser(int userId, User user) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "update person p join user d on p.id = d.personId set firstName = ?, lastName = ?, username = ?, password = ?, dob = ?, email = ?, userKey = ?, userAgreement = ? where p.id = ?";
			statement = connection.prepareStatement(sqlPerson);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setDate(5, user.getDob());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getUserKey());
			statement.setBoolean(8, user.isUserAgreement());
			statement.setInt(9, userId);
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
	
	public User findUserById(int userId) {
		User user = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from user d, person p where d.personId = p.id and d.person = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
			result = statement.executeQuery();
			if(result.next()) {
				String userKey = result.getString("userKey");
				boolean userAgreement = result.getBoolean("userAgreement");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				user = new User(id, firstName, lastName, username, password, email, dob, userKey, userAgreement);
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
		return user;
	}
	
	public User findUserByUsername(String userName) {
		User user = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from user d, person p where d.personId = p.id and p.username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			result = statement.executeQuery();
			if(result.next()) {
				String userKey = result.getString("userKey");
				boolean userAgreement = result.getBoolean("userAgreement");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				user = new User(id, firstName, lastName, username, password, email, dob, userKey, userAgreement);
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
		return user;
	}
	
	public User findUserByCredentials(String userName, String passWord) {
		User user = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from user d, person p where d.personId = p.id and p.username = ? and p.password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, passWord);
			result = statement.executeQuery();
			if(result.next()) {
				String userKey = result.getString("userKey");
				boolean userAgreement = result.getBoolean("userAgreement");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				user = new User(id, firstName, lastName, username, password, email, dob, userKey, userAgreement);
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
		return user;
	}

	public Collection<User> findAllUser(){
		List<User> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from user d, person p where d.personId = p.id";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String userKey = result.getString("userKey");
				boolean userAgreement = result.getBoolean("userAgreement");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				User user = new User(id, firstName, lastName, username, password, email, dob, userKey, userAgreement);
				list.add(user);
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

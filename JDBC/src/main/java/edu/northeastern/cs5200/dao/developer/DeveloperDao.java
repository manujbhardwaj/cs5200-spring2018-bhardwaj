package edu.northeastern.cs5200.dao.developer;

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

import edu.northeastern.cs5200.models.person.Developer;

public class DeveloperDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	private DeveloperDao() {
	}
	
	public int deleteDeveloper(int developerId) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
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
	
	public int createDeveloper(Developer developer) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into person(firstName, lastName, username, password, email) values(?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
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
			sql = "insert into developer(personId, developerKey) values(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, personId);
			statement.setString(2, developer.getDeveloperKey());
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
	
	public int updateDeveloper(int developerId, Developer developer) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "update person p join developer d on p.id = d.personId set firstName = ?, lastName = ?, username = ?, password = ?, email = ?, developerKey = ? where p.id = ?";
			statement = connection.prepareStatement(sqlPerson);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDeveloperKey());
			statement.setInt(6, developerId);
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
	
	public Developer findDeveloperById(int developerId) {
		Developer developer = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from developer d, person p where d.personId = p.id and d.personId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			result = statement.executeQuery();
			if(result.next()) {
				String developerKey = result.getString("developerKey");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		return developer;
	}
	
	public Developer findDeveloperByUsername(String userName) {
		Developer developer = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from developer d, person p where d.personId = p.id and p.username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			result = statement.executeQuery();
			if(result.next()) {
				String developerKey = result.getString("developerKey");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		return developer;
	}
	
	public Developer findDeveloperByCredentials(String userName, String passWord) {
		Developer developer = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from developer d, person p where d.personId = p.id and p.username = ? and p.password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, passWord);
			result = statement.executeQuery();
			if(result.next()) {
				String developerKey = result.getString("developerKey");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		return developer;
	}

	public Collection<Developer> findAllDeveloper(){
		List<Developer> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from developer d, person p where d.personId = p.id";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String developerKey = result.getString("developerKey");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("dob");
				int id = result.getInt("id");
				Developer developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
				list.add(developer);
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

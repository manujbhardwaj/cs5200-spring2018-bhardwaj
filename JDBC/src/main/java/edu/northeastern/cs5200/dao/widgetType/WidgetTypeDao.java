package edu.northeastern.cs5200.dao.widgetType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.widget.WidgetType;

public class WidgetTypeDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static WidgetTypeDao instance = null;
	public static WidgetTypeDao getInstance() {
		if(instance == null) {
			instance = new WidgetTypeDao();
		}
		return instance;
	}
	private WidgetTypeDao() {
	}
	
	public int createWidgetType(WidgetType widgetType) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into widgetType(widgetType) values(?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, widgetType.getWidgetType());
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
	
	public Collection<WidgetType> findAllWidgetType() {
		List<WidgetType> list = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from widgetType";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String widgetType = result.getString("widgetType");
				WidgetType widgetTypeObj = new WidgetType(widgetType);
				list.add(widgetTypeObj);
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

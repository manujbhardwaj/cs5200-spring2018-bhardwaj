package edu.northeastern.cs5200.dao.page;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.page.Page;

public class PageDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	private PageDao() {
	}
	
	public int deletePage(int pageId) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from page where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
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

	public int updatePage(int pageId, Page page) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "update page set title = ?, description = ?, views = ? where id = ?";
			statement = connection.prepareStatement(sqlPerson);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setInt(3, page.getViews());
			statement.setInt(4, pageId);
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
	
	public int createPageForWebsite(int websiteId, Page page) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into page(title, description, views, websiteId) values(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setInt(3, page.getViews());
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
	
	public Collection<Page> findPagesForWebsite(int websiteId) {
		List<Page> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from page where websiteId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			result = statement.executeQuery();
			while(result.next()) {
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int views = result.getInt("views");
				int id = result.getInt("id");
				Page page = new Page(id, title, description, created, updated, views);
				list.add(page);
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
	
	public Page findPageById(int pageId) {
		Page page = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from page where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			result = statement.executeQuery();
			if(result.next()) {
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int views = result.getInt("views");
				int id = result.getInt("id");
				page = new Page(id, title, description, created, updated, views);
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
		return page;
	}
	
	public Collection<Page> findAllPage(){
		List<Page> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from page";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int views = result.getInt("views");
				int id = result.getInt("id");
				Page page = new Page(id, title, description, created, updated, views);
				list.add(page);
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

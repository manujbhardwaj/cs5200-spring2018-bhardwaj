package edu.northeastern.cs5200.dao.widget;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.widget.HeadingWidget;
import edu.northeastern.cs5200.models.widget.HtmlWidget;
import edu.northeastern.cs5200.models.widget.ImageWidget;
import edu.northeastern.cs5200.models.widget.Widget;
import edu.northeastern.cs5200.models.widget.YoutubeWidget;

public class WidgetDao {
	private static final String USERNAME = "manujbhardwaj";
	private static final String PASSWORD = "justmanuj";
	private static final String URL = "jdbc:mysql://cs5200-spring2018-bhardwaj.cfplmhwwbvcu.us-east-2.rds.amazonaws.com/hw3_bhardwaj_manuj_spring_2018";
	Connection connection = null;
	
	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	private WidgetDao() {
	}
	
	public int deleteWidget(int widgetId) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from widget where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
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

	public int updateWidget(int widgetId, Widget widget) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update widget set widgetType = ?, text = ?, name = ?, cssStyle = ?, cssClass = ?, `order` = ?, height = ?, width = ? where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getType());
			statement.setString(2, widget.getText());
			statement.setString(3, widget.getName());
			statement.setString(4, widget.getCssStyle());
			statement.setString(5, widget.getCssClass());
			statement.setInt(6, widget.getOrder());
			statement.setInt(7, widget.getHeight());
			statement.setInt(8, widget.getWidth());
			statement.setInt(9, widgetId);
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
	
	public int createWidgetForPage(int pageId, Widget widget) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into widget(widgetType, text, name, cssStyle, cssClass, `order`, height, width, pageId) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, widget.getType());
			statement.setString(2, widget.getText());
			statement.setString(3, widget.getName());
			statement.setString(4, widget.getCssStyle());
			statement.setString(5, widget.getCssClass());
			statement.setInt(6, widget.getOrder());
			statement.setInt(7, widget.getHeight());
			statement.setInt(8, widget.getWidth());
			statement.setInt(9, pageId);
			result = statement.executeUpdate();
			if(result != 1)
				return result;
			ResultSet rs = statement.getGeneratedKeys();
			int widgetId = 0;
			if(rs.next()) {
				widgetId = rs.getInt(1);
		    } else {
	            throw new SQLException("Error in insert widget");
	        }
			if(widget.getType().equals("heading"))
				result = createHeadingWidget(widgetId, (HeadingWidget)widget, connection);
			else if(widget.getType().equals("image"))
				result = createImageWidget(widgetId, (ImageWidget)widget, connection);
			else if(widget.getType().equals("youtube"))
				result = createYoutubeWidget(widgetId, (YoutubeWidget)widget, connection);
			else if(widget.getType().equals("html"))
				result = createHtmlWidget(widgetId, (HtmlWidget)widget, connection);
			else
				throw new IllegalArgumentException("Wrong widget type");
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
	
	private int createHeadingWidget(int widgetId, HeadingWidget headingWidget, Connection connection) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into heading(size, widgetId) values(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, headingWidget.getSize());
			statement.setInt(2, widgetId);
			result = statement.executeUpdate();
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
	
	private int createImageWidget(int widgetId, ImageWidget imageWidget, Connection connection) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into image(src, widgetId) values(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, imageWidget.getSrc());
			statement.setInt(2, widgetId);
			result = statement.executeUpdate();
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
	
	private int createYoutubeWidget(int widgetId, YoutubeWidget youtubeWidget, Connection connection) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into youtube(url, shareable, expandable, widgetId) values(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, youtubeWidget.getUrl());
			statement.setBoolean(2, youtubeWidget.isShareable());
			statement.setBoolean(3, youtubeWidget.isExpandable());
			statement.setInt(4, widgetId);
			result = statement.executeUpdate();
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
	
	private int createHtmlWidget(int widgetId, HtmlWidget htmlWidget, Connection connection) {
		int result = 0;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into html(html, widgetId) values(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, htmlWidget.getHtml());
			statement.setInt(2, widgetId);
			result = statement.executeUpdate();
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
	
	public Collection<Widget> findWidgetsForPage(int pageId) {
		List<Widget> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from widget where pageId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			result = statement.executeQuery();
			while(result.next()) {
				String type = result.getString("widgetType");
				String text = result.getString("text");
				String name = result.getString("name");
				String cssStyle = result.getString("cssStyle");
				String cssClass = result.getString("cssClass");
				int order = result.getInt("order");
				int height = result.getInt("height");
				int width = result.getInt("width");
				int id = result.getInt("id");
				int page = result.getInt("pageId");
				Widget widget = new Widget(id, name, type, order, text, cssStyle, cssClass, height, width, page);
				list.add(widget);
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
	
	public Widget findWidgetById(int widgetId) {
		Widget widget = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from widget where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			result = statement.executeQuery();
			if(result.next()) {
				String type = result.getString("widgetType");
				String text = result.getString("text");
				String name = result.getString("name");
				String cssStyle = result.getString("cssStyle");
				String cssClass = result.getString("cssClass");
				int order = result.getInt("order");
				int height = result.getInt("height");
				int width = result.getInt("width");
				int id = result.getInt("id");
				int pageId = result.getInt("pageId");
				widget = new Widget(id, name, type, order, text, cssStyle, cssClass, height, width, pageId);
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
		return widget;
	}
		
	public Collection<Widget> findAllWidget(){
		List<Widget> list = new ArrayList<>(); 
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from widget";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				String type = result.getString("widgetType");
				String text = result.getString("text");
				String name = result.getString("name");
				String cssStyle = result.getString("cssStyle");
				String cssClass = result.getString("cssClass");
				int order = result.getInt("order");
				int height = result.getInt("height");
				int width = result.getInt("width");
				int id = result.getInt("id");
				int pageId = result.getInt("pageId");
				Widget widget = new Widget(id, name, type, order, text, cssStyle, cssClass, height, width, pageId);
				list.add(widget);
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

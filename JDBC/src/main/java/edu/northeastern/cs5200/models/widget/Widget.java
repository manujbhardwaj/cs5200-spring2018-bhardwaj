package edu.northeastern.cs5200.models.widget;

public class Widget {
	private int id;
	private String type;
	private int order;
	private String text;
	private String cssStyle;
	private String cssClass;
	private int height;
	private int width;
	private String name;
	private int pageId;
	
	@Override
	public String toString() {
		return "Widget [id=" + id + ", type=" + type + ", order=" + order + ", text=" + text + ", cssStyle=" + cssStyle
				+ ", cssClass=" + cssClass + ", height=" + height + ", width=" + width + ", name=" + name + "]";
	}
	public Widget(int id, String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width, int pageId) {
		super();
		this.id = id;
		this.type = type;
		this.order = order;
		this.text = text;
		this.cssStyle = cssStyle;
		this.cssClass = cssClass;
		this.height = height;
		this.width = width;
		this.name = name;
		this.pageId = pageId;
	}
	public Widget(String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width) {
		super();
		this.type = type;
		this.order = order;
		this.text = text;
		this.cssStyle = cssStyle;
		this.cssClass = cssClass;
		this.height = height;
		this.width = width;
		this.name = name;
	}
	public Widget() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
}


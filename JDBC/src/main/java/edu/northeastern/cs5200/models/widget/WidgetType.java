package edu.northeastern.cs5200.models.widget;

public class WidgetType {
	private String widgetType;
	
	public WidgetType(String widgetType) {
		super();
		this.widgetType = widgetType;
	}

	public WidgetType() {
		super();
	}

	@Override
	public String toString() {
		return "WidgetType [widgetType=" + widgetType + "]";
	}

	public String getWidgetType() {
		return widgetType;
	}

	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}	
}

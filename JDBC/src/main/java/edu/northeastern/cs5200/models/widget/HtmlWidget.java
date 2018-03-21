package edu.northeastern.cs5200.models.widget;

public class HtmlWidget extends Widget{
	
	private String html;
	
	@Override
	public String toString() {
		return super.toString() + "HtmlWidget [html=" + html + "]";
	}
	
	public HtmlWidget(String html) {
		super();
		this.html = html;
	}
	public HtmlWidget(String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width, String html) {
		super(name, type, order, text, cssStyle, cssClass, height, width);
		this.html = html;
	}
	public HtmlWidget() {
		super();
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}

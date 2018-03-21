package edu.northeastern.cs5200.models.widget;

public class ImageWidget extends Widget{
	private String src;
	
	@Override
	public String toString() {
		return "ImageWidget [src=" + src + ", toString()=" + super.toString() + "]";
	}
	
	public ImageWidget(String src) {
		super();
		this.src = src;
	}
	public ImageWidget(String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width, String src) {
		super(name, type, order, text, cssStyle, cssClass, height, width);
		this.src = src;
	}
	public ImageWidget() {
		super();
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}

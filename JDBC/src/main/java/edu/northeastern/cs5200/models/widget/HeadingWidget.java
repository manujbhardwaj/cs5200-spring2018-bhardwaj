package edu.northeastern.cs5200.models.widget;

public class HeadingWidget extends Widget{
	private int size;
	
	@Override
	public String toString() {
		return super.toString() + "HeadingWidget [size=" + size + "]";
	}
	
	public HeadingWidget(int size) {
		super();
		this.size = size;
	}
	public HeadingWidget(String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width, int size) {
		super(name, type, order, text, cssStyle, cssClass, height, width);
		this.size = size;
	}
	public HeadingWidget() {
		super();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}

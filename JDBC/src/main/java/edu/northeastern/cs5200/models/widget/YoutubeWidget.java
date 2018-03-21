package edu.northeastern.cs5200.models.widget;

public class YoutubeWidget extends Widget {
	private String url;
	private boolean shareable;
	private boolean expandable;
	
	@Override
	public String toString() {
		return super.toString() + "YoutubeWidget [url=" + url + ", shareable=" + shareable + ", expandable=" + expandable + "]";
	}
	
	public YoutubeWidget(String url, boolean shareable, boolean expandable) {
		super();
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}
	public YoutubeWidget(String name, String type, int order, String text, String cssStyle, String cssClass, int height,
			int width, String url, boolean shareable, boolean expandable) {
		super(name, type, order, text, cssStyle, cssClass, height, width);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}
	public YoutubeWidget() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
}

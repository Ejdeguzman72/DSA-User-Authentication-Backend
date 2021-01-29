package com.dsa.HomeInfoTracker.file_upload_models;

public class VideosFileInfo {

	private String videosFilename;
	private String videosFileUrl;
	
	public String getVideosFilename() {
		return videosFilename;
	}
	public void setVideosFilename(String videosFilename) {
		this.videosFilename = videosFilename;
	}
	public String getVideosFileUrl() {
		return videosFileUrl;
	}
	public void setVideosFileUrl(String videosFileUrl) {
		this.videosFileUrl = videosFileUrl;
	}
	
	@Override
	public String toString() {
		return "VideosFileInfo [videosFilename=" + videosFilename + ", videosFileUrl=" + videosFileUrl
				+ ", getVideosFilename()=" + getVideosFilename() + ", getVideosFileUrl()=" + getVideosFileUrl()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}

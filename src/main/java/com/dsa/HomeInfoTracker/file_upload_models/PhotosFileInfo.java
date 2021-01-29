package com.dsa.HomeInfoTracker.file_upload_models;

public class PhotosFileInfo {

	private String photosFileName;
	private String photosFileUrl;
	
	public PhotosFileInfo(String filename, String url) {
		super();
		this.photosFileName = filename;
		this.photosFileUrl = url;
	}
	public String getPhotosFileName() {
		return photosFileName;
	}
	public void setPhotosFileName(String photosFileName) {
		this.photosFileName = photosFileName;
	}
	public String getPhotosFileUrl() {
		return photosFileUrl;
	}
	public void setPhotosFileUrl(String photosFileUrl) {
		this.photosFileUrl = photosFileUrl;
	}
	
	@Override
	public String toString() {
		return "PhotosFileInfo [photosFileName=" + photosFileName + ", photosFileUrl=" + photosFileUrl + "]";
	}
}

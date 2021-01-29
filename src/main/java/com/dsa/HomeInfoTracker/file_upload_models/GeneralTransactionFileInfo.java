package com.dsa.HomeInfoTracker.file_upload_models;

public class GeneralTransactionFileInfo {

	private String name;
	private String url;
	
	public GeneralTransactionFileInfo(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "GeneralTransactionFileInfo [name=" + name + ", url=" + url + ", getName()=" + getName() + ", getUrl()=" + getUrl()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}

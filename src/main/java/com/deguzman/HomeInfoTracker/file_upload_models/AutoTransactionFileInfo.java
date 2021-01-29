package com.deguzman.HomeInfoTracker.file_upload_models;

public class AutoTransactionFileInfo {

	private String autoTrxFilename;
	private String autoTrxFileUrl;
	
	public String getAutoTrxFilename() {
		return autoTrxFilename;
	}
	public void setAutoTrxFilename(String autoTrxFilename) {
		this.autoTrxFilename = autoTrxFilename;
	}
	public String getAutoTrxFileUrl() {
		return autoTrxFileUrl;
	}
	public void setAutoTrxFileUrl(String autoTrxFileUrl) {
		this.autoTrxFileUrl = autoTrxFileUrl;
	}
	
	public AutoTransactionFileInfo(String autoTrxFilename, String autoTrxFileUrl) {
		super();
		this.autoTrxFilename = autoTrxFilename;
		this.autoTrxFileUrl = autoTrxFileUrl;
	}
	
	@Override
	public String toString() {
		return "AutoTransactionFileInfo [autoTrxFilename=" + autoTrxFilename + ", autoTrxFileUrl=" + autoTrxFileUrl
				+ ", getAutoTrxFilename()=" + getAutoTrxFilename() + ", getAutoTrxFileUrl()=" + getAutoTrxFileUrl()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}

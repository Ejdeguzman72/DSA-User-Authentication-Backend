package com.dsa.HomeInfoTracker.file_upload_models;

public class MedicalTransactionFileInfo {

	private String medicalTransactionFileName;
	private String medicalTransactionFileUrl;
	
	public String getMedicalTransactionFileName() {
		return medicalTransactionFileName;
	}
	public void setMedicalTransactionFileName(String medicalTransactionFileName) {
		this.medicalTransactionFileName = medicalTransactionFileName;
	}
	public String getMedicalTransactionFileUrl() {
		return medicalTransactionFileUrl;
	}
	public void setMedicalTransactionFileUrl(String medicalTransactionFileUrl) {
		this.medicalTransactionFileUrl = medicalTransactionFileUrl;
	}
	
	public MedicalTransactionFileInfo(String medicalTransactionFileName, String medicalTransactionFileUrl) {
		super();
		this.medicalTransactionFileName = medicalTransactionFileName;
		this.medicalTransactionFileUrl = medicalTransactionFileUrl;
	}
	@Override
	public String toString() {
		return "MedicalTransactionFileInfo [medicalTransactionFileName=" + medicalTransactionFileName
				+ ", medicalTransactionFileUrl=" + medicalTransactionFileUrl + ", getMedicalTransactionFileName()="
				+ getMedicalTransactionFileName() + ", getMedicalTransactionFileUrl()=" + getMedicalTransactionFileUrl()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}

package com.deguzman.HomeInfoTracker.file_upload_service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface MedicalTransactionFilesStorageService {

	public void init();
	
	public void save(MultipartFile file);
	
	public Resource load(String filename);
	
	public void deleteAllMedicalFiles();
	
	public Stream<Path> laodAllMedicalFiles();
}

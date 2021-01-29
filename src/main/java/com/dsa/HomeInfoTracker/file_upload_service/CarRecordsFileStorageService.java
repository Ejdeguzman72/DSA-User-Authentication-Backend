package com.dsa.HomeInfoTracker.file_upload_service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface CarRecordsFileStorageService {
	public void init();
	
	public void save(MultipartFile file);
	
	public Resource load(String filename);
	
	public void deleteAllGeneralFiles();
	
	public Stream<Path> loadAllGeneralFiles();

}

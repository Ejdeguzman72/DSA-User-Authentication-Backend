package com.dsa.HomeInfoTracker.file_upload_controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.dsa.HomeInfoTracker.external_file_message.ResponseMessage;
import com.dsa.HomeInfoTracker.file_upload_models.GeneralTransactionFileInfo;
import com.dsa.HomeInfoTracker.file_upload_service.CarRecordsFileStorageService;

@RestController
@RequestMapping("/app/car-record-documents")
@CrossOrigin
public class CarRecordFileController {

	@Autowired
	CarRecordsFileStorageService carRecordsFilesStorageService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			carRecordsFilesStorageService.save(file);
			
			message = "Uploaded the file successfully: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<GeneralTransactionFileInfo>> getListFiles() {
		List<GeneralTransactionFileInfo> fileInfos = (List<GeneralTransactionFileInfo>) carRecordsFilesStorageService.loadAllGeneralFiles().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(CarRecordFileController.class, "getFile",path.getFileName().toString()).build().toString();
			
			return new GeneralTransactionFileInfo(filename,url);
		}).collect(Collectors.toList());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}
	
	@GetMapping("/files/{filename}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = carRecordsFilesStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}

package com.example.demo.resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.CourseService;
import com.example.demo.Service.DocumentLibraryService;
import com.example.demo.Service.FileStorageService;
import com.example.demo.customException.FileStorageException;
import com.example.demo.model.Course;
import com.example.demo.model.DocumentLibrary;
import com.example.demo.payload.UploadFileResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
	 @Autowired 
	 private DocumentLibraryService docService;
	 @Autowired
		private CourseService courseService;
	

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    
	/*  @PostMapping("/courseFileUpload")
	    public UploadFileResponse uploadFileForCourse(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();

	        return new UploadFileResponse(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }*/
    
    @PostMapping("/course3")
	public void addCourse2(@RequestParam("file") MultipartFile file) {
	System.out.println(file.getOriginalFilename());
    }
    
//    @CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/course2")
	public void addCourse(@RequestParam("course")  String course,@RequestParam("file") MultipartFile file) {
	// upload file
		String fileName = null;
		Course courseObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			 courseObj = mapper.readValue(course, Course.class);
			
			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			// TODO Auto-generated catch block
			return ;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			        .path("/downloadFile/")
			        .path(fileName)
			        .toUriString();
			UUID uuid = UUID.randomUUID();
			

			DocumentLibrary docLib =  new DocumentLibrary(uuid.toString(),fileName, fileDownloadUri, file.getContentType(), file.getSize());
			docLib =  docService.save(docLib);
			//if(docLib!=null)
				//course.setFkDocumnentLibID(docLib.getDocLibID());
			courseService.save(courseObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}

		return ;
	}

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}

package com.example.demo.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.DocumentLibraryService;
import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.FreeStudyMaterialService;
import com.example.demo.customException.FileStorageException;
import com.example.demo.model.Chapter;
import com.example.demo.model.DocumentLibrary;
import com.example.demo.model.FreeStudyMateral;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class FreeStudyMaterialController {
	@Autowired
    private FreeStudyMaterialService service;
	 @Autowired 
	 private DocumentLibraryService docService;
	 @Autowired
	    private FileStorageService fileStorageService;
	
	@GetMapping("/fsm")
	public String getStandardregisterForm() {
		return "free study material form";
	}
	
	@PostMapping("/fsm")
		public void FreeStudyMateral(@RequestParam("fsm")  String fsm,@RequestParam("file") MultipartFile file) {
		// upload file
				String fileName = null;
				FreeStudyMateral fsmObj = null;
				try {
					ObjectMapper mapper = new ObjectMapper();
					fsmObj = mapper.readValue(fsm, FreeStudyMateral.class);
					
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
					if(docLib!=null)
					{
						fsmObj.setFkDocLibID(docLib.getDocLibID());
					fsmObj.setDownLoadPath(fileDownloadUri);
					}
					service.save(fsmObj);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ;
				}

				return ;
	  }
	
	@GetMapping("/getFSM/{topicID}")
	public FreeStudyMateral getFreeStudyMaterial(@PathVariable  String topicID) {
		List<FreeStudyMateral> fsmList = null;
		fsmList = service.getFreeStudyMaterialByTopicID(Long.valueOf(topicID));
		if(fsmList!=null && !fsmList.isEmpty())
		return service.getFreeStudyMaterialByTopicID(Long.valueOf(topicID)).get(0);
		else return null;
	}
	
	
	
}

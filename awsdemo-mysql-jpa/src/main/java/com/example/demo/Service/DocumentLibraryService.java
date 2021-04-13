package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.DocumentLibraryRepository;
import com.example.demo.model.DocumentLibrary;

@Service
@Transactional
public class DocumentLibraryService {
	@Autowired
	    private DocumentLibraryRepository repo;
	     
	    public List<DocumentLibrary> listAll() {
	        return repo.findAll();
	    }
	     
	    public DocumentLibrary save(DocumentLibrary DocumentLibrary) {
	        return repo.save(DocumentLibrary);
	    }
	     
	    public DocumentLibrary get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
}

package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DocumentLibrary;
public interface DocumentLibraryRepository  extends JpaRepository<DocumentLibrary, Long> {
	 
	}



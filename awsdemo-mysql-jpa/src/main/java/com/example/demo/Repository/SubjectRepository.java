package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Subject;
public interface SubjectRepository  extends JpaRepository<Subject, Long> ,SubjectRepositoryCustom{
	 
	}



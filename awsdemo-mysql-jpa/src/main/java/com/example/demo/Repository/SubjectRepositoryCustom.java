package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Subject;
public interface SubjectRepositoryCustom {
	//public boolean saveSubjectUserAssociation(UserSubjectAssociation userSubjectAssociation);

	@Query("select s from Subject s  where s.fkStandaradID=:fkStandardID")
	public List<Subject> getListofSubjectByStandardID(@Param("fkStandardID") long fkStandardID);
	
}



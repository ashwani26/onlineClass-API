package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Subject;
public interface SubjectRepositoryCustom {
	//public boolean saveSubjectUserAssociation(UserSubjectAssociation userSubjectAssociation);

	@Query("select s from UserSubjectAssociation usa inner join Subject s on s.subjectID = usa.subjectID where usa.userID=:userID")
	public List<Subject> getListofSubjectByUserID(@Param("userID") long userID);
	
}



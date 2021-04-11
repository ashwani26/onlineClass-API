package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Chapter;

public interface ChapterRepositoryCustom {
	
	@Query("select c from Chapter c  where c.fkSubjectID=:fkSubjectID")
	public List<Chapter> getListofChapterBySubjectID(@Param("fkSubjectID") long fkSubjectID);

}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.StudyMaterial;

public interface CourseRepositoryCustom {

	@Query("SELECT sm from CourseStudyMaterial csm,StudyMaterial sm where sm.ID = csm.studyMaterialID and csm.courseID=:courseID")
	public List<StudyMaterial> findStudyMaterialByCourseID(@Param("courseID") long courseID);
}

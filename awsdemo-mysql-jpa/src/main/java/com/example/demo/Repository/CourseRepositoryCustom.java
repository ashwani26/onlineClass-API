package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.StudyMaterial;

public interface CourseRepositoryCustom {

	@Query("SELECT sm from CourseStudyMaterial csm,StudyMaterial sm where sm.ID = csm.studyMaterialID and csm.courseID=:courseID")
	public List<StudyMaterial> findStudyMaterialByCourseID(@Param("courseID") long courseID);
	
	@Modifying
	@Query("update Course c set c.courseName =?1, c.fkStandardID=?2,c.status=?3,c.startDate =?4,c.endDate=?5,c.subjectList=?6,c.description=?7,c.price =?8 where c.courseID=?9")
	public void updateByCourseID(String courseName,long fkStandardID,boolean status,Date startDate,Date endDate,String subjectList,  String description,double price ,long courseID);
	
	
	// save course and document library in one method
//	public boolean saveCourseAndLogo(Course course,MultipartFile file);
}

package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Course;
import com.example.demo.model.CourseViewModel;
import com.example.demo.model.StudyMaterial;

public interface CourseRepositoryCustom {

	@Query("SELECT sm from CourseStudyMaterial csm,StudyMaterial sm where sm.ID = csm.studyMaterialID and csm.courseID=:courseID")
	public List<StudyMaterial> findStudyMaterialByCourseID(@Param("courseID") long courseID);
	
	@Modifying
	@Query("update Course c set c.courseName =?1, c.fkStandardID=?2,c.status=?3,c.startDate =?4,c.endDate=?5,c.description=?6,c.price =?7 where c.courseID=?8")
	public void updateByCourseID(String courseName,long fkStandardID,boolean status,Date startDate,Date endDate,String description,double price ,long courseID);
	
	
	// save course and document library in one method
//	public boolean saveCourseAndLogo(Course course,MultipartFile file);
	
	@Query("SELECT sm from CourseStudyMaterial csm,StudyMaterial sm where sm.ID = csm.studyMaterialID and csm.courseID=:courseID")
	public List<CourseViewModel> getCourseViewModel();
	
	@Query("select c from Course c where c.courseID  in(select fkCourseID from CourseStudentAssociation where fk_userid=:studentID)")
	public List<Course> getAllRegisteredCoursebyStudent(long studentID);
	
	//  select * from course where courseid not in(select fk_courseid from course_student_association where fk_userid=2) ;
	//@Query("SELECT c from Course c left join CourseStudentAssociation csa on c.courseID=csa.fkCourseID  where csa.courseStudentAssociationID is null or  csa.fkUserID<>:studentID")
	@Query("select c from Course c where c.courseID not in(select fkCourseID from CourseStudentAssociation where fk_userid=:studentID)")
	public List<Course> getAllCourseNotRegisteredbyStudent(long studentID);
	
}

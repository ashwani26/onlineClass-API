package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.LiveClassSchedule;
import com.example.demo.model.LiveClassScheduleViewModel;

public interface LiveClassScheduleRepositoryCustom {
	
	@Query("select c from Chapter c  where c.fkSubjectID=:fkSubjectID")
	public List<LiveClassSchedule> saveLiveClassByDateAndSlot(@Param("fkSubjectID") long fkSubjectID);
	
	@Query("select new com.example.demo.model.LiveClassScheduleViewModel(c.courseName,sub.subName,lcs.scheduleDate, sm.slotName,lcs.liveClassScheduleID,lcs.isEnded,lcs.studyDuration) FROM LiveClassSchedule lcs ,Course c,Subject sub,SlotMaster sm where  c.courseID = lcs.fkCourseID and sub.subjectID = lcs.fkSubjectID and sm.slotID = lcs.fkSlotID and lcs.fkUserID=:teacherID")
	public List<LiveClassScheduleViewModel> getListOfScheudleByTeacherID(@Param("teacherID") long teacherID);

	@Query("select distinct new com.example.demo.model.LiveClassScheduleViewModel(c.courseName,sub.subName,lcs.scheduleDate, sm.slotName,lcs.liveClassScheduleID,lcs.isEnded,lcs.studyDuration) FROM LiveClassSchedule lcs ,Course c,Subject sub,SlotMaster sm,CourseStudentAssociation csa where  c.courseID = lcs.fkCourseID and sub.subjectID = lcs.fkSubjectID and sm.slotID = lcs.fkSlotID and csa.fkCourseID=lcs.fkCourseID and csa.fkUserID=:studentID group by lcs.liveClassScheduleID")
	public List<LiveClassScheduleViewModel> getListOfScheduleByStudentID(@Param("studentID") long studentID);

}

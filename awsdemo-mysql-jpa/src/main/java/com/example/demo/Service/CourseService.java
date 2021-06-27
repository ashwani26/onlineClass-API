package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.model.Course;
import com.example.demo.model.StudyMaterial;
 
@Service
@Transactional
public class CourseService {
 
    @Autowired
    private CourseRepository repo;
    
    
     
    public List<Course> listAll() {
        return repo.findAll();
    }
     
    public Course save(Course Course) {
        return repo.save(Course);
    }
     
    public Course get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    //String courseName,long fkDisplayCategoryID,boolean status,Date startDate,Date endDate,String subjectList,  String description,double price ,long courseID
    
    public void update(Course course) {
        repo.updateByCourseID(course.getCourseName(),course.getFkDocumentLibID(),course.getStatus(),course.getStartDate(),course.getEndDate(),course.getDescription(),course.getPrice(),course.getCourseID());
    }
    
    public List<StudyMaterial> listAllStudymaterialByCourseID(long CourseID) {
        return repo.findStudyMaterialByCourseID(CourseID);
    }
    
    public List<Course>  getAllRegisteredCoursebyStudent(long studentID){
    	return repo.getAllRegisteredCoursebyStudent(studentID);
    }
    
    public List<Course> getAllCourseNotRegisteredbyStudent(long studentID){
    	return repo.getAllCourseNotRegisteredbyStudent(studentID);
    }
    
    
//   public  List<Course> getAllCourseByStandardID(long standardID){
//	   return repo.getAllCourseByStandardID(standardID);
//    }
	/*
	 * @Transactional public boolean saveCourseAndLogo(Course course,MultipartFile
	 * file) { DocumentLibrary docLib = new DocumentLibrary();
	 * docLib.setFileName(file.getOriginalFilename());
	 * docLib.setExtension(file.getOriginalFilename().substring(file.
	 * getOriginalFilename().indexOf(".")+1)); docRepo.save(docLib);
	 * 
	 * course.setFkDocLibID(docLib.getDocLibID()); repo.save(course); return true; }
	 */
    
    
  
}

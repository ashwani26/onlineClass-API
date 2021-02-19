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
    
    public List<StudyMaterial> listAllStudymaterialByCourseID(long CourseID) {
        return repo.findStudyMaterialByCourseID(CourseID);
    }
    
    
    
    
  
}

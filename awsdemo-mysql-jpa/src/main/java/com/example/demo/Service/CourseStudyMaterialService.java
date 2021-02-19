package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CourseStudyMaterialRepository;
import com.example.demo.model.CourseStudyMaterial;
 
@Service
@Transactional
public class CourseStudyMaterialService {
 
    @Autowired
    private CourseStudyMaterialRepository repo;
     
    public List<CourseStudyMaterial> listAll() {
        return repo.findAll();
    }
     
    public CourseStudyMaterial save(CourseStudyMaterial CourseStudyMaterial) {
        return repo.save(CourseStudyMaterial);
    }
     
    public CourseStudyMaterial get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}

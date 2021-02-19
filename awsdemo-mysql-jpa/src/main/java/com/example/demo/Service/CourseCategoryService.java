package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CourseCategoryRepository;
import com.example.demo.model.CourseCategory;
 
@Service
@Transactional
public class CourseCategoryService {
 
    @Autowired
    private CourseCategoryRepository repo;
     
    public List<CourseCategory> listAll() {
        return repo.findAll();
    }
     
    public CourseCategory save(CourseCategory CourseCategory) {
        return repo.save(CourseCategory);
    }
     
    public CourseCategory get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}

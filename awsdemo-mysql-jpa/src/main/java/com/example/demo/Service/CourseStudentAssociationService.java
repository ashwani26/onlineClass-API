package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CourseStudentAssociationRepository;
import com.example.demo.model.CourseStudentAssociation;
 
@Service
@Transactional
public class CourseStudentAssociationService {
 
    @Autowired
    private CourseStudentAssociationRepository repo;
     
    public List<CourseStudentAssociation> listAll() {
        return repo.findAll();
    }
     
    public CourseStudentAssociation save(CourseStudentAssociation CourseStudentAssociation) {
        return repo.save(CourseStudentAssociation);
    }
     
    public CourseStudentAssociation get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}

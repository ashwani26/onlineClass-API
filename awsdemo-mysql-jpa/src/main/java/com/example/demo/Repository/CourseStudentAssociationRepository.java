package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseStudentAssociation;

public interface CourseStudentAssociationRepository extends JpaRepository<CourseStudentAssociation, Long>  {

}

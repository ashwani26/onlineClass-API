package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseStudyMaterial;

public interface CourseStudyMaterialRepository extends JpaRepository<CourseStudyMaterial, Long> {

}

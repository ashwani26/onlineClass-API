package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseCategory;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long> {

}

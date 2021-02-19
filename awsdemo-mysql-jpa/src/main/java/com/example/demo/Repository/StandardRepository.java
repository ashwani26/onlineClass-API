package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseCategory;
import com.example.demo.model.Standard;

public interface StandardRepository extends JpaRepository<Standard, Long> {

}

package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudyMaterial;

public interface StudyMaterialRepository extends JpaRepository<StudyMaterial, Long> {

}

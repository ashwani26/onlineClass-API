package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FreeStudyMateral;

public interface FreeStudyMaterialRepository extends JpaRepository<FreeStudyMateral, Long>,FreeStudyMaterialRepositoryCustom  {

}

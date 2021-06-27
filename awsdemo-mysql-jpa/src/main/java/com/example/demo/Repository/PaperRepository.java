package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long>,PaperRepositoryCustom {

}

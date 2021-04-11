package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> ,ChapterRepositoryCustom {

}

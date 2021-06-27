package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.QuestionOption;

public interface OptionRepository extends JpaRepository<QuestionOption, Long> {

}

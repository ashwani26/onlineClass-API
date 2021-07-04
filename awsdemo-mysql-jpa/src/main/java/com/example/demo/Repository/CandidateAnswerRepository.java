package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CandidateAnswer;

public interface CandidateAnswerRepository extends JpaRepository<CandidateAnswer, Long> {

}

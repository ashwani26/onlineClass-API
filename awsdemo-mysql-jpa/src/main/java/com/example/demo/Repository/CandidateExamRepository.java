package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CandidateExam;

public interface CandidateExamRepository extends JpaRepository<CandidateExam, Long> {

	@Query("SELECT ce from CandidateExam ce where ce.fkPaperID=:fkPaperID and ce.fkUserID=:userID")
	public List<CandidateExam> getCandidateExamByUserAndPaperID(@Param("fkPaperID") long fkPaperID,@Param("userID") long userID);
	
	@Query("SELECT ce from CandidateExam ce where  ce.fkUserID=:userID")
	public List<CandidateExam> getStudentReport(@Param("userID") long userID);
	
}

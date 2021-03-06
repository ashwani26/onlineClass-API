package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FreeStudyMateral;

public interface FreeStudyMaterialRepositoryCustom {
	
	@Query("select fsm from FreeStudyMateral fsm  where fsm.fkTopicID=:fkTopicID")
	public List<FreeStudyMateral> getFreeStudyMaterialByTopicID(@Param("fkTopicID") long fkTopicID);

}

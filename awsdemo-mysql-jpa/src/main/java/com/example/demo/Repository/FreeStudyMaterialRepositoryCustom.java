package com.example.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FreeStudyMateral;

public interface FreeStudyMaterialRepositoryCustom {
	
	@Query("select fsm from FreeStudyMateral fsm  where fsm.fkTopicID=:fkTopicID")
	public FreeStudyMateral getFreeStudyMaterialByTopicID(@Param("fkTopicID") long fkTopicID);

}

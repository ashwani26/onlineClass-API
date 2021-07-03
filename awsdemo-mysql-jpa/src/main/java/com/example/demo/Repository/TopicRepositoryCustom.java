package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Topic;

public interface TopicRepositoryCustom {

	@Query("select t from Topic t  where  t.fkChapterID=:fkChapterID")
	public List<Topic> getListofTopicByChapterID(@Param("fkChapterID") long fkChapterID);
	
	@Query("select t from Topic t,FreeStudyMateral fsm  where t.topicID =fsm.fkTopicID and fsm.isPremium=0 and t.fkChapterID=:fkChapterID")
	public List<Topic> getListofTopicFreeStudyMaterialVailable(@Param("fkChapterID") long fkChapterID);
	
	@Query("select t from Topic t,FreeStudyMateral fsm  where t.topicID =fsm.fkTopicID and fsm.isPremium=1 and t.fkChapterID=:fkChapterID")
	public List<Topic> getListofTopicPremiumStudyMaterialVailable(@Param("fkChapterID") long fkChapterID);
}

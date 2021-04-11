package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Topic;

public interface TopicRepositoryCustom {

	@Query("select t from Topic t  where t.fkChapterID=:fkChapterID")
	public List<Topic> getListofTopicByChapterID(@Param("fkChapterID") long fkChapterID);
}

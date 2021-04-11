package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> , TopicRepositoryCustom {

}

package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chapter;
import com.example.demo.model.LiveClassScheduleDetails;

public interface LiveClassScheduleDetailsRepository extends JpaRepository<LiveClassScheduleDetails, Long>  {

}

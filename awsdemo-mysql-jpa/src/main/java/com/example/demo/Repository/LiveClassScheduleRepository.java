package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LiveClassSchedule;

public interface LiveClassScheduleRepository extends JpaRepository<LiveClassSchedule, Long> ,LiveClassScheduleRepositoryCustom{
	
	

}

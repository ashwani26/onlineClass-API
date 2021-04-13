package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//add new
@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class AwsdemoMysqlJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsdemoMysqlJpaApplication.class, args);
	}

}

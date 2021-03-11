package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO User (USERNAME, AGE, CREATED_DATE) VALUES (?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, "Frank", 43, "2021-03-10");
		
		if (result > 0) {
			System.out.print("New row Created");
		}
	}

}

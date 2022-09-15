package com.udacity.jdnd.course3.critter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.udacity.jdnd.course3.critter.mapper.Mapper;
import com.udacity.jdnd.course3.critter.mapper.MapperImpl;

/**
 * Launches the Spring application. Unmodified from starter code.
 */
@SpringBootApplication
public class CritterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CritterApplication.class, args);
	}
	
	@Bean
	public Mapper mapper() {
		return new MapperImpl();
	}

}

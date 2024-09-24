package com.infybuzz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan({"com.infybuzz.controller", "com.infybuzz.service",
		"com.infybuzz.security"})
@EntityScan("com.infybuzz.entity")
@EnableJpaRepositories("com.infybuzz.repository")
@EnableGlobalMethodSecurity(prePostEnabled = true) //Global method level security
public class ProfessorAppApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String pass=bcrypt.encode("hari123");
		SpringApplication.run(ProfessorAppApplication.class, args);
	}

}

package com.myportal.my_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPortalApplication.class, args);
	}

	// ⭐ BCrypt Bean (Spring-managed)
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

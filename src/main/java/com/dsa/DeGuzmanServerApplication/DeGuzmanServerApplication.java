package com.dsa.DeGuzmanServerApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public class DeGuzmanServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeGuzmanServerApplication.class, args);
		int port = 8080;
		System.out.println("Application running on port: " + port);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMapping(CorsRegistry registry ) {
				registry.addMapping("/app/contact-book/all").allowedOrigins("http://localhost/3000");
			}
		};
	}
}

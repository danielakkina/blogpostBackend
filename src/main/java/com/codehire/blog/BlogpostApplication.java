package com.codehire.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;




@SpringBootApplication
public class BlogpostApplication {
	@PostConstruct
	public void printEnv() {
		System.out.println("🟡 JDBC_DATABASE_URL = " + System.getenv("JDBC_DATABASE_URL"));
		System.out.println("🟡 JDBC_DATABASE_USERNAME = " + System.getenv("JDBC_DATABASE_USERNAME"));
		System.out.println("🟡 JDBC_DATABASE_PASSWORD = " + System.getenv("JDBC_DATABASE_PASSWORD"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogpostApplication.class, args);
	}

}

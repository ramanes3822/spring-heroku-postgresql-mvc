package com.ram.productDemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductDemoApplication {

	@Value("${Postgres.DATABASE_URL}")
	private static String databaseUrl;

	public static void main(String[] args) {

		SpringApplication.run(ProductDemoApplication.class, args);
	}

	@PostConstruct
	public void printDatabaseUrl() {
		System.out.println("Resolved Postgres Database URL: " + databaseUrl);
	}

}

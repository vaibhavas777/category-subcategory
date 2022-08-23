package com.abacus.categorysubcategory;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableWebSecurity
@EnableTransactionManagement
public class CategoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(CategoryApplication.class, args);


	}

}

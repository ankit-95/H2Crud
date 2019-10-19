package com.h2.H2Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "com.h2.*" })
@EnableJpaRepositories("com.h2.*")
@EntityScan("com.h2.*")   
@SpringBootApplication
public class H2CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2CrudApplication.class, args);
	}

}

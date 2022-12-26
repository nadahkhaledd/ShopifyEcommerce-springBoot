package com.example.EcommerceWithSpringDataJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com/example/EcommerceWithSpringDataJpa.*" })
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
public class ECommerceWithSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceWithSpringDataJpaApplication.class, args);
	}

}

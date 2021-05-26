package com.secbro2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan(basePackages = "com.controller")
//@ComponentScan(resourcePattern = "../*.class")
public class HelloWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWordApplication.class, args);
	}

}

package com.javatpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudOperationApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootCrudOperationApplication.class);


	public static void main(String[] args) {
		logger.info("This is a info message");
		logger.warn("This is warn message");
		logger.error("This is a error message");
		
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}

}

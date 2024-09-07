package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsSpringbootApplication.class, args);
		System.out.println("Hello it is running on jenkins");
		System.out.println("Automatic build 2");
		System.out.println("Running on docker");
	}

}

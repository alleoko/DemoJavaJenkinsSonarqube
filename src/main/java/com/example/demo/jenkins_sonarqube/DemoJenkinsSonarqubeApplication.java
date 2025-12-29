package com.example.demo.jenkins_sonarqube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJenkinsSonarqubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJenkinsSonarqubeApplication.class, args);
		System.out.println("Hello, Jenkins and SonarQube!");
	}

}

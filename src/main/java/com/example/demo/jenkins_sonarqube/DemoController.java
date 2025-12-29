package com.example.demo.jenkins_sonarqube;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    
    @RequestMapping("/")
    public String home() {
        return "Welcome to the Jenkins and SonarQube Demo Application!";
    }
}

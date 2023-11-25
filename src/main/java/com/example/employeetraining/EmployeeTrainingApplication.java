package com.example.employeetraining;

import com.example.employeetraining.config.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
@EnableScheduling
public class EmployeeTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeTrainingApplication.class, args);
    }

}

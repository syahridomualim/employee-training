package com.example.employeetraining.repository;

import com.example.employeetraining.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}

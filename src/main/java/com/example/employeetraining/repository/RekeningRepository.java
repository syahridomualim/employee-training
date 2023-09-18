package com.example.employeetraining.repository;

import com.example.employeetraining.model.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RekeningRepository extends JpaRepository<Rekening, Integer> {
}

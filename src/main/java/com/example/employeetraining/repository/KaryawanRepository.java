package com.example.employeetraining.repository;

import com.example.employeetraining.model.entity.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, Integer>{

}

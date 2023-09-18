package com.example.employeetraining.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class DateBase {
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "deleted_date")
    private Date deletedDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}

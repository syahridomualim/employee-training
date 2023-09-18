package com.example.employeetraining.model.request;


import com.example.employeetraining.model.entity.DetailKaryawan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
public class UpdateKaryawanRequest {

    private Integer id;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @NotNull(message = "dob tidak boleh kosong")
    private Date dob;

    @NotBlank(message = "status tidak boleh kosong")
    private String status;

    @NotBlank(message = "alamat tidak boleh kosong")
    private String alamat;

    private UpdateDetailKaryawanRequest detailKaryawan;

}

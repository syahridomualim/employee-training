package com.example.employeetraining.model.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

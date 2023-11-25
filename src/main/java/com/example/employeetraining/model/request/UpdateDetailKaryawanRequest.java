package com.example.employeetraining.model.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateDetailKaryawanRequest {

    @NotBlank(message = "id tidak boleh kosong")
    private Integer id;

    @NotNull(message = "nik tidak boleh kosong")
    private String nik;

    @NotNull(message = "npwp tidak boleh kosong")
    private String npwp;
}

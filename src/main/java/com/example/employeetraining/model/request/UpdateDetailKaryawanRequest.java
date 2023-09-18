package com.example.employeetraining.model.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDetailKaryawanRequest {

    @NotBlank(message = "id tidak boleh kosong")
    private Integer id;
    @NotNull(message = "nik tidak boleh kosong")
    private String nik;

    @NotNull(message = "npwp tidak boleh kosong")
    private String npwp;
}

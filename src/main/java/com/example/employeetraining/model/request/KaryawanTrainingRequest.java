package com.example.employeetraining.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class KaryawanTrainingRequest {
    private IdRequest karyawan;
    private IdRequest training;
    @NotNull(message = "tanggal tidak boleh kosong")
    private Date tanggal;

}

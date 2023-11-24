package com.example.employeetraining.model.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class KaryawanTrainingRequest {

    @NotNull(message = "id karyawan tidak boleh kosong")
    private IdRequest karyawan;
    @NotNull(message = "id training tidak boleh kosong")
    private IdRequest training;
    @NotNull(message = "tanggal tidak boleh kosong")
    private Date tanggal;

}

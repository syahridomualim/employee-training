package com.example.employeetraining.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RekeningRequest {
    @NotNull(message = "nama tidak boleh kosong")
    private String nama;
    @NotNull(message = "rekening tidak boleh kosong")
    private String jenis;
    @NotNull(message = "nomor rekening tidak boleh kosong")
    private String rekening;
    @NotNull(message = "alamat harus diisi")
    private String alamat;
    private IdRequest karyawan;
}

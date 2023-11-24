package com.example.employeetraining.model.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrainingRequest {

    @NotNull(message = "tema tidak boleh kosong")
    private String tema;
    @NotNull(message = "pengajar tidak boleh kosong")
    private String pengajar;

}

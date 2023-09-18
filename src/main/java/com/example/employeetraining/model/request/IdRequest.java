package com.example.employeetraining.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IdRequest {
    @NotNull(message = "Id tidak boleh kosong")
    private Integer id;
}

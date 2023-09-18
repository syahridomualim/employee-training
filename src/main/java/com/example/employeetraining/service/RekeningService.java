package com.example.employeetraining.service;

import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.RekeningRequest;
import com.example.employeetraining.model.request.UpdateRekeningRequest;
import com.example.employeetraining.model.response.RekeningResponse;
import org.springframework.data.domain.Page;

public interface RekeningService {
    RekeningResponse insertRekening(RekeningRequest rekeningRequest);
    RekeningResponse getRekening(int id);
    RekeningResponse updateRekening(UpdateRekeningRequest updateRekeningRequest);
    void deleteRekening(IdRequest idRequest);
    Page<RekeningResponse> getAllRekening(int page, int size);
}

package com.example.employeetraining.service;

import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.KaryawanTrainingRequest;
import com.example.employeetraining.model.request.UpdateKaryawanTrainingRequest;
import com.example.employeetraining.model.response.KaryawanTrainingResponse;
import org.springframework.data.domain.Page;

public interface KaryawanTrainingService {
    KaryawanTrainingResponse insertKaryawanTraining(KaryawanTrainingRequest trainingRequest);

    KaryawanTrainingResponse getKaryawanTraining(int id);

    KaryawanTrainingResponse updateKaryawanTraining(UpdateKaryawanTrainingRequest updateKaryawanTrainingRequest);

    Page<KaryawanTrainingResponse> getAllKaryawanTraining(int page, int size);

    void deleteKaryawanTraining(IdRequest idRequest);

}

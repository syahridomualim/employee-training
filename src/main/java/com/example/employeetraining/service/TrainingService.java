package com.example.employeetraining.service;

import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.TrainingRequest;
import com.example.employeetraining.model.request.UpdateTrainingRequest;
import com.example.employeetraining.model.response.TrainingResponse;
import org.springframework.data.domain.Page;

public interface TrainingService {
    TrainingResponse insertTraining(TrainingRequest trainingRequest);
    TrainingResponse getTraining(Integer id);
    TrainingResponse updateTraining(UpdateTrainingRequest updateTrainingRequest);
    Page<TrainingResponse> getTrainings(int page, int size);
    void deleteTraining(IdRequest idRequest);
}

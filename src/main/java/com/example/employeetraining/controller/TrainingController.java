package com.example.employeetraining.controller;

import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.TrainingRequest;
import com.example.employeetraining.model.request.UpdateTrainingRequest;
import com.example.employeetraining.model.response.GeneralResponse;
import com.example.employeetraining.model.response.TrainingResponse;
import com.example.employeetraining.service.TrainingService;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trainings")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public GeneralResponse<TrainingResponse> insertTraining(@RequestBody @Valid TrainingRequest trainingRequest) {
        TrainingResponse trainingResponse = trainingService.insertTraining(trainingRequest);
        return new GeneralResponse<>(
                200,
                trainingResponse,
                "sukses"
        );
    }

    @GetMapping("/{id}")
    public GeneralResponse<TrainingResponse> getTraining(@PathVariable("id") int id) {
        TrainingResponse trainingResponse = trainingService.getTraining(id);
        return new GeneralResponse<>(
                200,
                trainingResponse,
                "sukses"
        );
    }

    @PutMapping
    public GeneralResponse<TrainingResponse> updateTraining(@RequestBody @Valid UpdateTrainingRequest updateTrainingRequest) {
        TrainingResponse trainingResponse = trainingService.updateTraining(updateTrainingRequest);
        return new GeneralResponse<>(
                200,
                trainingResponse,
                "sukses"
        );
    }

    @GetMapping
    public GeneralResponse<Page<TrainingResponse>> getAllTraining(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<TrainingResponse> trainingResponses = trainingService.getTrainings(page, size);
        return new GeneralResponse<>(
                200,
                trainingResponses,
                "sukses"
        );
    }

    @DeleteMapping
    public GeneralResponse<String> deleteTraining(@RequestBody @Valid IdRequest idRequest) {
        trainingService.deleteTraining(idRequest);
        return new GeneralResponse<>(
                200,
                "Sukses",
                "sukses"
        );
    }
}


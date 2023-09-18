package com.example.employeetraining.service.impl;

import com.example.employeetraining.model.entity.DetailKaryawan;
import com.example.employeetraining.model.entity.Karyawan;
import com.example.employeetraining.model.entity.KaryawanTraining;
import com.example.employeetraining.model.entity.Training;
import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.KaryawanTrainingRequest;
import com.example.employeetraining.model.request.UpdateKaryawanTrainingRequest;
import com.example.employeetraining.model.response.DetailKaryawanResponse;
import com.example.employeetraining.model.response.KaryawanResponse;
import com.example.employeetraining.model.response.KaryawanTrainingResponse;
import com.example.employeetraining.model.response.TrainingResponse;
import com.example.employeetraining.repository.KaryawanRepository;
import com.example.employeetraining.repository.KaryawanTrainingRepository;
import com.example.employeetraining.repository.TrainingRepository;
import com.example.employeetraining.service.KaryawanTrainingService;
import com.example.employeetraining.util.ItemByIdOrThrow;
import com.example.employeetraining.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KaryawanTrainingImpl implements KaryawanTrainingService {

    private final KaryawanRepository karyawanRepository;
    private final TrainingRepository trainingRepository;
    private final KaryawanTrainingRepository karyawanTrainingRepository;
    private final ValidationUtil validationUtil;
    private final ItemByIdOrThrow itemByIdOrThrow;

    @Override
    public KaryawanTrainingResponse insertKaryawanTraining(KaryawanTrainingRequest trainingRequest) {
        validationUtil.validate(trainingRequest);
        Karyawan karyawan = findKaryawanByIdOrThrow(trainingRequest.getKaryawan().getId());
        Training training = findTrainingByIdOrThrow(trainingRequest.getTraining().getId());
        KaryawanTraining karyawanTraining = new KaryawanTraining(
                trainingRequest.getTanggal(),
                karyawan,
                training,
                new Date()
        );

        KaryawanTraining karyawanRepo = karyawanTrainingRepository.save(karyawanTraining);
        log.info("Successfully saved karyawan training");
        return convertToResponse(karyawanRepo);
    }

    @Override
    public KaryawanTrainingResponse getKaryawanTraining(int id) {
        KaryawanTraining karyawanTraining = findKaryawanTrainingByIdOrThrow(id);
        log.info("Successfully get karyawan training with id {}", id);
        return convertToResponse(karyawanTraining);
    }

    @Override
    public KaryawanTrainingResponse updateKaryawanTraining(UpdateKaryawanTrainingRequest updateKaryawanTrainingRequest) {
        validationUtil.validate(updateKaryawanTrainingRequest);
        KaryawanTraining karyawanTraining = findKaryawanTrainingByIdOrThrow(updateKaryawanTrainingRequest.getId());
        Karyawan karyawan = findKaryawanByIdOrThrow(updateKaryawanTrainingRequest.getKaryawan().getId());
        Training training = findTrainingByIdOrThrow(updateKaryawanTrainingRequest.getTraining().getId());

        // update karyawan training field
        karyawanTraining.setKaryawan(karyawan);
        karyawanTraining.setTraining(training);
        karyawanTraining.setTanggal(updateKaryawanTrainingRequest.getTanggal());
        karyawanTraining.setUpdatedDate(new Date());

        karyawanTrainingRepository.save(karyawanTraining);
        log.info("Sucessfully updated karyawan training");
        return convertToResponse(karyawanTraining);
    }

    @Override
    public Page<KaryawanTrainingResponse> getAllKaryawanTraining(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<KaryawanTrainingResponse> karyawanTrainings = karyawanTrainingRepository.findAll(pageable).getContent().stream().map(this::convertToResponse).toList();
        log.info("Successfully get all karyawan training");
        return new PageImpl<>(karyawanTrainings);
    }

    @Override
    public void deleteKaryawanTraining(IdRequest idRequest) {
        validationUtil.validate(idRequest);
        KaryawanTraining karyawanTraining = findKaryawanTrainingByIdOrThrow(idRequest.getId());
        log.info("Deleted karyawan training with id {}", karyawanTraining.getId());
        karyawanTrainingRepository.delete(karyawanTraining);
    }

    private Karyawan findKaryawanByIdOrThrow(int id) {
        return itemByIdOrThrow.findKaryawanByIdOrThrow(karyawanRepository, id);
    }

    private KaryawanTraining findKaryawanTrainingByIdOrThrow(int id) {
        return itemByIdOrThrow.findKaryawanTrainingByIdOrThrow(karyawanTrainingRepository, id);
    }

    private Training findTrainingByIdOrThrow(int id) {
        return itemByIdOrThrow.findTrainingByIdOrThrow(trainingRepository, id);
    }

    private KaryawanTrainingResponse convertToResponse(KaryawanTraining karyawanTraining) {

        Karyawan karyawan = karyawanTraining.getKaryawan();
        DetailKaryawan detailKaryawan = karyawan.getDetailKaryawan();
        Training training = karyawanTraining.getTraining();

        KaryawanResponse karyawanResponse = new KaryawanResponse(
                karyawanTraining.getCreatedDate(),
                karyawanTraining.getUpdatedDate(),
                karyawanTraining.getDeletedDate(),
                karyawan.getId(),
                karyawan.getNama(),
                karyawan.getDob(),
                karyawan.getStatus(),
                karyawan.getAlamat(),
                new DetailKaryawanResponse(
                        detailKaryawan.getCreatedDate(),
                        detailKaryawan.getDeletedDate(),
                        detailKaryawan.getUpdatedDate(),
                        detailKaryawan.getId(),
                        detailKaryawan.getNik(),
                        detailKaryawan.getNpwp()
                )
        );

        TrainingResponse trainingResponse = new TrainingResponse(
                karyawanTraining.getTraining().getCreatedDate(),
                karyawanTraining.getUpdatedDate(),
                karyawanTraining.getDeletedDate(),
                training.getId(),
                training.getTema(),
                training.getPengajar()
        );

        return new KaryawanTrainingResponse(
                karyawanTraining.getCreatedDate(),
                karyawanTraining.getUpdatedDate(),
                karyawanTraining.getDeletedDate(),
                karyawanTraining.getId(),
                karyawanResponse,
                trainingResponse,
                karyawanTraining.getTanggal()
        );
    }
}

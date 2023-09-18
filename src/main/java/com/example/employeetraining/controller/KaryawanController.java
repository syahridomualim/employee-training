package com.example.employeetraining.controller;

import com.example.employeetraining.model.request.IdRequest;
import com.example.employeetraining.model.request.KaryawanRequest;
import com.example.employeetraining.model.request.UpdateKaryawanRequest;
import com.example.employeetraining.model.response.GeneralResponse;
import com.example.employeetraining.model.response.KaryawanResponse;
import com.example.employeetraining.service.KaryawanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/karyawans")
@RequiredArgsConstructor
public class KaryawanController {

    private final KaryawanService karyawanService;

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public GeneralResponse<KaryawanResponse> insertKaryawan(@RequestBody @Valid KaryawanRequest karyawanRequest) {
        KaryawanResponse karyawanResponse = karyawanService.insertKaryawan(karyawanRequest);

        return new GeneralResponse<>(
                200,
                karyawanResponse,
                "sukses"
        );
    }

    @GetMapping("/{id}")
    public GeneralResponse<KaryawanResponse> getKaryawan(@PathVariable("id") Integer id) {
        KaryawanResponse karyawanResponse = karyawanService.getKaryawan(id);

        return new GeneralResponse<>(
                200,
                karyawanResponse,
                "sukses"
        );
    }

    @PutMapping
    public GeneralResponse<KaryawanResponse> updateKaryawan(@RequestBody @Valid UpdateKaryawanRequest updateKaryawanRequest) {
        KaryawanResponse karyawanResponse = karyawanService.updateKaryawan(updateKaryawanRequest);
        return new GeneralResponse<>(
                200,
                karyawanResponse,
                "sukses"
        );
    }

    @GetMapping
    public GeneralResponse<Page<KaryawanResponse>> getAllKaryawan(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<KaryawanResponse> karyawanResponse = karyawanService.getAllKaryawan(page, size);
        return new GeneralResponse<>(
                200,
                karyawanResponse,
                "sukses"
        );
    }

    @DeleteMapping
    public GeneralResponse<String> deleteKaryawan(@RequestBody @Valid IdRequest idRequest) {
        karyawanService.deleteKaryawan(idRequest);
        return new GeneralResponse<>(
                200,
                "Sukses",
                "sukses"
        );
    }
}

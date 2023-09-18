package com.example.employeetraining.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "karyawan")
public class Karyawan extends DateBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "status")
    private String status;

    @Column(name = "alamat")
    private String alamat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "karyawan_id", referencedColumnName = "id")
    private DetailKaryawan detailKaryawan;

    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private Set<Training> trainings = new HashSet<>();

    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private Set<KaryawanTraining> karyawanTrainings = new HashSet<>();

    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private Set<Rekening> rekening = new HashSet<>();

    public Karyawan(String nama, Date dob, String status, String alamat, DetailKaryawan detailKaryawan, Date createdDate) {
        this.nama = nama;
        this.dob = dob;
        this.status = status;
        this.alamat = alamat;
        this.detailKaryawan = detailKaryawan;
        this.setCreatedDate(createdDate);
    }

}


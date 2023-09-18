package com.example.employeetraining.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "training")
public class Training extends DateBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tema")
    private String tema;

    @Column(name = "pengajar")
    private String pengajar;

    @ManyToOne
    @JoinColumn(name = "karyawan_id", referencedColumnName = "id")
    private Karyawan karyawan;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private Set<KaryawanTraining> karyawanTrainings = new HashSet<>();

    public Training(String tema, String pengajar, Date createdDate) {
        this.tema = tema;
        this.pengajar = pengajar;
        this.setCreatedDate(createdDate);
    }
}

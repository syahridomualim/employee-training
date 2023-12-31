package com.example.employeetraining.model.entity.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "oauth_role_path")
@Getter
@Setter
public class OAuthRolePath implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    private String pattern;
    private String method;
    @ManyToOne(targetEntity = OAuthRole.class, cascade = CascadeType.ALL)
    @JsonIgnore
    private OAuthRole role;
}

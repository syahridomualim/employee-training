package com.example.employeetraining.model.entity.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oauth_role", uniqueConstraints = {@UniqueConstraint(name = "role_name_and_type", columnNames = {"type", "name"})})
@Getter
@Setter
public class OAuthRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String name;
    private String type;
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OAuthRolePath> rolePaths;
    @JsonIgnore
    @ManyToMany(targetEntity = OAuthUser.class, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<OAuthUser> users;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.name;
    }
}

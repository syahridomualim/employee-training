package com.example.employeetraining.model.entity.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "oauth_user")
@Getter
@Setter
public class OAuthUser implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, unique = true)
    private String username;
    @Column(length = 100)
    private String fullName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String verifyToken;
    @JsonIgnore
    private Date expiredVerifyToken;
    @Column(length = 100)
    private String otp;
    private Date otpExpiredDate;
    @JsonIgnore
    private boolean enabled = true;
    @JsonIgnore
    @Column(name = "not_expired")
    private boolean accountNonExpired = true;
    @JsonIgnore
    @Column(name = "not_locked")
    private boolean accountNonLocked = true;
    @JsonIgnore
    @Column(name = "credential_not_expired")
    private boolean credentialsNonExpired = true;

    @ManyToMany(targetEntity = OAuthRole.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "oauth_user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<OAuthRole> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

package com.example.employeetraining.repository.oauth;

import com.example.employeetraining.model.entity.oauth.OAuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OAuthRoleRepository extends JpaRepository<OAuthRole, Long> {
    OAuthRole findOneByName(String name);
    List<OAuthRole> findByNameIn(Collection<String> name);
}

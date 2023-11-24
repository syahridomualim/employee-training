package com.example.employeetraining.repository.oauth;

import com.example.employeetraining.model.entity.oauth.OAuthRolePath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthRolePathRepository extends JpaRepository<OAuthRolePath, Long> {
    OAuthRolePath findOneByName(String rolePathName);
}

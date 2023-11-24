package com.example.employeetraining.repository.oauth;

import com.example.employeetraining.model.entity.oauth.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthClientRepository extends JpaRepository<OAuthClient, Long> {
    OAuthClient findOneByClientId(String clientId);
}

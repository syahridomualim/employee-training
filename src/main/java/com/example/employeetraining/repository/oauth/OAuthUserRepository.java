package com.example.employeetraining.repository.oauth;

import com.example.employeetraining.model.entity.oauth.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {
    OAuthUser findOneByUsername(String username);

    @Query("FROM OAuthUser u WHERE u.otp = ?1")
    OAuthUser findOneByOTP(String otp);

    @Query("FROM OAuthUser u WHERE LOWER(u.username) = LOWER(:username)")
    OAuthUser checkExistingEmail(String username);
}

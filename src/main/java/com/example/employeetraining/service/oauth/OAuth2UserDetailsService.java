package com.example.employeetraining.service.oauth;

import com.example.employeetraining.model.entity.oauth.OAuthUser;
import com.example.employeetraining.repository.oauth.OAuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2UserDetailsService implements UserDetailsService {

    private final OAuthUserRepository oAuthUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OAuthUser oAuthUser = oAuthUserRepository.findOneByUsername(username);
        if (oAuthUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }
        return oAuthUser;
    }

    @CacheEvict("oauth_username")
    public void clearCache(String s) {
    }
}

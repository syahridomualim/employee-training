package com.example.employeetraining.config;

import com.example.employeetraining.repository.oauth.OAuthUserRepository;
import com.example.employeetraining.service.oauth.OAuth2UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
@RequiredArgsConstructor
@SuppressWarnings({"unchecked", "deprecation"})
public class Oauth2AccessTokenConverter extends DefaultAccessTokenConverter {

    private final OAuthUserRepository oAuthUserRepository;
    private final OAuth2UserDetailsService oAuth2UserDetailsService;

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        final OAuth2Authentication authentication = super.extractAuthentication(map);
        final UserDetails userDetails = oAuth2UserDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        return new OAuth2Authentication(authentication.getOAuth2Request(), authentication.getUserAuthentication()) {
            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                if (userDetails != null) {
                    return (Collection<GrantedAuthority>) userDetails.getAuthorities();
                }
                return authentication.getAuthorities();
            }
        };
    }
}
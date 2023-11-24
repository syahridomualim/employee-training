package com.example.employeetraining.service.oauth;

import com.example.employeetraining.repository.oauth.OAuthClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("deprecation")
public class OAuth2ClientDetailsService implements ClientDetailsService {

    private final OAuthClientRepository oAuthClientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        ClientDetails clientDetails = oAuthClientRepository.findOneByClientId(s);
        if (clientDetails == null) {
            throw new ClientRegistrationException("Client not found");
        }
        return clientDetails;
    }

    @CacheEvict("oauth_client_id")
    public void clearCache(String s) {
    }

}

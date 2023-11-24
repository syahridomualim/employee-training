package com.example.employeetraining.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Priority;


@Priority(1)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
@SuppressWarnings({"deprecation"})
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${security.bcrypt.cost:13}")
    private int cost;

    @Value("${security.jwt.enabled}")
    private boolean jwtEnabled;

    @Value("${security.jwt.secret_key}")
    private String jwtSecretKey;

    private final Oauth2AccessTokenConverter accessTokenConverter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(cost);
    }

    @Bean
    public TokenStore tokenStore() {
        if (jwtEnabled) {
            return new JwtTokenStore((JwtAccessTokenConverter) accessTokenConverter());
        }

        return new InMemoryTokenStore();
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        if (jwtEnabled) {
            JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
            tokenConverter.setAccessTokenConverter(this.accessTokenConverter);
            tokenConverter.setSigningKey(jwtSecretKey);

            return tokenConverter;
        }
        return new DefaultAccessTokenConverter();
    }

    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setTokenStore(tokenStore());
        services.setSupportRefreshToken(true);

        return services;
    }

}

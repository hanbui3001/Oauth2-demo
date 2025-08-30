package com.Oauth2_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {
    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests ->
                requests.requestMatchers("/login").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oAuth2LoginConfigurer ->
                {
                    oAuth2LoginConfigurer.defaultSuccessUrl("/profile")
                            .failureUrl("/login?error=true")
                            .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint.baseUri("/oauth2/authorize"))
                            .redirectionEndpoint(redirectionEndpoint -> redirectionEndpoint.baseUri("/login/oauth2/code/google"));
                })
                .build();
    }
}

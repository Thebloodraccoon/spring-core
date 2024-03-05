package org.hillel.spring.config;

import org.hillel.spring.enums.RoleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);

        security.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/ping").hasAnyAuthority(RoleType.ROLE_USER.name())
                .requestMatchers("/product/**").hasAnyAuthority(RoleType.ROLE_ADMIN.name())
                .anyRequest().authenticated()
        );

        security.httpBasic(Customizer.withDefaults());

        return security.build();
    }
}

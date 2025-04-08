package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuração para APIs sem CSRF
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/funcionarios/**").permitAll() // Permite acesso a APIs específicas
                        .anyRequest().authenticated()  // Requer autenticação para qualquer outra requisição
                )
                .httpBasic(); // Pode ser substituído por outras formas de autenticação, como JWT

        return http.build();
    }
}

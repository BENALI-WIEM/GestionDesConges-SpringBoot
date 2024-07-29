package com.rhc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Autoriser les origines spécifiques (remplacez par l'URL de votre frontend Angular)
        config.addAllowedOrigin("http://localhost:4200");

        // Autoriser les en-têtes
        config.addAllowedHeader("*");

        // Autoriser les méthodes
        config.addAllowedMethod("*");

        // Appliquer la configuration à toutes les requêtes
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
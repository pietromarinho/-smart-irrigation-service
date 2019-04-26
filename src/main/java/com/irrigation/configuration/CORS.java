package com.irrigation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 * Cross-Origin Resource Sharing
 * Specifies allowed domains, headers and HTTP methods
 */
@Configuration
public class CORS {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // All domains
        config.addAllowedOrigin(CorsConfiguration.ALL);

        // Alowed HTTP Methods
        config.addAllowedMethod(HttpMethod.OPTIONS.name());
        config.addAllowedMethod(HttpMethod.PATCH.name());
        config.addAllowedMethod(HttpMethod.GET.name());
        config.addAllowedMethod(HttpMethod.POST.name());
        config.addAllowedMethod(HttpMethod.PUT.name());
        config.addAllowedMethod(HttpMethod.DELETE.name());

        // Allowed Headers
        config.addAllowedHeader(CorsConfiguration.ALL);

        // Exposed Headers
        config.addExposedHeader(HttpHeaders.AUTHORIZATION);
        config.addExposedHeader("Error");
        config.addExposedHeader("X-CSRF-Token");

        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

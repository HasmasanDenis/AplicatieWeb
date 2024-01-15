package com.example.shop.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Specify the mapping for which CORS should be configured
                        .allowedOrigins("http://localhost:3000")  // Allow requests from this origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
                        .allowedHeaders("Origin", "Content-Type", "Authorization")  // Allow these headers
                        .allowCredentials(true);  // Allow credentials (e.g., cookies)
            }
        };
    }
}

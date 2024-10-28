package com.sulayman.todo.security;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer ConfigCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull @Nullable CorsRegistry registry) {
                if (registry != null) {
                    registry.addMapping("/api/**")
                            .allowedOrigins("http://localhost:4200")
                            .allowedMethods("GET", "POST", "PUT", "DELETE")
                            .allowedHeaders("*")
                            .allowCredentials(true);
                }
            }
        };
    }
}
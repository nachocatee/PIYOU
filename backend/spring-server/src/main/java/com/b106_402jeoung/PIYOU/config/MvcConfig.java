package com.b106_402jeoung.PIYOU.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // cors 허용
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/api")
                .allowedOriginPatterns("*")
                .allowedMethods("*");
    }
}
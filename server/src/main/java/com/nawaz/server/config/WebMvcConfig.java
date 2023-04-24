package com.nawaz.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@EnableWebSecurity

//web configurer to allow mapping towards the base URL
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("UI.BASE.URL")
	String UI_BASE_URL;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	System.out.println("inside addCorsMappings");
        registry
        		.addMapping("/api/v1/**")
                .allowedOrigins(UI_BASE_URL)
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);

    }    
}

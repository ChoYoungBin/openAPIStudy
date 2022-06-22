package com.multi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(APPLICATION_JSON)
                .favorParameter(true)
                .parameterName("output")
                .ignoreAcceptHeader(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photo/**")
                .addResourceLocations("file:///C:/temp2/photos/", "classpath:")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(1)))
                .setCachePeriod(86400);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/contacts/**")
                .allowedOrigins("http://client:8000", "http://jcornor.com:8000")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

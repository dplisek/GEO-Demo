package com.zentity.demo;

import com.zentity.demo.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    @EnableConfigurationProperties(ApiConfig.class)
    protected static class FilterConfiguration {

        @SuppressWarnings("SpringJavaAutowiringInspection")
        @Autowired
        private ApiConfig apiConfig;

        @Bean
        public Filter apiKeyFilter() {
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                    String key = request.getHeader(apiConfig.getHeaderName());
                    if (!apiConfig.getKey().equals(key)) {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Geo key header missing or incorrect.");
                        return;
                    }
                    filterChain.doFilter(request, response);
                }
            };
        }
    }
}

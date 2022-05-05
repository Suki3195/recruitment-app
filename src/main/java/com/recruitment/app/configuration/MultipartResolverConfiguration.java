package com.recruitment.app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartResolverConfiguration {

    @Value("${spring.http.multipart.max-file-size}")
    private Long maxFileSize;
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver  resolver = new CommonsMultipartResolver();
       resolver.setMaxUploadSize(maxFileSize);
        return resolver;
    }
}

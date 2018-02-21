package com.subbu.estore.configuration;

import com.subbu.estore.clients.FeignClientErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by subbu on 22/02/18.
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public FeignClientErrorDecoder userNotFoundDecoder() {
        return new FeignClientErrorDecoder();
    }
}
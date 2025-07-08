package com.eric.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

@Configuration
@ConfigurationProperties(prefix = "password2.settings") // Access a set of related secrets
public class ConfigPassword2 {

    private String value;
    
}

package com.eric.microservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

@Configuration
@ConfigurationProperties(prefix = "userid2.settings") 
public class ConfigUserID2 {

    private String value;

}


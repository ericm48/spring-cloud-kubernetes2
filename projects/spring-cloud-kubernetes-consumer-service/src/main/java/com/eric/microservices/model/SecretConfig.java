package com.eric.microservices.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class SecretConfig {
    private String userId;
    private String passWord;    
}

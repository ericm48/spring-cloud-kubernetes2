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
@ConfigurationProperties(prefix = "game.settings")

public class ConfigAsYamlGame {

    private Integer lives;
    private String enemiesName;    
    private boolean enemiesCheat;
    private String enemiesCheatLevel;
    private String secretCodePassphrase;
    private boolean secretCodeAllowed;
    private Integer secretCodeLives;


// games.properties: |-
// #
// # game.properties:
// #
// lives=88
// enemiesName=OnBoard_BigZombies
// enemiesCheat=true
// enemiesCheatLevel=OnBoard_NoGoodRotten
// secretCodePassphrase=OnBoard_UUDDLRLRBABAS
// secretCodeAllowed=true
// secretCodeLives=30

}

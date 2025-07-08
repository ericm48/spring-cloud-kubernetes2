package com.eric.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class GameConfig {

    private Integer lives;
    private String enemiesName;    
    private boolean enemiesCheat;
    private String enemiesCheatLevel;
    private String secretCodePassphrase;
    private boolean secretCodeAllowed;
    private Integer secretCodeLives;

}

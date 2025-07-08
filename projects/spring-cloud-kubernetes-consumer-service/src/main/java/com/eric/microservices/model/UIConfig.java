package com.eric.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter


public class UIConfig {

    private String colorGood;
    private String colorBad;
    private boolean allowTextMode;
    private String howNiceToLook;


}

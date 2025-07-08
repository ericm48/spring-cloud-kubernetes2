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
@ConfigurationProperties(prefix = "ui.settings")

public class ConfigAsYamlUI {

    private String colorGood;
    private String colorBad;
    private boolean allowTextMode;
    private String howNiceToLook;


// ui.settings: |-
//     #
//     # ui.settings
//     #
//     color.good=purple
//     color.bad=yellow
//     allow.textmode=true
//     how.nice.to.look=fairlyNice

}

package com.eric.microservices.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Configuration
public class SecretReaderService {

    // This is the path to the volume-file that has the userID.
    // Example: '/x-platform/secrets/TEST_USERID1'

    @Value("${SCK_FILE_USERID}")
    private String filePathUserID1;

    // This is the path to the volume-file that has the passWord.
    // Example: '/x-platform/secrets/TEST_PASSWORD1'

    @Value("${SCK_FILE_PASSWORD}")
    private String filePathPassword1;

    @Value("${SCK_EVAR_USERID}")
    private String enviromentVariableUserID1;

    @Value("${SCK_EVAR_PASSWORD}")
    private String enviromentVariablePassword1;

    @Autowired
    private ConfigUserID2 configUserID2;

    @Autowired    
    private ConfigPassword2 configPassword2;    

    public String getUserId1FromFile() throws IOException {

        String returnValue = null;

        if (filePathUserID1 != null) {

            log.debug("SecretReaderService.getUserId1FromFile() filePathUserID1: " + filePathUserID1);

            returnValue = new String(Files.readAllBytes(Paths.get(filePathUserID1)));
            log.debug("SecretReaderService.getUserId1FromFile() returnValue: " + returnValue);
        }

        return returnValue;
    }

    public String getPassword1FromFile() throws IOException {

        String returnValue = null;

        if (filePathPassword1 != null) {

            log.debug("SecretReaderService.getPassword1FromFile() filePathPassword1: " + filePathPassword1);

            returnValue = new String(Files.readAllBytes(Paths.get(filePathPassword1)));
            log.debug("SecretReaderService.getPassword1FromFile() returnValue: " + returnValue);
        }

        return returnValue;
    }
    
    public String getUserId1FromEnvironmentVariable() {
        
        log.debug("SecretReaderService.getUserId1FromEnvironmentVariable() eVar: SCK_EVAR_USERID");
        log.debug("SecretReaderService.getUserId1FromEnvironmentVariable() returnValue: " + enviromentVariableUserID1);
        
        return enviromentVariableUserID1;
    }

    public String getPassword1EnvironmentVariable() {

        log.debug("SecretReaderService.getPassword1EnvironmentVariable() eVar: SCK_EVAR_PASSWORD");
        log.debug("SecretReaderService.getPassword1EnvironmentVariable() returnValue: " + enviromentVariablePassword1);
        
        return enviromentVariablePassword1;        
    }

    public String getUserId2FromFile()
    {
        String returnValue = null;
        returnValue = configUserID2.getValue();
        log.debug("SecretReaderService.getUserId2FromFile() returnValue: " + returnValue);

        return (returnValue);
    }

    public String getPassword2FromFile()
    {
        String returnValue = null;
        returnValue = configPassword2.getValue();
        log.debug("SecretReaderService.getPassword2FromFile() returnValue: " + returnValue);

        return (returnValue);
    }

}
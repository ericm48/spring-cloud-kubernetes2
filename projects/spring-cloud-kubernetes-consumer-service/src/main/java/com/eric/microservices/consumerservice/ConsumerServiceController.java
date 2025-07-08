package com.eric.microservices.consumerservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.microservices.config.ConfigAsPropertiesTimeOut;
import com.eric.microservices.config.ConfigAsYamlGame;
import com.eric.microservices.config.ConfigAsYamlUI;
import com.eric.microservices.config.SecretReaderService;
import com.eric.microservices.model.GameConfig;
import com.eric.microservices.model.SecretConfig;
import com.eric.microservices.model.TimeoutConfig;
import com.eric.microservices.model.UIConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric Manley
 */

@Slf4j
@RestController
public class ConsumerServiceController {

	@Autowired
	private ConfigAsPropertiesTimeOut configAsPropertiesTimeOut;

	@Autowired
	private ConfigAsYamlGame configAsYamlGame;

	@Autowired
	private ConfigAsYamlUI configAsYamlUI;

	@Autowired
	private SecretReaderService secretReaderService;

	@GetMapping("/get-config/timeout")
	public ResponseEntity<TimeoutConfig> getTimeoutsConfiguration(){

		ResponseEntity<TimeoutConfig> returnValue = null;

		log.debug("ConfigConsumerController.getTimeoutConfiguration() Begins...");

		TimeoutConfig timeoutsConfig = new TimeoutConfig();

		if (configAsPropertiesTimeOut != null )
		{
			timeoutsConfig.setConnectionTimeoutMillis(configAsPropertiesTimeOut.getConnectionTimeoutMillis());
			timeoutsConfig.setReadTimeoutMillis(configAsPropertiesTimeOut.getReadTimeoutMillis());
			
			log.info("Retrieving TimeoutConfig [{}]", timeoutsConfig);
		}
		else
		{
			log.error("*** TimeoutConfig is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(timeoutsConfig);

		log.debug("ConfigConsumerController.getTimeoutConfiguration() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getTimeoutConfiguration() Ends...");		

		return (returnValue);
	}

	@GetMapping("/get-config/game")
	public ResponseEntity<GameConfig> getGameConfiguration(){

		ResponseEntity<GameConfig> returnValue = null;

		log.debug("ConfigConsumerController.getGameConfiguration() Begins...");

		GameConfig gameConfig = new GameConfig();

		if (configAsYamlGame != null )
		{
			gameConfig.setLives(configAsYamlGame.getLives());
			gameConfig.setEnemiesName(configAsYamlGame.getEnemiesName());
			gameConfig.setEnemiesCheatLevel(configAsYamlGame.getEnemiesCheatLevel());
			gameConfig.setSecretCodePassphrase(configAsYamlGame.getSecretCodePassphrase());
			gameConfig.setSecretCodeAllowed(configAsYamlGame.isSecretCodeAllowed());
			gameConfig.setSecretCodeLives(configAsYamlGame.getSecretCodeLives());
			
			log.info("Retrieving gameConfig [{}]", gameConfig);
		}
		else
		{
			log.error("*** GameConfig is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(gameConfig);

		log.debug("ConfigConsumerController.getGameConfiguration() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getGameConfiguration() Ends...");		

		return (returnValue);
	}

	@GetMapping("/get-config/ui")
	public ResponseEntity<UIConfig> getUIConfiguration(){

		ResponseEntity<UIConfig> returnValue = null;

		log.debug("ConfigConsumerController.getUIConfiguration() Begins...");

		UIConfig uiConfig = new UIConfig();

		if (configAsYamlUI != null )
		{
			uiConfig.setColorGood(configAsYamlUI.getColorGood());
			uiConfig.setColorBad(configAsYamlUI.getColorBad());			
			uiConfig.setAllowTextMode(configAsYamlUI.isAllowTextMode());			
			uiConfig.setHowNiceToLook(configAsYamlUI.getHowNiceToLook());			

			
			log.info("Retrieving uiConfig [{}]", uiConfig);
		}
		else
		{
			log.error("*** uiConfig is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(uiConfig);

		log.debug("ConfigConsumerController.getUIConfiguration() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getUIConfiguration() Ends...");		

		return (returnValue);
	}

	@GetMapping("/get-secret/from-evar")
	public ResponseEntity<SecretConfig> getSecretFromEnvironmentVariable(){

		ResponseEntity<SecretConfig> returnValue = null;

		log.debug("ConfigConsumerController.getSecretFromEnvironmentVariable() Begins...");

		SecretConfig secretConfig = new SecretConfig();

		if (secretReaderService != null )
		{
				secretConfig.setUserId(secretReaderService.getUserId1FromEnvironmentVariable());
				secretConfig.setPassWord(secretReaderService.getPassword1EnvironmentVariable());
				
				log.info("ConfigConsumerController.getSecretFromEnvironmentVariable() Retrieving secretConfig [{}]", secretConfig);
		}
		else
		{
			log.error("ConfigConsumerController.getSecretFromEnvironmentVariable() ***ERROR-ENCOUNTERED*** secretReaderService is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(secretConfig);

		log.debug("ConfigConsumerController.getSecretFromEnvironmentVariable() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getSecretFromEnvironmentVariable() Ends...");		

		return (returnValue);		
	}

	@GetMapping("/get-secret/from-file1")
	public ResponseEntity<SecretConfig> getSecretFromFile(){

		ResponseEntity<SecretConfig> returnValue = null;

		log.debug("ConfigConsumerController.getSecretFromFile() Begins...");

		SecretConfig secretConfig = new SecretConfig();

		if (secretReaderService != null )
		{
			try {

				secretConfig.setUserId(secretReaderService.getUserId1FromFile());
				secretConfig.setPassWord(secretReaderService.getPassword1FromFile());
				
				log.info("ConfigConsumerController.getSecretFromFile() Retrieving secretConfig [{}]", secretConfig);
			}
			catch(IOException ioex)
			{
				log.error("ConfigConsumerController.getSecretFromFile() ***IOExceptionEncountered*** Msg: " + ioex.getMessage());	
			}
		}
		else
		{
			log.error("ConfigConsumerController.getSecretFromFile() ***ERROR-ENCOUNTERED*** secretReaderService is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(secretConfig);

		log.debug("ConfigConsumerController.getSecretFromFile() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getSecretFromFile() Ends...");		

		return (returnValue);		
	}

	@GetMapping("/get-secret/from-file2")
	public ResponseEntity<SecretConfig> getSecretFromFile2(){

		ResponseEntity<SecretConfig> returnValue = null;

		log.debug("ConfigConsumerController.getSecretFromFile2() Begins...");

		SecretConfig secretConfig = new SecretConfig();

		if (secretReaderService != null )
		{

			secretConfig.setUserId(secretReaderService.getUserId2FromFile());
			secretConfig.setPassWord(secretReaderService.getPassword2FromFile());
			
			log.info("ConfigConsumerController.getSecretFromFile2() Retrieving secretConfig [{}]", secretConfig);
		}
		else
		{
			log.error("ConfigConsumerController.getSecretFromFile2() ***ERROR-ENCOUNTERED*** secretReaderService is NULL!!!!");
		}

		returnValue = ResponseEntity.ok(secretConfig);

		log.debug("ConfigConsumerController.getSecretFromFile2() returnValue: " + returnValue);		

		log.debug("ConfigConsumerController.getSecretFromFile2() Ends...");		

		return (returnValue);		
	}


}

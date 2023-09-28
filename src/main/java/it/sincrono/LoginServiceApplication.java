package it.sincrono;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(LoginServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("LoginService Inizializzato");
		SpringApplication.run(LoginServiceApplication.class, args);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			LOGGER.info("Applicazione in fase di chiusura, salvataggio dei log...");
			LogManager.shutdown(); // This will flush and close all loggers
		}));

	}

}

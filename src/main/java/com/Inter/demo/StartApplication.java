package com.Inter.demo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class StartApplication {

	public static Logger log = Logger.getLogger(StartApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);

	URL propertiesUrl = StartApplication.class.getResource("/log4j.properties");
    if (propertiesUrl == null) {
		//Hide no appender warning
		Logger.getRootLogger().setLevel(Level.OFF);
		log.info("Load default logger properties");
	}

    log.info("Main method is started.");

}

}

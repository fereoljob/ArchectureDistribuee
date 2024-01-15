package com.example.archi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.archi.infra.tools.SalesforceJSONHandler;

@SpringBootApplication
@EnableConfigurationProperties(SalesforceJSONHandler.class)
public class ArchiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchiApplication.class, args);
	}

}

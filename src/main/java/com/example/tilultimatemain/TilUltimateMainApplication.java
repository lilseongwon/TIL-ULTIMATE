package com.example.tilultimatemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TilUltimateMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TilUltimateMainApplication.class, args);
	}

}

package com.nationwide.coatsn.bearboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BearBootApplication {
	private static final Logger log = LoggerFactory.getLogger(BearBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BearBootApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner testUUID() {
	// return (args) -> {
	// RestTemplate restTemplate = new RestTemplate();
	// GUID guid = restTemplate.getForObject("http://httpbin.org/uuid",
	// GUID.class);
	// log.info(guid.toString());
	// };
	// }

	@Bean
	public CommandLineRunner startInfo() {
		return (args) -> {
			log.info("started up...");
		};
	}
}
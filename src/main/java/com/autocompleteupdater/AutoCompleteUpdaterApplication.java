package com.autocompleteupdater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
@EnableScheduling
@EnableKafka
public class AutoCompleteUpdaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCompleteUpdaterApplication.class, args);
	}

}

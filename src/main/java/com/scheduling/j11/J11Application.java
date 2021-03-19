package com.scheduling.j11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories;

@SpringBootApplication
@EnableDatastoreRepositories
public class J11Application {

	public static void main(String[] args) {
		SpringApplication.run(J11Application.class, args);
	}

}

package com.mudl.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class MudlWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudlWebApplication.class, args);
	}

}

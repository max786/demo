package com.amilop.code.amilop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmilopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmilopApplication.class, args);
	}
}

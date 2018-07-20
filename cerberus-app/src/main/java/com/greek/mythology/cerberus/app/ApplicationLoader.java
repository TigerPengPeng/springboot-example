package com.greek.mythology.cerberus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApplicationLoader {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLoader.class, args);
	}
}

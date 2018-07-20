package com.greek.mythology.cerberus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.greek.mythology.cerberus")
public class ApplicationLoader {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLoader.class, args);
	}
}

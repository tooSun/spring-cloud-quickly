package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 *
 *
 * @author hlb
 * @date 2020/6/10 16:13
 *
 */
@SpringBootApplication
@EnableWebFlux
public class UserServiceApp {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApp.class, args);

	}

}

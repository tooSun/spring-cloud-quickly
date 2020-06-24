package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 16:51
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableWebFlux
public class WebFrontApp {

	public static void main(String[] args) {

		SpringApplication.run(WebFrontApp.class, args);

	}

}

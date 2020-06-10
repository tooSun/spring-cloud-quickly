package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 *
 * @author hlb
 * @date 2020/6/10 15:31
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class BingEurekaServerApp {

	public static void main(String[] args) {

		SpringApplication.run(BingEurekaServerApp.class, args);

	}

}

package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 *
 * @author hlb
 * @date 2020/6/10 17:07
 *
 */
@SpringBootApplication
@EnableConfigServer
public class BingConfigApp {

	public static void main(String[] args) {

		SpringApplication.run(BingConfigApp.class, args);

	}

}

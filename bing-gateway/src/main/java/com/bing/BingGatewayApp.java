package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 *
 * @author hlb
 * @date 2020/7/10 17:00
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BingGatewayApp {

	public static void main(String[] args) {

		SpringApplication.run(BingGatewayApp.class, args);
	}

}

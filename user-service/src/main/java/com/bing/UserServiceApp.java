package com.bing;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author hlb
 * @date 2020/6/10 16:13
 *
 */
@SpringBootApplication
public class UserServiceApp {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(UserServiceApp.class, args);

		System.in.read();

	}

}

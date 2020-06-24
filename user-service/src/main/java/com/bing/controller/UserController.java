package com.bing.controller;

import com.bing.common.bean.BingResponse;
import com.bing.service.UserServiceImpl;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 16:33
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/get/user")
	public BingResponse getUser(){

		BingResponse bingResponse = new BingResponse();

		Object user = userService.getUser();

		bingResponse.setData(user);

		return bingResponse;
	}

}

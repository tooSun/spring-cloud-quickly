package com.bing.controller;

import java.util.List;
import java.util.Map;

import com.bing.common.bean.BingResponse;
import com.bing.feign.UserFeign;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 17:09
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserFeign userFeign;

	@GetMapping("/get/user")
	public Mono getUser(){

		BingResponse bingResponse = userFeign.getUser();

		return Mono.just(bingResponse);
	}

}

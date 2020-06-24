package com.bing.service;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 14:12
 *
 */
@Service
public class UserServiceImpl {

	@Value("${user.name}")
	private String name;

	public Object getUser(){

		Map<String, String> map = new HashMap<>();
		map.put("name", name);

		return JSON.toJSON(map);

	}

}

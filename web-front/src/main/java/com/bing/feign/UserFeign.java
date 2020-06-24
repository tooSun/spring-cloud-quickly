package com.bing.feign;

import java.util.Map;

import com.bing.common.bean.BingResponse;
import reactor.core.publisher.Flux;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 17:08
 *
 */
@FeignClient(name = "user-service")
public interface UserFeign {

	@PostMapping("/get/user")
	BingResponse getUser();

}

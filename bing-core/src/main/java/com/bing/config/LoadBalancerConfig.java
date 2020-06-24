package com.bing.config;

import com.bing.NonBlockingLoadBalancerClient;

import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author hlb
 * @date 2020/6/18 17:56
 *
 */
@Configuration
public class LoadBalancerConfig {

	@Bean
	public NonBlockingLoadBalancerClient nonBlockingLoadBalancerClient(LoadBalancerClientFactory loadBalancerClientFactory){

		return new NonBlockingLoadBalancerClient(loadBalancerClientFactory);
	}

}

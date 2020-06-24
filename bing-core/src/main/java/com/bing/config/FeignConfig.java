package com.bing.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bing.FeignNonBlockingLoadBalancerClient;
import com.bing.NonBlockingLoadBalancerClient;
import feign.Client;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.okhttp.OkHttpClient;
import feign.optionals.OptionalDecoder;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 *
 *
 * @author hlb
 * @date 2020/6/18 18:07
 *
 */
@Configuration
public class FeignConfig {

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	public Client feignClient(okhttp3.OkHttpClient okHttpClient,
			NonBlockingLoadBalancerClient loadBalancerClient) {
		OkHttpClient delegate = new OkHttpClient(okHttpClient);
		return new FeignNonBlockingLoadBalancerClient(delegate, loadBalancerClient);
	}

	@Bean
	public HttpMessageConverters httpMessageConverters(){
		return new HttpMessageConverters(new StringHttpMessageConverter());
	}

	@Bean
	public Decoder feignDecoder() {
		return new OptionalDecoder(
				new ResponseEntityDecoder(new SpringDecoder(this.messageConverters)));
	}

	@Bean
	public Encoder feignEncoder() {
		return new SpringEncoder(this.messageConverters);
	}


}

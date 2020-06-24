package com.bing.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import feign.Client;
import feign.okhttp.OkHttpClient;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.commons.httpclient.OkHttpClientConnectionPoolFactory;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author hlb
 * @date 2020/6/11 20:03
 *
 */
@Configuration
public class WebFrontConfig {

//	@Bean
//	@ConditionalOnMissingBean(Client.class)
//	public Client feignClient(okhttp3.OkHttpClient client) {
//		return new OkHttpClient(client);
//	}
//
//	@Bean
//	@ConditionalOnMissingBean({ConnectionPool.class})
//	public ConnectionPool httpClientConnectionPool(
//			FeignHttpClientProperties httpClientProperties,
//			OkHttpClientConnectionPoolFactory connectionPoolFactory) {
//		Integer maxTotalConnections = httpClientProperties.getMaxConnections();
//		Long timeToLive = httpClientProperties.getTimeToLive();
//		TimeUnit ttlUnit = httpClientProperties.getTimeToLiveUnit();
//		return connectionPoolFactory.create(maxTotalConnections, timeToLive, ttlUnit);
//	}
//
//	@Bean
//	public okhttp3.OkHttpClient client(OkHttpClientFactory httpClientFactory,
//			ConnectionPool connectionPool,
//			FeignHttpClientProperties httpClientProperties) {
//
//		Boolean followRedirects = httpClientProperties.isFollowRedirects();
//		Integer connectTimeout = httpClientProperties.getConnectionTimeout();
//		Boolean disableSslValidation = httpClientProperties.isDisableSslValidation();
//		return httpClientFactory.createBuilder(disableSslValidation)
//				.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
//				.readTimeout(60000, TimeUnit.MILLISECONDS)
//				.followRedirects(followRedirects).connectionPool(connectionPool)
//				.connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT))
//				.build();
//	}

}

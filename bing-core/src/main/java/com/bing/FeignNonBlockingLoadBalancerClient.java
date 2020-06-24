package com.bing;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 *
 *
 * @author hlb
 * @date 2020/6/18 18:10
 *
 */
public class FeignNonBlockingLoadBalancerClient implements Client {

	private static final Log LOG = LogFactory
			.getLog(FeignNonBlockingLoadBalancerClient.class);

	private final Client delegate;

	private final NonBlockingLoadBalancerClient loadBalancerClient;

	public FeignNonBlockingLoadBalancerClient(Client delegate,
			NonBlockingLoadBalancerClient loadBalancerClient) {
		this.delegate = delegate;
		this.loadBalancerClient = loadBalancerClient;
	}

	@Override
	public Response execute(Request request, Request.Options options) throws IOException {
		final URI originalUri = URI.create(request.url());
		String serviceId = originalUri.getHost();
		Assert.state(serviceId != null,
				"Request URI does not contain a valid hostname: " + originalUri);
		ServiceInstance instance = loadBalancerClient.choose(serviceId);
		if (instance == null) {
			String message = "Load balancer does not contain an instance for the service "
					+ serviceId;
			if (LOG.isWarnEnabled()) {
				LOG.warn(message);
			}
			return Response.builder().request(request)
					.status(HttpStatus.SERVICE_UNAVAILABLE.value())
					.body(message, StandardCharsets.UTF_8).build();
		}
		String reconstructedUrl = loadBalancerClient.reconstructURI(instance, originalUri)
				.toString();
		Request newRequest = Request.create(request.httpMethod(), reconstructedUrl,
				request.headers(), request.body(), request.charset(),
				request.requestTemplate());
		return delegate.execute(newRequest, options);
	}

	// Visible for Sleuth instrumentation
	public Client getDelegate() {
		return delegate;
	}
}

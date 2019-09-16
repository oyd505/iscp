package com.island.iscp.feign.sentinel.manager;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class TestFallbackFactory implements FallbackFactory<TestFallback> {

	@Override
	public TestFallback create(Throwable cause) {
		return new TestFallback(cause);
	}

}

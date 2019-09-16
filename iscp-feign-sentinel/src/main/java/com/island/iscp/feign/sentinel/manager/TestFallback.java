package com.island.iscp.feign.sentinel.manager;

import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class TestFallback implements TestClient {
	private Throwable throwable;

	public TestFallback(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public String helloNacos() {
		log.error("remote helloNacos throw Exception", throwable);
		return "consumer-fallback-hello-str: " + throwable.getMessage();
	}

	@Override
	public String sleep(int factor) {
		log.error("remote sleep throw Exception", throwable);
		return "consumer-fallback-sleep-str: " + throwable.getMessage();
	}

}

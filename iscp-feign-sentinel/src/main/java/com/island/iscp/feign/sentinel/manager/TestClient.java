package com.island.iscp.feign.sentinel.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "iscp-nacos", fallbackFactory = TestFallbackFactory.class)
public interface TestClient {

	@GetMapping("/test/helloNacos")
	String helloNacos();

	@GetMapping("/test/sleep")
	String sleep(@RequestParam("factor") int factor);
}

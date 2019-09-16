package com.island.iscp.nacos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/helloNacos")
	public String helloNacos() {
		log.debug("helloNacos method of TestController");
		return "你好，nacos！";
	}

	@GetMapping("/sleep")
	public String sleep(int factor) throws InterruptedException {
		long millis = 10000 / factor;
		Thread.sleep(millis);
		return "sleep: " + millis;
	}
}

package com.island.iscp.feign.sentinel.web;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.island.iscp.feign.sentinel.manager.TestClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/remote")
public class RemoteController {

	@Autowired
	private TestClient testClient;

	@GetMapping("/helloNacos")
	public String helloNacos() {
		log.info("helloNacos method of RemoteController");
		return testClient.helloNacos();
	}

	@GetMapping("/sleep")
	public String sleep(@RequestParam(required = false) Integer factor) throws InterruptedException {
		int param = 0;
		if (factor == null) {
			param = RandomUtils.nextInt(10);
		} else {
			param = factor.intValue();
		}
		return testClient.sleep(param);
	}

	@GetMapping("/local")
	public String local() {
		log.info("local method of RemoteController");
		return "local";
	}

}

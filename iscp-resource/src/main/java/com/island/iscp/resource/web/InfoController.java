package com.island.iscp.resource.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/info")
public class InfoController {

	// 添加一个测试访问接口
	@GetMapping("/user")
	public Authentication getUser(Authentication authentication) {
		log.info("resource: user {}" + authentication);
		return authentication;
	}

	@GetMapping("/local")
	public String local() {
		log.info("local method of RemoteController");
		return "local";
	}
}

package com.island.iscp.authserver.web;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	@GetMapping("read")
	public String read() {
		return "read";
	}

	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
}

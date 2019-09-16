package com.island.iscp.resource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class App {
	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class).run(args);
	}
}

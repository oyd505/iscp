package com.island.iscp.gateway.sentinel;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;

import reactor.core.publisher.Mono;

@Configuration
public class MySCGConfiguration {

	@Bean
	public BlockRequestHandler blockRequestHandler() {
		return new BlockRequestHandler() {
			@Override
			public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
				return ServerResponse.status(444).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(fromObject("SCS Sentinel block"));
			}
		};
	}

}

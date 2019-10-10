package com.island.iscp.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.island.iscp.stream.kafka.DemoChannel;

@SpringBootApplication
@EnableBinding(value = { DemoChannel.class })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

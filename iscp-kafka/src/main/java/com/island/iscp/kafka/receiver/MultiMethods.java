package com.island.iscp.kafka.receiver;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.island.iscp.kafka.domain.Bar;
import com.island.iscp.kafka.domain.Fool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@KafkaListener(id = "multiGroup", topics = { "foos", "bars" })
public class MultiMethods {

	@KafkaHandler
	public void foo(Fool foo) {
		log.info("Received: " + foo);
	}

	@KafkaHandler
	public void bar(Bar bar) {
		log.info("Received: " + bar);
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		log.info("Received unknown: " + object);
	}

}

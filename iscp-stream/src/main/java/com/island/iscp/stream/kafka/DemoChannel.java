package com.island.iscp.stream.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DemoChannel {

	/**
	 * 发消息的通道名称
	 */
	String DEMO_OUTPUT = "demo_output";
	/**
	 * 消息的订阅通道名称
	 */
	String DEMO_INPUT = "demo_input";

	/**
	 * 发消息的通道
	 *
	 * @return
	 */
	@Output(DEMO_OUTPUT)
	MessageChannel sendDemoMessage();

	/**
	 * 收消息的通道
	 *
	 * @return
	 */
	@Input(DEMO_INPUT)
	SubscribableChannel recieveDemoMessage();
}

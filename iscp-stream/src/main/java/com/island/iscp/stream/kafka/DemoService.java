package com.island.iscp.stream.kafka;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {

	@Resource(name = DemoChannel.DEMO_OUTPUT)
	private MessageChannel sendDemoMessageChannel;

	@GetMapping("/sendMsg")
	public String sendDemoMessage(String content) {
		boolean isSendSuccess = sendDemoMessageChannel.send(MessageBuilder.withPayload(content).build());
		return isSendSuccess ? "发送成功" : "发送失败";
	}

	@StreamListener(DemoChannel.DEMO_INPUT)
	public void receive(Message<String> message) {
		System.out.println(message.getPayload());
	}
}

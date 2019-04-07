package com.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableJms
public class ActivemqJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqJmsApplication.class, args);
	}
	@JmsListener(destination = "input.queue")
	@SendTo("output.queue")
	public String receiveQueue(String message) {
		System.out.println("Message Received: "+message);
		return message;
	}
}

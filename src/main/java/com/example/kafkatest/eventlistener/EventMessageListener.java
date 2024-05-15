package com.example.kafkatest.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventMessageListener {

	@Async
	@EventListener
	public void handleMessage(String message) {
		log.info("[*] EventListener(String) Message : {} ", message);
	}

	@Async
	@EventListener
	public void handleMessage(ApplicationEventImpl message) {
		log.info("[*] EventListener Message(Object) : {} ", message.getSource());
	}
}

package com.example.kafkatest.eventlistener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventMessageProducer {
	private final ApplicationEventPublisher eventPublisher;

	public void produceMessage(String message) {
		// log.info("[*] EventPublisher(String) Message : {}", message);

		long startTime = System.currentTimeMillis();

		eventPublisher.publishEvent(message);

		long endTime = System.currentTimeMillis();

		log.info("[*] EventPublisher Message(String) sent successfully in {} ms", endTime - startTime);
	}

	public void produceMessage(EventMessage message) {
		// log.info("[*] EventPublisher(Object) Message : {}", message);

		long startTime = System.currentTimeMillis();
		eventPublisher.publishEvent(new ApplicationEventImpl(message));

		long endTime = System.currentTimeMillis();

		log.info("[*] EventPublisher Message(Object) sent successfully in {} ms", endTime - startTime);
	}
}

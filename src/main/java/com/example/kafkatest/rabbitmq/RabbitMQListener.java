package com.example.kafkatest.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitMQListener {

	// RabbitMQ로부터 메시지를 구독하여 처리하는 메서드
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void handleMessage(String message) {
		log.info("[*] RabbitMQ Message : {}", message);
	}
}

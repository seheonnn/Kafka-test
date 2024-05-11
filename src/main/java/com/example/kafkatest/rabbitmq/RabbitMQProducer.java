package com.example.kafkatest.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQProducer {

	private final RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.exchange}")
	private String exchange;

	@Value("${spring.rabbitmq.routing-key}")
	private String routingKey;

	// RabbitMQ는 Kafka와 달리 직렬화/역직렬화 기능 내장되어 있지 않음
	// 직접 직렬화/역직렬화 작업을 수행해야.
	// String 직렬화/역직렬화 or 보낼 객체 Serializable 인터페이스 구현 ... 등등
	public void sendMessage(String message) {
		// log.info("[*] RabbitMQ Producer Message : {}", message);
		// RabbitMQ로 메시지를 전송합니다.
		// rabbitTemplate.convertAndSend(exchange, routingKey, message);

		// (선택) 전송시간
		// 메시지를 보내기 전 현재 시간 기록
		long startTime = System.currentTimeMillis();

		rabbitTemplate.convertAndSend(exchange, routingKey, message);

		long endTime = System.currentTimeMillis();

		// 전송 및 처리 시간 계산
		log.info("[*] RabbitMQ Message sent successfully in {} ms", endTime - startTime);

	}
}

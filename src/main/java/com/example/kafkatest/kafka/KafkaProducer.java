package com.example.kafkatest.kafka;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

	private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
	private final KafkaTemplate<String, String> kafkaStringTemplate;
	@Value("${spring.kafka.template.default-topic}")
	private String topic;

	@Value("${spring.kafka.template.topic}")
	private String topic1;

	public void produceMessage(KafkaMessage message) {
		// log.info("[*] Kafka(String) Producer Message : {}", message);
		// kafkaTemplate.send(topic, message);

		// (선택) callback 함수
		// kafkaTemplate.send 메소드 호출 전에 현재 시간 기록
		long startTime = System.currentTimeMillis();

		CompletableFuture<SendResult<String, KafkaMessage>> future = kafkaTemplate.send(topic1, message);
		future.whenComplete(((result, throwable) -> {
			if (throwable == null) {
				// 해당 파티션의 offset
				log.info("[*] offset : {}", result.getRecordMetadata().offset());
				// 메시지 전송 후의 시간 기록
				long endTime = System.currentTimeMillis();
				log.info("[*] Kafka Message(Object) sent successfully in {} ms", endTime - startTime);
			} else {
				log.error("[*] fail to publish", throwable);
			}
		}));
	}

	// String
	public void produceMessage(String message) {
		// log.info("[*] Kafka(String) Producer Message : {}", message);

		long startTime = System.currentTimeMillis();

		CompletableFuture<SendResult<String, String>> future = kafkaStringTemplate.send(topic, message);
		future.whenComplete(((result, throwable) -> {
			if (throwable == null) {
				// 메시지 전송 후의 시간 기록
				long endTime = System.currentTimeMillis();
				log.info("[*] Kafka Message(String) sent successfully in {} ms", endTime - startTime);
			} else {
				log.error("[*] fail to publish", throwable);
			}
		}));
	}
}

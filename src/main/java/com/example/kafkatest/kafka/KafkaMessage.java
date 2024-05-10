package com.example.kafkatest.kafka;

import lombok.Builder;

@Builder
public record KafkaMessage(
	String message1,
	String message2
) {
	public static KafkaMessage to(String message1, String message2) {
		return KafkaMessage.builder()
			.message1(message1)
			.message2(message2)
			.build();
	}
}

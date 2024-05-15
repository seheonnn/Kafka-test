package com.example.kafkatest.eventlistener;

import lombok.Builder;

@Builder
public record EventMessage(
	String message1,
	String message2
) {
	public static EventMessage to(String message1, String message2) {
		return EventMessage.builder()
			.message1(message1)
			.message2(message2)
			.build();
	}
}

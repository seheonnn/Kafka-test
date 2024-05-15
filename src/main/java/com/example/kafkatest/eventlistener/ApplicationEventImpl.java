package com.example.kafkatest.eventlistener;

import java.time.Clock;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class ApplicationEventImpl extends ApplicationEvent {
	public ApplicationEventImpl(Object source) {
		super(source);
	}

	public ApplicationEventImpl(Object source, Clock clock) {
		super(source, clock);
	}
}

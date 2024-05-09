package com.example.kafkatest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kafka")
public class TestController {

	private final TestService kafkaTestService;

	// @GetMapping("/test")
	// public void testKafka() {
	// 	kafkaTestService.kafkaProducerTest();
	// }
}

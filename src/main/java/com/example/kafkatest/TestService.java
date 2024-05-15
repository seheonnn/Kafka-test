package com.example.kafkatest;

import org.springframework.stereotype.Service;

import com.example.kafkatest.eventlistener.EventMessage;
import com.example.kafkatest.eventlistener.EventMessageProducer;
import com.example.kafkatest.kafka.KafkaMessage;
import com.example.kafkatest.kafka.KafkaProducer;
import com.example.kafkatest.rabbitmq.RabbitMQProducer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	private final KafkaProducer kafkaProducer;
	private final RabbitMQProducer rabbitMQProducer;
	private final EventMessageProducer eventMessageProducer;

	public void kafkaProducerTest() {

		// ============== Kafka ==============
		KafkaMessage message = KafkaMessage.to("안녕하세요 !", "카프카 테스트 중입니다 !");
		kafkaProducer.produceMessage(message);

		kafkaProducer.produceMessage("안녕하세요 !");

		// // ============== RabbitMQ ==============
		rabbitMQProducer.sendMessage("안녕하세요 !");

		// ============== EventListener ==============
		eventMessageProducer.produceMessage("안녕하세요 !");

		EventMessage eventMessage = EventMessage.to("안녕하세요", "EventListener 테스트 중입니다 !");
		eventMessageProducer.produceMessage(eventMessage);
	}
}

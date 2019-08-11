package com.nu.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nu.domain.User;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	@Autowired
	private EmailService emailService;
	private CountDownLatch latch = new CountDownLatch(1);
	
	@KafkaListener(topics = "${spring.kafka.topic.userCreated}")
	@Override
	public void receive(User payload) {
		emailService.sendSimpleMessage(payload);
		latch.countDown();
	}

}

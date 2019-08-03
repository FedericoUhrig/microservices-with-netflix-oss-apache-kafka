package com.nu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nu.domain.User;

@Service
public class SenderServiceImpl implements SenderService {
	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

	@Override
	public void send(String topic, User payload) {
		 kafkaTemplate.send(topic, payload);
	}
 
	
}

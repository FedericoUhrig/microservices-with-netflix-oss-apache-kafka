package com.nu.service;

import com.nu.domain.User;

public interface SenderService {
	void send(String topic, User payload);
}

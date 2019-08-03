package com.nu.service;

import com.nu.dto.UserDTO;

public interface EmailService {
	void sendSimpleMessage(UserDTO input);
}

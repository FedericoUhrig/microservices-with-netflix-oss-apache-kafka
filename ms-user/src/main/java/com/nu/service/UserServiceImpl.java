package com.nu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nu.domain.User;
import com.nu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Value("${spring.kafka.topic.userCreated}")
	private String topic;

	@Autowired
	private SenderService sender;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User registerUser(User user) {
		User createdUser = userRepository.save(user);
		sender.send(topic, createdUser);
		return createdUser;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

}

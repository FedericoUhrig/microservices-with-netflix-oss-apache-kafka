package com.nu.service;

import com.nu.domain.User;

public interface UserService {
	User registerUser(User user);

	Iterable<User> findAll();
}

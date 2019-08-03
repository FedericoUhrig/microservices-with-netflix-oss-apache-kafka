package com.nu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nu.domain.User;
import com.nu.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<Iterable<User>> getAll() {
		Iterable<User> all = userService.findAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<User> register(@RequestBody User user) {
		User result = userService.registerUser(user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}

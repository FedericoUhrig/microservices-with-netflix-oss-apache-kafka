package com.nu.repository;

import org.springframework.data.repository.CrudRepository;

import com.nu.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

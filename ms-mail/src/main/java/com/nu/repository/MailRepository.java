package com.nu.repository;

import org.springframework.data.repository.CrudRepository;

import com.nu.domain.Mail;

public interface MailRepository extends CrudRepository<Mail, Long> {

}

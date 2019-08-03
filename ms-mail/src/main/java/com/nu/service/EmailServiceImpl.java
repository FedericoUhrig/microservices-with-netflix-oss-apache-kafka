package com.nu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.nu.domain.Mail;
import com.nu.dto.UserDTO;
import com.nu.repository.MailRepository;

public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private MailRepository mailRepository;

	@Override
	public void sendSimpleMessage(UserDTO input) {
		try {

			Mail newMail = new Mail();
			newMail.setTo(input.getUsername());
			newMail.setSubject("TestSubject");
			newMail.setText("TestText");

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(newMail.getTo());
			message.setSubject(newMail.getSubject());
			message.setText(newMail.getText());

			mailRepository.save(newMail);
			emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}

}

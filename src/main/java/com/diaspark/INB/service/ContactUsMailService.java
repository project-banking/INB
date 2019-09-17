package com.diaspark.INB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.diaspark.INB.DTO.ContactUsDTO;

@Service
public class ContactUsMailService {
	private JavaMailSender javaMailSender;
	@Autowired
	public void MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public void sendEmail(ContactUsDTO contactUsDTO) throws MappingException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(contactUsDTO.getEmail());
		mail.setSubject(contactUsDTO.getFirstName() + " " +contactUsDTO.getLastName() + " has following query");
		mail.setText(contactUsDTO.getQueries());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

}

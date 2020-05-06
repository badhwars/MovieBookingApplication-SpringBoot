package com.prog39599;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
@SpringBootApplication
public class MovieBookingApplication {
	
//	@Autowired
//	private JavaMailSender javaMailSender;
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		//sendEmail("sarveshb53@gmail.com","Hi Hello","hehcjisdj ijosjd");
//	}
//	private void sendEmail(String to, String sub, String text) {
//		// TODO Auto-generated method stub
//		System.out.println("Sending the message");
//		SimpleMailMessage msg= new SimpleMailMessage();
//		
//		msg.setTo(to);
//		msg.setSubject(sub);
//		msg.setText(text);
//		
//		try {
//			javaMailSender.send(msg);		
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		System.out.println("DOne");
//	}
}

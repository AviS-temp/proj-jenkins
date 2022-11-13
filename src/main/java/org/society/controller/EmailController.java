package org.society.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.EmailDetails;
import org.society.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@CrossOrigin("*")
public class EmailController {
	
	 @Autowired 
	 private EmailService emailService;
	 
	// 11 November - Adding Loggers
			Logger log=LoggerFactory.getLogger(EmailController.class);
	 
	    @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	        String status = emailService.sendSimpleMail(details);
	        log.info("Email sent!!");
	        return status;
	    }
}

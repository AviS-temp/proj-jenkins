package org.society.service;

import org.society.entities.EmailDetails;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
}

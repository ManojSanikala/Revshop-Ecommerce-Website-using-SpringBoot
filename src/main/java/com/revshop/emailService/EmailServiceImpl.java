package com.revshop.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
 
    @Autowired
    private JavaMailSender mailSender;
 
    public void sendRegistrationEmail(String toEmail, String firstName, String userType) {
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to RevShop - Your Registration is Successful!");
 
        String emailContent = String.format(
            "Dear %s,\n\n" +
            "Thank you for registering with RevShop! We are excited to welcome you to our e-commerce community.\n\n" +
            "Your registration was successful, and you can now enjoy a wide range of products and services tailored just for you. Here are a few things you can do next:\n\n" +
            "- Log In: Access your account and explore our marketplace.\n" +
            "- Browse Products: Check out our latest offerings and special deals.\n" +
            "- Get Support: If you have any questions, feel free to reach out to our customer service team.\n\n" +
            "Your account details are as follows:\n\n" +
            "Email: %s\n" +
            "User Type: %s\n\n" +
            "For any further assistance or inquiries, don’t hesitate to contact us at support@revshop.com.\n\n" +
            "We are thrilled to have you on board and look forward to serving you!\n\n" +
            "Best regards,\n\n" +
            "The RevShop Team",
            firstName, toEmail, userType
        );
 
        message.setText(emailContent);
        mailSender.send(message);
    }
}
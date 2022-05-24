package com.app.banking.controller;

import com.app.banking.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

import static com.app.banking.URLMapping.EMAIL;

@RestController
@RequestMapping(EMAIL)
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping
    public String sendEmail() throws MessagingException, IOException {
        emailService.sendEmail();
        return "Email sent successfully";
    }
}

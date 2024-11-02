package com.docbox.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.docbox.api.jms.MessagingService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessagingService messagingService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String phoneNumber, @RequestParam String message) {
    	message = message + " " + phoneNumber;
        messagingService.sendMessage(phoneNumber, message);
        return "OTP sent successfully to " + phoneNumber;
    }
}
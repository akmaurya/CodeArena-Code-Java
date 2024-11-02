package com.docbox.api.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    private static final String DESTINATION = "smsQueue";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String phoneNumber, String message) {
        String smsMessage = phoneNumber + ":" + message;
        jmsTemplate.convertAndSend(DESTINATION, smsMessage);
    }
}
package com.edwinrhc.notificacionservice.app.controller;

import com.edwinrhc.notificacionservice.app.client.EmailClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final EmailClient emailClient;

    public NotificationController(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String text){
        return emailClient.sendEmail(to, subject, text);
    }

}

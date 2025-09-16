package com.edwinrhc.notificacionservice.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email-service")
public interface EmailClient {

    @PostMapping("/api/email/send")
    String sendEmail(@RequestParam String to,
                     @RequestParam String subject,
                     @RequestParam String text);
}

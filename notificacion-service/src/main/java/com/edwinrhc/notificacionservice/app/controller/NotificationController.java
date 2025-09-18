package com.edwinrhc.notificacionservice.app.controller;

import com.edwinrhc.notificacionservice.app.client.EmailClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
    @CircuitBreaker(name= "emailService", fallbackMethod = "fallbackEmail")
    @Retry(name ="emailService") // intentará 3 veces antes de fallback
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String text){
        return emailClient.sendEmail(to, subject, text);
    }

    // Fallback: lo que ocurre si falla email-service
    public String fallbackEmail(String to, String subject, String message, Throwable ex){
        return "No se pudo enviar el email a: " + to + ". Guardado en cola para reintento. ";
    }

}

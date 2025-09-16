package com.edwinrhc.emailservice.restcontroller;

import com.edwinrhc.emailservice.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Email service is alive";
    }


    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestParam String to,
                       @RequestParam String subject,
                       @RequestParam String text){
        emailService.sendEmail(to, subject, text);
        return ResponseEntity.ok("Email enviado a:" + to);
    }




}

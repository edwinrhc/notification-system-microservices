package com.edwinrhc.authservice.controller;

import com.edwinrhc.authservice.security.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password){
        // Dummy check: usuario "admin" y password "1234"
        if("admin".equals(username) && "1234".equals(password)){
            return jwtUtil.generateToken(username);
        }
        return "Incorrect credentials";
    }

    // Prueba : Usar token

    @GetMapping("/test")
    public String test(Authentication authentication) {
        return "Hola " + authentication.getName() + ", tu token es válido 🚀";
    }

}

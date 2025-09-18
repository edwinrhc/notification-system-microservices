package com.edwinrhc.authservice.controller;

import com.edwinrhc.authservice.repository.UserRepository;
import com.edwinrhc.authservice.security.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> jwtUtil.generateToken(username))
                .orElse("Invalid username or password");
    }

    // Prueba : Usar token

    @GetMapping("/test")
    public String test(Authentication authentication) {
        return "Hola " + authentication.getName() + ", tu token es válido 🚀";
    }

}

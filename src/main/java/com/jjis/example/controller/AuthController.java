package com.jjis.example.controller;

import com.jjis.example.entity.User;
import com.jjis.example.security.JwtUtil;
import com.jjis.example.service.AuthService;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        service.register(user);
        return Map.of("message", "Message: User Registered");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        var dbUser = service.login(user);
        String token = jwtUtil.generateToken(dbUser.getUsername());
        return Map.of("message", token);
    }
}
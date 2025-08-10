package com.example.SpringAuth.CRUD.API.Controllers;

import com.example.SpringAuth.CRUD.API.Services.AuthService;
import com.example.SpringAuth.CRUD.API.dto.LoginRequest;
import com.example.SpringAuth.CRUD.API.dto.LoginResponse;
import com.example.SpringAuth.CRUD.API.dto.RegisterRequest;
import com.example.SpringAuth.CRUD.API.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequest registerRequest) {
        UserDto registeredUser = authService.register(registerRequest);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from a protected endpoint!");
    }
}
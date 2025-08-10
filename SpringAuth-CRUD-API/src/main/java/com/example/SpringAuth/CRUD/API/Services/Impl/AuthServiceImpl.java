package com.example.SpringAuth.CRUD.API.Services.Impl;

import com.example.SpringAuth.CRUD.API.Entities.User;
import com.example.SpringAuth.CRUD.API.Exception.UserAlreadyExistsException;
import com.example.SpringAuth.CRUD.API.Repositories.UserRepository;
import com.example.SpringAuth.CRUD.API.Services.AuthService;
import com.example.SpringAuth.CRUD.API.dto.LoginRequest;
import com.example.SpringAuth.CRUD.API.dto.RegisterRequest;
import com.example.SpringAuth.CRUD.API.dto.UserDto;
import com.example.SpringAuth.CRUD.API.utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDto register(RegisterRequest registerRequest) {
        // Check if user already exists
        userRepository.findByEmail(registerRequest.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistsException("User with this email already exists.");
        });

        // Create new user
        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .fullName(registerRequest.getFullName())
                .role("ROLE_USER") // Default role
                .build();

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        // If authentication is successful, generate a JWT
        return jwtUtil.generateToken(authentication.getName());
    }
}
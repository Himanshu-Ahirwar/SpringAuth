package com.example.SpringAuth.CRUD.API.Services;


import com.example.SpringAuth.CRUD.API.dto.LoginRequest;
import com.example.SpringAuth.CRUD.API.dto.RegisterRequest;
import com.example.SpringAuth.CRUD.API.dto.UserDto;

public interface AuthService {
    UserDto register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);
}
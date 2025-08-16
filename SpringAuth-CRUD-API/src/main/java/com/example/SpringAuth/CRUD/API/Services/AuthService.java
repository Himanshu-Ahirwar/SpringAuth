package com.example.SpringAuth.CRUD.API.Services;


import com.example.SpringAuth.CRUD.API.Entities.User;
import com.example.SpringAuth.CRUD.API.dto.LoginRequest;
import com.example.SpringAuth.CRUD.API.dto.RegisterRequest;
import com.example.SpringAuth.CRUD.API.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthService {
    UserDto register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);

    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    UserDto getUserById(Long id);


    List<User> getUsersByRole(String role);

    Page<User> getAllUsers(int page, int size);
}
package com.example.SpringAuth.CRUD.API.Repositories;


import com.example.SpringAuth.CRUD.API.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
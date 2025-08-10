package com.example.SpringAuth.CRUD.API.Repositories;

import com.example.SpringAuth.CRUD.API.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
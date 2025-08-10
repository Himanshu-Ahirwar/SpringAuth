package com.example.SpringAuth.CRUD.API.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // stored encoded

    @Column
    private String fullName;

    @Column
    private String role; // e.g. ROLE_USER
}
package com.coursedash.client.repository;

import java.util.Optional;

import com.coursedash.client.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<User> findByEmail(String email);

}

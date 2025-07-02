package com.bliss.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bliss.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
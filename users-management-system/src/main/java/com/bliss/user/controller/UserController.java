package com.bliss.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bliss.user.model.User;
import com.bliss.user.service.UserService;

@RestController
@RequestMapping("/users") // Assuming API Gateway will route /api/users or similar to /users here
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        log.info("User registration request received for username: {}", user.getUsername());
        User registeredUser = userService.registerUser(user);
        log.info("User registration processed for ID: {}", registeredUser.getId());
        return registeredUser;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}

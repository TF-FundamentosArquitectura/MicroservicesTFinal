package com.bliss.notification.service;

// This DTO should ideally be in a shared library if multiple services use it.
// For now, it's duplicated from users-management-system.
// Ensure fields match what is being sent by the producer.
public class UserEventDto {
    private Long id;
    private String username;
    private String email;

    // Constructors
    public UserEventDto() {
    }

    public UserEventDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEventDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

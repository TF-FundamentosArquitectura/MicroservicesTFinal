package com.bliss.user.service;

import com.bliss.user.usersmanagementsystem.UsersManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.user.model.User;
import com.bliss.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UsersManagementSystemApplication.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUsername("john");
        user.setEmail("john@example.com");
        user.setPassword("password");

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User createdUser = userService.registerUser(user);

        assertNotNull(createdUser);
        assertEquals("john", createdUser.getUsername());
        assertEquals("john@example.com", createdUser.getEmail());
    }

    @Test
    public void testGetUserByUsername() {
        User user = new User();
        user.setUsername("john");
        user.setEmail("john@example.com");
        user.setPassword("password");

        Mockito.when(userRepository.findByUsername("john")).thenReturn(user);

        User fetchedUser = userService.getUserByUsername("john");

        assertNotNull(fetchedUser);
        assertEquals("john", fetchedUser.getUsername());
    }
}

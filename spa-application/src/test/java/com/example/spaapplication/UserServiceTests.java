package com.example.spaapplication;

import com.example.spaapplication.dto.UserDto;
import com.example.spaapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;
    @Test
    void find_user_by_user_name_given_unexisted_username_should_throw_UsernameNotFoundException(){
        var unexistedUserName = "hung";
        assertThrows(
                UsernameNotFoundException.class,
                () -> userService.findUserByName(unexistedUserName)
        );
    }

    @Test
    void find_user_by_user_name_should_success(){
        var username = "huy2110";
        UserDto expect = new UserDto();
        expect.setId(1);
        expect.setUsername("huy2110");
        UserDto actual = userService.findUserByName(username);
        assertTrue(expect.getId() == actual.getId());
        assertTrue(expect.getUsername().equals(actual.getUsername()));
    }
}

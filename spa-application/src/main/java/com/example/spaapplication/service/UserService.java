package com.example.spaapplication.service;

import com.example.spaapplication.dto.UserDto;
import com.example.spaapplication.entities.User;
import com.example.spaapplication.mapstruct.UserMapper;
import com.example.spaapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserDto findUserByName(String name){
        User user = userRepository.findUserByUsername(name).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("");
                }
        );
        return userMapper.to(user);
    };
}

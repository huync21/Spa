package com.example.spaapplication.mapstruct;

import com.example.spaapplication.dto.UserDto;
import com.example.spaapplication.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{
    UserDto to(User user);
}

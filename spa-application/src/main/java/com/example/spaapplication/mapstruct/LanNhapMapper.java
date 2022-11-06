package com.example.spaapplication.mapstruct;

import com.example.spaapplication.dto.LanNhapDto;
import com.example.spaapplication.entities.LanNhap;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanNhapMapper {
    LanNhap from(LanNhapDto lanNhapDto);
}

package com.example.spaapplication.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanNhapDto {
    Integer id;
    String moTa;
    UserDto user;
    NhaCungCapDTO nhaCungCap;
    List<NguyenLieuTrongLanNhapDTO> listNguyenLieuTrongLanNhap;
}

package com.example.spaapplication.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanNhapDto {
    Integer id;
    String moTa;
    UserDto user;
    NhaCungCapDTO nhaCungCap;
    List<NguyenLieuTrongLanNhapDTO> listNguyenLieuTrongLanNhap;
}

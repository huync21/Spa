package com.example.spaapplication.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguyenLieuDTO {
    Integer id;
    @NotNull
    String ten;
    String tenHangSanXuat;
    String moTa;
    UserDto user;
}

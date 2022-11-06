package com.example.spaapplication.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguyenLieuDTO {
    Integer id;
    @NotBlank
    String ten;
    @NotBlank
    String tenHangSanXuat;
    String moTa;
    UserDto user;
}

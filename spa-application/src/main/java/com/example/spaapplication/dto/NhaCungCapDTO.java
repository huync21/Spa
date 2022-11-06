package com.example.spaapplication.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhaCungCapDTO {
    Integer id;
    @NotNull(message = "Tên không được bỏ trống")
    String ten;
    String moTa;
    @NotNull(message = "Địa chỉ không được bỏ trống")
    String diaChi;
    UserDto user;
}

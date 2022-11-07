package com.example.spaapplication.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapDTO {
    Integer id;
    @NotBlank(message = "Tên không được bỏ trống")
    String ten;
    String moTa;
    @NotBlank(message = "Địa chỉ không được bỏ trống")
    String diaChi;
    UserDto user;
}

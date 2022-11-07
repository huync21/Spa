package com.example.spaapplication.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NguyenLieuDTO {
    Integer id;
    @NotBlank
    String ten;
    @NotBlank
    String tenHangSanXuat;
    String moTa;
    UserDto user;
}

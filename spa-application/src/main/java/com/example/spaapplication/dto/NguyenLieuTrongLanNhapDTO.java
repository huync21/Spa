package com.example.spaapplication.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguyenLieuTrongLanNhapDTO {
    Integer id;
    @NotNull(message = "Không được bỏ trống số lượng")
    @Min(value = 1)
    Integer soLuong;
    @NotNull(message = "Không được bỏ trống đơn giá")
    @Min(value = 1)
    Double donGia;
    String hanSuDung;
    String xuatSu;
    NguyenLieuDTO nguyenLieu;
}

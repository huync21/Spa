package com.example.spaapplication.mapstruct;

import com.example.spaapplication.dto.NguyenLieuDTO;
import com.example.spaapplication.entities.NguyenLieu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NguyenLieuMapper {
    List<NguyenLieuDTO> to(List<NguyenLieu> nguyenLieus);
    NguyenLieuDTO to(NguyenLieu nguyenLieu);
}

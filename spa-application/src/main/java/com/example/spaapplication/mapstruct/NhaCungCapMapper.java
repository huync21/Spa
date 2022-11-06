package com.example.spaapplication.mapstruct;

import com.example.spaapplication.dto.NhaCungCapDTO;
import com.example.spaapplication.entities.NhaCungCap;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhaCungCapMapper {
    List<NhaCungCapDTO> to(List<NhaCungCap> nhaCungCap);
    NhaCungCapDTO to(NhaCungCap nhaCungCap);
}

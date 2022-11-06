package com.example.spaapplication.service;

import com.example.spaapplication.dto.NguyenLieuDTO;
import com.example.spaapplication.mapstruct.NguyenLieuMapper;
import com.example.spaapplication.repository.NguyenLieuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NguyenLieuService {
    private final NguyenLieuRepository nguyenLieuRepository;
    private final NguyenLieuMapper nguyenLieuMapper;
    public List<NguyenLieuDTO> getNguyenLieu(String ten){
        return nguyenLieuMapper.to(nguyenLieuRepository.findNguyenLieuByTenContains(ten));
    }
    public NguyenLieuDTO getNguyenLieu(Integer id){
        return nguyenLieuMapper.to(nguyenLieuRepository.findById(id).orElse(null));
    }
}

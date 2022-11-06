package com.example.spaapplication.service;

import com.example.spaapplication.dto.LanNhapDto;
import com.example.spaapplication.entities.LanNhap;
import com.example.spaapplication.mapstruct.LanNhapMapper;
import com.example.spaapplication.repository.LanNhapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanNhapService {
    private final LanNhapRepository lanNhapRepository;
    private final LanNhapMapper lanNhapMapper;

    public void save(LanNhapDto lanNhapDto) {
        LanNhap lanNhap = lanNhapMapper.from(lanNhapDto);
        lanNhap.getListNguyenLieuTrongLanNhap()
                .forEach(nguyenLieuTrongLanNhap -> {
                    nguyenLieuTrongLanNhap.setLanNhap(lanNhap);
                });
        lanNhapRepository.save(lanNhap);
    }
}

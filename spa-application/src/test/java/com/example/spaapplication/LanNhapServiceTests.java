package com.example.spaapplication;

import com.example.spaapplication.dto.LanNhapDto;
import com.example.spaapplication.service.LanNhapService;
import com.example.spaapplication.service.NhaCungCapService;
import com.example.spaapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class LanNhapServiceTests {
    @Autowired
    private LanNhapService lanNhapService;
    @Autowired
    private NhaCungCapService nhaCungCapService;
    @Autowired
    private UserService userService;
    @Test
    void xac_nhan_lan_nhap_should_success(){
        lanNhapService.save(LanNhapDto.builder()
                .moTa("babsldgsd")
                .listNguyenLieuTrongLanNhap(new ArrayList<>())
                .nhaCungCap(nhaCungCapService.getNhaCungCap(1))
                .user(userService.findUserByName("huy2110"))
                .build());
    }
}

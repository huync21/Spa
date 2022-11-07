package com.example.spaapplication;

import com.example.spaapplication.dto.NguyenLieuDTO;
import com.example.spaapplication.dto.NhaCungCapDTO;
import com.example.spaapplication.service.NguyenLieuService;
import com.example.spaapplication.service.NhaCungCapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NguyenLieuServiceTests {
    @Autowired
    private NguyenLieuService nguyenLieuService;

    @Test
    void get_nguyen_lieu_test1() {
        var ten = "Thuoc";
        List<NguyenLieuDTO> expected = new ArrayList<>();
        expected.add(NguyenLieuDTO.builder()
                .id(2).ten("Thuoc uon toc xyz")
                .build());
        expected.add(NguyenLieuDTO.builder()
                .id(3).ten("Thuoc nhuom toc")
                .build());
        List<NguyenLieuDTO> actual = nguyenLieuService.getNguyenLieu(ten);
        boolean condition = true;
        for(int i=0;i<expected.size();i++){
            NguyenLieuDTO e = expected.get(i);
            NguyenLieuDTO a = actual.get(i);
            if( e.getId() != a.getId() || !e.getTen().equals(a.getTen()))
                condition = false;
        }
        assertTrue(expected.size() == actual.size());
        assertTrue(condition == true);
    }

    @Test
    void get_nguyen_lieu_test2() {
        var ten = "sdfgsjkdfbgjkbsdfgjjkbg";
        List<NguyenLieuDTO> actual = nguyenLieuService.getNguyenLieu(ten);
        assertTrue(actual.size()==0);
    }

    @Test
    void get_nguyen_lieu_by_id_test1(){
        NguyenLieuDTO nguyenLieu = nguyenLieuService.getNguyenLieu(109);
        assertTrue(nguyenLieu==null);
    }

    @Test
    void get_nguyen_lieu_by_id_test2(){
        NguyenLieuDTO nguyenLieu = nguyenLieuService.getNguyenLieu(1);
        assertTrue(nguyenLieu.getTen().equals("Kem duong da abc"));
    }

    @Test
    void save_nguyen_lieu_should_success(){
        NguyenLieuDTO nguyenLieuDTO = new NguyenLieuDTO();
        nguyenLieuDTO.setTen("abc");
        nguyenLieuDTO.setTenHangSanXuat("xyz");
        nguyenLieuDTO.setUser(null);
        nguyenLieuService.save(nguyenLieuDTO);
    }
}

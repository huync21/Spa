package com.example.spaapplication;

import com.example.spaapplication.dto.NhaCungCapDTO;
import com.example.spaapplication.service.NhaCungCapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class NhaCungCapServiceTests {
    @Autowired
    private NhaCungCapService nhaCungCapService;

    @Test
    void get_nha_cung_cap_test1() {
        var ten = "cung cap A";
        List<NhaCungCapDTO> expected = new ArrayList<>();
        expected.add(NhaCungCapDTO.builder()
                .id(1).ten("Nha cung cap A")
                .diaChi("số 33 đường abc")
                .build());
        expected.add(NhaCungCapDTO.builder()
                .id(7).ten("nha cung cap A")
                .diaChi("so 32 duong Tran Phu")
                .build());
        List<NhaCungCapDTO> actual = nhaCungCapService.getNhaCungCap(ten);
        boolean condition = true;
        for(int i=0;i<expected.size();i++){
            NhaCungCapDTO e = expected.get(i);
            NhaCungCapDTO a = actual.get(i);
            if( e.getId() != a.getId() || !e.getTen().equals(a.getTen()) || !e.getDiaChi().equals(a.getDiaChi()))
                condition = false;
        }
        assertTrue(expected.size() == actual.size());
        assertTrue(condition == true);
    }

    @Test
    void get_nha_cung_cap_test2() {
        var ten = "sdfgsjkdfbgjkbsdfgjjkbg";
        List<NhaCungCapDTO> actual = nhaCungCapService.getNhaCungCap(ten);
        assertTrue(actual.size()==0);
    }

    @Test
    void get_nha_cung_cap_by_id_test1(){
        NhaCungCapDTO nhaCungCap = nhaCungCapService.getNhaCungCap(3);
        assertTrue(nhaCungCap==null);
    }

    @Test
    void get_nha_cung_cap_by_id_test2(){
        NhaCungCapDTO nhaCungCap = nhaCungCapService.getNhaCungCap(1);
        assertTrue(nhaCungCap.getTen().equals("Nha cung cap A"));
    }

    @Test
    void save_nha_cung_cap(){
        NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
        nhaCungCapDTO.setTen("abc");
        nhaCungCapDTO.setDiaChi("xyz");
        nhaCungCapDTO.setUser(null);
        nhaCungCapService.save(nhaCungCapDTO);
    }
}

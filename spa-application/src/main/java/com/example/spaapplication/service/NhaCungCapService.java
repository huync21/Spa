package com.example.spaapplication.service;

import com.example.spaapplication.dto.NhaCungCapDTO;
import com.example.spaapplication.mapstruct.NhaCungCapMapper;
import com.example.spaapplication.repository.NhaCungCapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhaCungCapService {
    private final NhaCungCapRepository nhaCungCapRepository;
    private final NhaCungCapMapper nhaCungCapMapper;
    public List<NhaCungCapDTO> getNhaCungCap(String ten){
        var listNhaCC = nhaCungCapRepository.findNhaCungCapByTenContains(ten);
        return nhaCungCapMapper.to(listNhaCC);
    }

    public NhaCungCapDTO getNhaCungCap(Integer id){
       var jpaNhaCungCapOpt =  nhaCungCapRepository.findById(id);
       if(jpaNhaCungCapOpt.isPresent()){
           return nhaCungCapMapper.to(jpaNhaCungCapOpt.get());
       }
       return null;
    }

    public void save(NhaCungCapDTO nhaCungCapDTO){
        nhaCungCapRepository.save(nhaCungCapMapper.from(nhaCungCapDTO));
    }
}

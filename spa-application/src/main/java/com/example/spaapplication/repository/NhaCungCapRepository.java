package com.example.spaapplication.repository;

import com.example.spaapplication.entities.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {
    List<NhaCungCap> findNhaCungCapByTenContains(String ten);
}

package com.example.spaapplication.repository;

import com.example.spaapplication.entities.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NguyenLieuRepository extends JpaRepository<NguyenLieu, Integer> {
    List<NguyenLieu> findNguyenLieuByTenContains(String ten);
}

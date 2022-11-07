package com.example.spaapplication.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tblnguyenlieu")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguyenLieu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "ten")
    String ten;
    @Column(name = "ten_hang_san_xuat")
    String tenHangSanXuat;
    @Column(name = "mo_ta")
    String moTa;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    User user;
}
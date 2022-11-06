package com.example.spaapplication.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbllannhap")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanNhap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String moTa;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tbl_nha_cung_cap_id")
    NhaCungCap nhaCungCap;
    @OneToMany(mappedBy = "lanNhap",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<NguyenLieuTrongLanNhap> listNguyenLieuTrongLanNhap;
}

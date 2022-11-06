package com.example.spaapplication.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tblnguyenlieutronglannhap")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguyenLieuTrongLanNhap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer soLuong;
    Double donGia;
    String hanSuDung;
    String xuatSu;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_nguyen_lieu_id")
    NguyenLieu nguyenLieu;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_lan_nhap_id")
    LanNhap lanNhap;
}

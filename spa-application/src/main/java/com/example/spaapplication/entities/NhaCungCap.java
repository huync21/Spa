package com.example.spaapplication.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tblnhacungcap")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhaCungCap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ten;
    String moTa;
    String diaChi;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    User user;
}

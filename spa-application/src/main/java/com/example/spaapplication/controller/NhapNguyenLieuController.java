package com.example.spaapplication.controller;

import com.example.spaapplication.dto.*;
import com.example.spaapplication.service.LanNhapService;
import com.example.spaapplication.service.NguyenLieuService;
import com.example.spaapplication.service.NhaCungCapService;
import com.example.spaapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/nhap-nguyen-lieu")
@RequiredArgsConstructor
public class NhapNguyenLieuController {
    private final UserService userService;
    private final NhaCungCapService nhaCungCapService;
    private final NguyenLieuService nguyenLieuService;
    private final LanNhapService lanNhapService;
    public static String LAN_NHAP = "lanNhap";

    @GetMapping(value = "/tim-nha-cung-cap")
    public String hienThiGDTimNhaCungCap() {
        return "gdTimNhaCungCap";
    }

    @PostMapping(value = "/tim-nha-cung-cap")
    public String timNhaCungCap(@RequestParam String keyword, Model model) {
        var listNhaCungCap = nhaCungCapService.getNhaCungCap(keyword);
        if (CollectionUtils.isEmpty(listNhaCungCap)) {
            model.addAttribute("keyword", keyword);
            model.addAttribute("notFoundLabel", "Không tìm thấy nhà cung cấp!");
            return "gdTimNhaCungCap";
        }
        model.addAttribute("listNhaCungCap", listNhaCungCap);
        return "gdDanhSachNhaCungCap";
    }

    @GetMapping(value = "/nhap-cac-nguyen-lieu")
    public String hienThiGDNhapCacNguyenLieu(@RequestParam Integer nhaCungCapId, HttpSession session, Principal principal) {
        LanNhapDto lanNhapDto = new LanNhapDto();
        UserDto currentLoginUser = userService.findUserByName(principal.getName());
        NhaCungCapDTO nhaCungCap = nhaCungCapService.getNhaCungCap(nhaCungCapId);
        lanNhapDto.setUser(currentLoginUser);
        lanNhapDto.setNhaCungCap(nhaCungCap);
        lanNhapDto.setListNguyenLieuTrongLanNhap(new ArrayList<>());
        session.setAttribute(LAN_NHAP, lanNhapDto);
        return "gdNhapCacNguyenLieu";
    }

    @PostMapping(value = "/tim-nguyen-lieu")
    public String timNguyenLieu(@RequestParam String keyword, Model model) {
        var listNguyenLieu = nguyenLieuService.getNguyenLieu(keyword);
        model.addAttribute("keyword", keyword);
        if (CollectionUtils.isEmpty(listNguyenLieu)) {
            model.addAttribute("notFoundLabel", "Không tìm thấy nguyên liệu!");
        } else {
            model.addAttribute("listNguyenLieu", listNguyenLieu);
        }
        return "gdNhapCacNguyenLieu";
    }

    @GetMapping(value = "/nhap-so-luong-don-gia")
    public String hienThiGDNhapSoLuongDonGia(@RequestParam Integer nguyenLieuId, Model model) {
        model.addAttribute("nguyenLieuId", nguyenLieuId);
        model.addAttribute("nguyenLieuTrongLanNhap", new NguyenLieuTrongLanNhapDTO());
        return "gdNhapSoLuongDonGia";
    }

    @PostMapping(value = "/nhap-so-luong-don-gia")
    public String nhapSoLuongDonGia(@Valid @ModelAttribute("nguyenLieuTrongLanNhap") NguyenLieuTrongLanNhapDTO nguyenLieuTrongLanNhap,
                                    BindingResult bindingResult, Model model,
                                    @RequestParam Integer nguyenLieuId, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("nguyenLieuId", nguyenLieuId);
            return "gdNhapSoLuongDonGia";
        }
        var nguyenLieu = nguyenLieuService.getNguyenLieu(nguyenLieuId);
        nguyenLieuTrongLanNhap.setNguyenLieu(nguyenLieu);
        LanNhapDto lanNhap = (LanNhapDto) session.getAttribute(LAN_NHAP);
        List<NguyenLieuTrongLanNhapDTO> listNguyenLieuTrongLanNhap = lanNhap.getListNguyenLieuTrongLanNhap();
        listNguyenLieuTrongLanNhap.add(nguyenLieuTrongLanNhap);
        lanNhap.setListNguyenLieuTrongLanNhap(listNguyenLieuTrongLanNhap);
        session.setAttribute(LAN_NHAP, lanNhap);
        return "gdNhapCacNguyenLieu";
    }

    @PostMapping(value = "/xac-nhan-lan-nhap")
    public String xacNhapLanNhap(HttpSession session, Model model) {
        LanNhapDto lanNhap = (LanNhapDto) session.getAttribute(LAN_NHAP);
        if (CollectionUtils.isEmpty(lanNhap.getListNguyenLieuTrongLanNhap())) {
            model.addAttribute("chuaNhapNguyenLieuLabel", "Bạn chưa nhập nguyên liệu nào!");
            return "gdNhapCacNguyenLieu";
        }
        lanNhapService.save(lanNhap);
        model.addAttribute("successLabel", "Nhập nguyên liệu thành công!");
        return "gdTimNhaCungCap";
    }

    @GetMapping(value = "/them-nha-cung-cap")
    public String hienThiGDThemNhaCungCap(Model model){
        model.addAttribute("nhaCungCap", new NhaCungCapDTO());
        return "gdThemNhaCungCap";
    }
    @PostMapping(value = "/them-nha-cung-cap")
    public String themNhaCungCap(@Valid @ModelAttribute("nhaCungCap") NhaCungCapDTO nhaCungCap, BindingResult bindingResult,
                                 Model model, Principal principal){
        if(bindingResult.hasErrors())
            return "gdThemNhaCungCap";
        nhaCungCap.setUser(userService.findUserByName(principal.getName()));
        nhaCungCapService.save(nhaCungCap);
        model.addAttribute("labelThemNhaCCSuccess", "Thêm thành công nhà cung cấp!");
        return "gdTimNhaCungCap";
    }

    @GetMapping(value = "/them-nguyen-lieu")
    public String hienThiGDThemNguyenLieu(Model model){
        model.addAttribute("nguyenLieu", new NguyenLieuDTO());
        return "gdThemNguyenLieu";
    }

    @PostMapping(value = "/them-nguyen-lieu")
    public String themNguyenLieu(@Valid @ModelAttribute("nguyenLieu") NguyenLieuDTO nguyenLieu, BindingResult bindingResult,
                                 Model model, Principal principal){
        if(bindingResult.hasErrors())
            return "gdThemNguyenLieu";
        nguyenLieu.setUser(userService.findUserByName(principal.getName()));
        nguyenLieuService.save(nguyenLieu);
        model.addAttribute("labelThemNguyenLieuSuccess", "Thêm thành công nguyên liệu!");
        return "gdNhapCacNguyenLieu";
    }
}

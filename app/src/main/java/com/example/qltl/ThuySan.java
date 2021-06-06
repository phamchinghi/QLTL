package com.example.qltl;

import java.io.Serializable;

public class ThuySan implements Serializable {
    private double tongKg,thanhTien,giaMua,giaBan;
    private String name,tenKH;

    public ThuySan(double tongKg, double thanhTien, double giaMua, String name, String tenKH) {
        this.tongKg = tongKg;
        this.thanhTien = thanhTien;
        this.giaMua = giaMua;
        this.name = name;
        this.tenKH = tenKH;
    }

    public ThuySan(String name, String tenKH, double tongKg, double thanhTien) {
        this.name = name;
        this.tenKH = tenKH;
        this.tongKg = tongKg;
        this.thanhTien = thanhTien;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(double giaMua) {
        this.giaMua = giaMua;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public double getTongKg() {
        return tongKg;
    }

    public void setTongKg(int tongKg) {
        this.tongKg = tongKg;
    }

    public double getthanhTien() {
        return thanhTien;
    }

    public void setthanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}

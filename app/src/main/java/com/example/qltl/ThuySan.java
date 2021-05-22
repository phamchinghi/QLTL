package com.example.qltl;

public class ThuySan {
    private int resourceId;
    private String name,tenKH,tongKg,thanhTien,soTien;

    public ThuySan(int resourceId, String name, String tenKH, String tongKg, String thanhTien, String soTien) {
        this.resourceId = resourceId;
        this.name = name;
        this.tenKH = tenKH;
        this.tongKg = tongKg;
        this.thanhTien = thanhTien;
        this.soTien = soTien;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
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

    public String getTongKg() {
        return tongKg;
    }

    public void setTongKg(String tongKg) {
        this.tongKg = tongKg;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = "0";
    }
}

package com.example.qltl;

public class ThuySan {
    private int resourceId,tongKg,soTien;
    private String name,tenKH;

    public ThuySan(int resourceId, String name, String tenKH, int tongKg, int soTien) {
        this.resourceId = resourceId;
        this.name = name;
        this.tenKH = tenKH;
        this.tongKg = tongKg;
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

    public int getTongKg() {
        return tongKg;
    }

    public void setTongKg(int tongKg) {
        this.tongKg = tongKg;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
}

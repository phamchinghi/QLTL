package com.example.qltl;

import android.widget.ListView;

public class ThuySan {
    protected String ten;
    protected int soKg;

    public ThuySan() {
    }

    public ThuySan(String ten, int soKg) {
        this.ten = ten;
        this.soKg = soKg;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoKg() {
        return soKg;
    }

    public void setSoKg(int soKg) {
        this.soKg = soKg;
    }

}

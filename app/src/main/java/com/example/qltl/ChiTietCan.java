package com.example.qltl;

public class ChiTietCan {
    private int id;
    private float soKGMoiLanCan;

    public ChiTietCan(int id, float soKGMoiLanCan) {
        this.id = id;
        this.soKGMoiLanCan = soKGMoiLanCan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSoKGMoiLanCan() {
        return soKGMoiLanCan;
    }

    public void setSoKGMoiLanCan(float soKGMoiLanCan) {
        this.soKGMoiLanCan = soKGMoiLanCan;
    }
}

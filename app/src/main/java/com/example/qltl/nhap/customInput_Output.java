package com.example.qltl.nhap;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.example.qltl.R;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

public class customInput_Output extends LinearLayout {

    private TabLayout tabLayout;
    private customViewPager viewPager;
    private Button btnList;
    private EditText edt_khachHang;
    private EditText edtLoai;
    private EditText edtGiaMua;
    private EditText edtSdt;
    private EditText edtDiachi;
    private EditText edt_con_kg;
    private EditText edt_tim_kiem;
    private ImageButton imgBtn_search;
    private Button btnCancel;
    private  Button btnYes;
    private  Button btnThongBao;
    customThu customThu;
    Context context;

    public String getEdtLoai() {
        return edtLoai.getText().toString();
    }

    public void setEdtLoai(EditText edtLoai) {
        this.edtLoai = edtLoai;
    }

    public String getEdt_khachHang() {
        return edt_khachHang.getText().toString();
    }

    public void setEdt_khachHang(EditText edt_khachHang) {
        this.edt_khachHang = edt_khachHang;
    }

    public customInput_Output(Context context) {
        super(context);
    }

    public customInput_Output(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        IntializeUILayout();
        customDialog customDialog = new customDialog(context);
        btnList.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupMenu();
            }
        });
        //su kien cho nut tim kiem
        imgBtn_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edt_tim_kiem.getText().toString();
                if(value.length() == 0) {
                    createDialogThongbao();
                }else{
                    createDialog();
                }
            }
        });
    }

    private void IntializeUILayout(){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_input_output,this);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);
        btnList = view.findViewById(R.id.btnList);
        edt_tim_kiem = view.findViewById(R.id.edt_tim_kiem);
        imgBtn_search = view.findViewById(R.id.imgBtn_search);
    }
    private void createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(context, btnList);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tom:
                    case R.id.cua:
                    case R.id.ca:
                    case R.id.so:
                    case R.id.muc:
                        createDialog();
                        edtLoai.setHint("Loại "+item.getTitle());
                        break;
                    case R.id.ngheu:
                    case R.id.luon:
                        createDialog();
                        edt_con_kg.setVisibility(GONE);
                        edtLoai.setVisibility(GONE);
                        break;
                    default:
                }

                return true;
            }
        });
        popupMenu.show();
    }

    private void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog_input, viewGroup, false);
        edt_khachHang = dialogView.findViewById(R.id.edt_ten);
        edtLoai = dialogView.findViewById(R.id.edt_loai);
        edtGiaMua = dialogView.findViewById(R.id.edt_gia_mua);
        edtSdt = dialogView.findViewById(R.id.edt_sdt);
        edtDiachi = dialogView.findViewById(R.id.edt_dia_chi);
        edt_con_kg = dialogView.findViewById(R.id.con_kg);
        btnCancel = dialogView.findViewById(R.id.btn_cancel);
        btnYes = dialogView.findViewById(R.id.btn_yes);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(Gravity.BOTTOM == getGravity());
        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
        alertDialog.show();
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btnYes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtLoai.getVisibility() == VISIBLE && edt_con_kg.getVisibility() == VISIBLE) {
                    if (edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtLoai.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0
                            || edt_con_kg.getText().toString().length() == 0) {
                        createDialogThongbaoDienThongTin();
                    }else{
                        //Goi cai activity moi ra
                        Intent intent = new Intent(context,ChiTietThuActivity.class);
                        getContext().startActivity(intent);

                        alertDialog.dismiss();
                    }
                }else {
                    if(edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0){
                        createDialogThongbaoDienThongTin();
                    }else {
                        //goi cai activity moi ra


                    }
                }
            }
        });

    }
    private void createDialogThongbao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog_thongbao, viewGroup, false);

        btnThongBao = dialogView.findViewById(R.id.btn_thongbao_ok);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(Gravity.BOTTOM == getGravity());

        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
        alertDialog.show();

        btnThongBao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void createDialogThongbaoDienThongTin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog_thongbao_dienthongtin, viewGroup, false);

        btnThongBao = dialogView.findViewById(R.id.btn_thongbao_ok);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(Gravity.BOTTOM == getGravity());//set khong cho bam ra phia ngoai dialog

        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
        alertDialog.show();

        btnThongBao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
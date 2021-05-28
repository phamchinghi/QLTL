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

import com.example.qltl.MainActivity;
import com.example.qltl.R;
import com.example.qltl.ThuySan;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

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
//    private Button btnCancel;
//    private  Button btnYes;
//    private  Button btnThongBao;
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
        customDialog customDialogg = new customDialog(context);
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
                   customDialogg.createDialogThongbao();
                }else{
                    customDialogg.createDialog();
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
        customDialog customDialogg = new customDialog(context);
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
                        customDialogg.createDialog();
//                        edtLoai.setHint("Loại "+item.getTitle());
                        break;
                    case R.id.ngheu:
                    case R.id.luon:
                        customDialogg.createDialog();
//                        edt_con_kg.setVisibility(GONE);
//                        edtLoai.setVisibility(GONE);
                        break;
                    default:
                }

                return true;
            }
        });
        popupMenu.show();
    }
}
package com.example.qltl.nhap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.qltl.MainActivity;
import com.example.qltl.R;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class customInput_Output extends LinearLayout {

    private TabLayout tabLayout;
    private customViewPager viewPager;
    private Button btnList;
    private EditText khachHang;
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
    Context context;


    public customInput_Output(Context context) {
        super(context);
    }

    public customInput_Output(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        IntializeUILayout();

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
        khachHang = dialogView.findViewById(R.id.edt_ten);
        edtLoai = dialogView.findViewById(R.id.edt_loai);
        edtGiaMua = dialogView.findViewById(R.id.edt_gia_mua);
        edtSdt = dialogView.findViewById(R.id.edt_sdt);
        edtDiachi = dialogView.findViewById(R.id.edt_dia_chi);
        edt_con_kg = dialogView.findViewById(R.id.con_kg);
        btnCancel = dialogView.findViewById(R.id.btn_cancel);
        btnYes = dialogView.findViewById(R.id.btn_yes);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        if(Gravity.BOTTOM == getGravity()){
            alertDialog.setCancelable(true);
        }else{
            alertDialog.setCancelable(false);
        }
        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
        alertDialog.show();
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
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

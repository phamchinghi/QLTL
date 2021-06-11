package com.example.qltl.nhap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.qltl.R;
import com.example.qltl.adapter.IconThuySanAdapter;

public class customDialog extends LinearLayout {

    private EditText edt_khachHang;
    private EditText edtLoai;
    private EditText edtGiaMua;
    private EditText edtSdt;
    private EditText edtDiachi;
    private EditText edt_con_kg;
    private Button btnCancel;
    private  Button btnYes;
    private Button btnThongBao;
    Context context;
    IconThuySanAdapter iconThuySanAdapter;

    public customDialog(Context context) {
        super(context);
    }

    public customDialog(Context context, @Nullable AttributeSet attrs, Context context1) {
        super(context, attrs);
        this.context = context1;
        IntializeUILayout();
    }

    private void IntializeUILayout(){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_dialog_input,this);
        edt_khachHang = view.findViewById(R.id.edt_ten);
        edtLoai = view.findViewById(R.id.edt_loai);
        edtGiaMua = view.findViewById(R.id.edt_gia_mua);
        edtSdt = view.findViewById(R.id.edt_sdt);
        edtDiachi = view.findViewById(R.id.edt_dia_chi);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnYes = view.findViewById(R.id.btn_yes);
    }

    public void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog_input, viewGroup, false);
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
//        edt_con_kg.setVisibility(GONE);
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btnYes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_con_kg.getVisibility() == VISIBLE) {
                    if (edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtLoai.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0
                            || edt_con_kg.getText().toString().length() == 0) {
                        createDialogThongbaoDienThongTin();
                    }else{
                        //Goi cai activity moi ra
                        Intent intent = new Intent(getContext(), ChiTietThuActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("tenKH", edt_khachHang.getText().toString());
                        bundle.putString("sdt", edtSdt.getText().toString());
                        bundle.putString("diachi", edtDiachi.getText().toString());
                        bundle.putDouble("gia", Double.parseDouble(edtGiaMua.getText().toString())); ;
                        bundle.putString("loai", edtLoai.getText().toString());
                        bundle.putInt("conkg", Integer.parseInt(edt_con_kg.getText().toString()));

                        intent.putExtra("data", bundle);
                        getContext().startActivity(intent);
                        alertDialog.dismiss();
                    }
                }else {
                    if(edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0
                            || edtLoai.getText().toString().length() == 0){
                        createDialogThongbaoDienThongTin();
                    }else {
                        //goi cai activity moi ra
                        Intent intent = new Intent(getContext(), ChiTietThuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("tenKH", edt_khachHang.getText().toString());
                        bundle.putDouble("gia", Double.parseDouble(edtGiaMua.getText().toString()));
                        bundle.putString("sdt", edtSdt.getText().toString());
                        bundle.putString("diachi", edtDiachi.getText().toString());
                        bundle.putString("loai", edtLoai.getText().toString());

                        intent.putExtra("data", bundle);
                        getContext().startActivity(intent);
                        alertDialog.dismiss();
                    }
                }
            }
        });
    }

    public void createDialogNoneConKg(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog_input_none_conkg, viewGroup, false);
        edt_khachHang = dialogView.findViewById(R.id.edt_ten);
        edtLoai = dialogView.findViewById(R.id.edt_loai);
        edtGiaMua = dialogView.findViewById(R.id.edt_gia_mua);
        edtSdt = dialogView.findViewById(R.id.edt_sdt);
        edtDiachi = dialogView.findViewById(R.id.edt_dia_chi);
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
                if(edt_con_kg.getVisibility() == VISIBLE) {
                    if (edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtLoai.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0) {
                        createDialogThongbaoDienThongTin();
                    }else{
                        //Goi cai activity moi ra
                        Intent intent = new Intent(getContext(), ChiTietThuActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("tenKH", edt_khachHang.getText().toString());
                        bundle.putString("sdt", edtSdt.getText().toString());
                        bundle.putString("diachi", edtDiachi.getText().toString());
                        bundle.putDouble("gia", Double.parseDouble(edtGiaMua.getText().toString())); ;
                        bundle.putString("loai", edtLoai.getText().toString());

                        intent.putExtra("data", bundle);
                        getContext().startActivity(intent);
                        alertDialog.dismiss();
                    }
                }else {
                    if(edt_khachHang.getText().toString().length() == 0
                            || edtSdt.getText().toString().length() == 0
                            || edtDiachi.getText().toString().length() == 0
                            || edtGiaMua.getText().toString().length() == 0
                            || edtLoai.getText().toString().length() == 0){
                        createDialogThongbaoDienThongTin();
                    }else {
                        //goi cai activity moi ra
                        Intent intent = new Intent(getContext(), ChiTietThuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("tenKH", edt_khachHang.getText().toString());
                        bundle.putDouble("gia", Double.parseDouble(edtGiaMua.getText().toString()));
                        bundle.putString("sdt", edtSdt.getText().toString());
                        bundle.putString("diachi", edtDiachi.getText().toString());
                        bundle.putString("loai", edtLoai.getText().toString());

                        intent.putExtra("data", bundle);
                        getContext().startActivity(intent);
                        alertDialog.dismiss();
                    }
                }
            }
        });
    }

    public void createDialogThongbao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog_thongbao, viewGroup, false);

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

    public void createDialogThongbaoDienThongTin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog_thongbao_dienthongtin, viewGroup, false);

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

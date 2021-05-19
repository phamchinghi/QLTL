package com.example.qltl.nhap;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
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

public class customDialog extends LinearLayout {

    private EditText khachHang;
    private EditText edtLoai;
    private EditText edtGiaMua;
    private EditText edtSdt;
    private EditText edtDiachi;
    private Button btnCancel;
    private  Button btnYes;
    Context context;

    public customDialog(Context context) {
        super(context);
    }

    public customDialog(Context context, EditText khachHang, EditText edtLoai, EditText edtGiaMua, EditText edtSdt, EditText edtDiachi, Button btnCancel, Button btnYes, Context context1) {
        super(context);
        this.khachHang = khachHang;
        this.edtLoai = edtLoai;
        this.edtGiaMua = edtGiaMua;
        this.edtSdt = edtSdt;
        this.edtDiachi = edtDiachi;
        this.btnCancel = btnCancel;
        this.btnYes = btnYes;
        this.context = context1;
        IntializeUILayout();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
            }
        });
//        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
//        getDialog().show();

//        return view;
    }

    private void IntializeUILayout(){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_dialog_input,this);
        khachHang = view.findViewById(R.id.edt_ten);
        edtLoai = view.findViewById(R.id.edt_loai);
        edtGiaMua = view.findViewById(R.id.edt_gia_mua);
        edtSdt = view.findViewById(R.id.edt_sdt);
        edtDiachi = view.findViewById(R.id.edt_dia_chi);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnYes = view.findViewById(R.id.btn_yes);
    }
    private void getDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog_input, viewGroup, false);


    }
}

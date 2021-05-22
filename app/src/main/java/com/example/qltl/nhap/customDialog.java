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


}

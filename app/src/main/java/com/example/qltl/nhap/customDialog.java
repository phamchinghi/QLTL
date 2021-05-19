package com.example.qltl.nhap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.qltl.R;

public class customDialog extends DialogFragment {
    private static final String TAG = "customDialog";

    private EditText khachHang;
    private EditText edtLoai;
    private EditText edtGiaMua;
    private EditText edtSdt;
    private EditText edtDiachi;
    private Button btnCancel;
    private  Button btnYes;

    public customDialog() {
        super();
    }

    public customDialog(EditText edtLoai) {
        this.edtLoai = edtLoai;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog_input, container, false);

        khachHang = view.findViewById(R.id.edt_ten);
        edtLoai = view.findViewById(R.id.edt_loai);
        edtGiaMua = view.findViewById(R.id.edt_gia_mua);
        edtSdt = view.findViewById(R.id.edt_sdt);
        edtDiachi = view.findViewById(R.id.edt_dia_chi);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnYes = view.findViewById(R.id.btn_yes);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
//        btnYes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext().getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
//            }
//        });
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog_in_output);
        getDialog().show();

        return view;
    }

    public void setHint(String str){
        edtLoai.setHint(str);
    }

}

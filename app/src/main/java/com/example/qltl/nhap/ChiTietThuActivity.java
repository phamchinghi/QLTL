package com.example.qltl.nhap;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qltl.ChiTietCan;
import com.example.qltl.ChiTietcanAdapter;
import com.example.qltl.MainActivity;
import com.example.qltl.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ChiTietThuActivity extends Activity {
    private ImageButton ibtn_apply;
    private Button btnNhap;
    private Button btnThongBao;
    private RecyclerView rcvChiTietCan;
    private TextView txttenKH;
    private TextView txtLoaiTS;
    private TextView txtgiaMua;
    private TextView txtTongKg;
    private EditText edtSokg;
    private int id = 1;
    ArrayList<ChiTietCan> listcan;
    private ChiTietcanAdapter chiTietcanAdapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thu);
        ibtn_apply = findViewById(R.id.imgBtn_apply);
        btnNhap = findViewById(R.id.btn_nhap);
        edtSokg = findViewById(R.id.edt_sokg);
        rcvChiTietCan = findViewById(R.id.rcv_chitietcan);
        txttenKH = findViewById(R.id.txt_tenKH);
        txtLoaiTS = findViewById(R.id.txt_ten_thuysan_thu);
        txtgiaMua = findViewById(R.id.txt_gia_mua_vao);
        txtTongKg = findViewById(R.id.txt_tongkg);
        ibtn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietThuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        String tenKH = bundle.getString("tenKH");
        String loaiTS = bundle.getString("loai");
        int giaMua = bundle.getInt("gia");


        txttenKH.setText(tenKH);
        txtLoaiTS.setText(loaiTS);

        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        txtgiaMua.setText(currencyFormatter.format(giaMua));

        listcan = new ArrayList<>();

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiTietcanAdapter = new ChiTietcanAdapter(context);
                listcan.add(new ChiTietCan(id, Float.parseFloat(edtSokg.getText().toString())));
                chiTietcanAdapter.setData(listcan);
//                caculateKhoiLuong();
                txtTongKg.setText(caculateKhoiLuong().toString());
                edtSokg.setText("");
                edtSokg.setHint("Nhập số kg");

                id++;


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                rcvChiTietCan.setLayoutManager(linearLayoutManager);

                rcvChiTietCan.setHasFixedSize(true);
                rcvChiTietCan.setAdapter(chiTietcanAdapter);
            }
        });
    }
    private Float caculateKhoiLuong(){
        float sum =0;
        for (int i=0;i< listcan.size();i++){
            sum = sum + listcan.get(i).getSoKGMoiLanCan();
        }
        return sum;
    }
}
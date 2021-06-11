package com.example.qltl.nhap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qltl.ChiTietCan;
import com.example.qltl.MainActivity;
import com.example.qltl.adapter.ChiTietcanAdapter;
import com.example.qltl.R;
import com.example.qltl.ThuySan;
import com.example.qltl.input_output;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChiTietThuActivity extends AppCompatActivity {
    private ImageButton ibtn_apply;
    private Button btnNhap;
    private RecyclerView rcvChiTietCan;
    private TextView txttenKH;
    private TextView txtLoaiTS;
    private TextView txtgiaMua;
    private TextView txtTongKg;
    private EditText edtSokg;
    private TextView txtconKg;
    private int id = 1;
    ArrayList<ChiTietCan> listcan;
    List<ThuySan> list = new ArrayList<>();
    private ChiTietcanAdapter chiTietcanAdapter;
    Context context;
    Intent intent;
    Bundle bundle;
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
        txtconKg = findViewById(R.id.txt_so_con_kg);

        intent = getIntent();
        bundle = intent.getBundleExtra("data");
        bundle.getBundle("data");
        String tenKH = bundle.getString("tenKH");
        String loaiTS = bundle.getString("loai");
        double giaMua = bundle.getDouble("gia");
        int conKg = bundle.getInt("conkg");

        ibtn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senDataToFragmentThu();
            }
        });


        txttenKH.setText(tenKH);
        txtLoaiTS.setText(loaiTS);
        txtconKg.setText(String.valueOf(conKg));
        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        txtgiaMua.setText(currencyFormatter.format(giaMua));
        listcan = new ArrayList<>();

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSokg.getText().toString().length()!=0) {
                    chiTietcanAdapter = new ChiTietcanAdapter(context);
                    listcan.add(new ChiTietCan(id, Float.parseFloat(edtSokg.getText().toString())));
                    chiTietcanAdapter.setData(listcan);
                    txtTongKg.setText(caculateKhoiLuong().toString());
                    edtSokg.setText("");
                    edtSokg.setHint("Nhập số kg");

                    id++;

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                    rcvChiTietCan.setLayoutManager(linearLayoutManager);

                    rcvChiTietCan.setHasFixedSize(true);
                    rcvChiTietCan.setAdapter(chiTietcanAdapter);
                }else {

                }
            }
        });
    }
    Bundle bundle1 = new Bundle();
    private void senDataToFragmentThu() {
        Intent intent1 = new Intent(this, MainActivity.class);
        ThuySan ts = new ThuySan(txtLoaiTS.getText().toString(), txttenKH.getText().toString(), caculateKhoiLuong(), caculateTongTien());
        bundle1.putSerializable("objTS", ts);

        intent1.putExtra("objdata", bundle1);
        startActivity(intent1);
    }

    private Double caculateKhoiLuong(){
        double sum = 0;
        for (int i=0;i< listcan.size();i++){
            sum = sum + listcan.get(i).getSoKGMoiLanCan();
        }
        return Math.ceil(sum*100.0)/100.0;
    }

    private Double caculateTongTien(){
        double thanhTien = 0;
        intent = getIntent();
        bundle = intent.getBundleExtra("data");
        bundle.getBundle("data");
        double giaMua = bundle.getDouble("gia");
//        Locale locale = new Locale("vn", "VN");
//        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return Double.valueOf(giaMua*caculateKhoiLuong());
    }
//    public List<ThuySan> setDataThuySan(List<ThuySan> list){
//        Intent intent1 = getIntent();
//        ThuySan ts1 = (ThuySan) intent1.getSerializableExtra("objTS");
//
//        list.add(ts1);
//
//        thuySanAdapter.setData(list);
//        rcvThuySan.setAdapter(thuySanAdapter);
//        return list;
//    }


}
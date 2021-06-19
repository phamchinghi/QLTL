package com.example.qltl.nhap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qltl.CALENDAR.DBStructure;
import com.example.qltl.ChiTietCan;
import com.example.qltl.DB.Database;
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
    Database database;
    Cursor getSQLKH,getSQLTS,getSQLPM,getSQLCTMUA;
    private static final String createTable_KH = "CREATE TABLE IF NOT EXISTS "+ DBStructure.TABLE_KH+"("+DBStructure.MAKH+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DBStructure.TENKH+" NVARCHAR(30), "+DBStructure.SDT+" VARCHAR(10), "+DBStructure.DIACHI+" NVARCHAR(50))";
    private static final String createTable_TS = "CREATE TABLE IF NOT EXISTS "+ DBStructure.TABLE_TS+"("+DBStructure.MATS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DBStructure.TENTS+" NVARCHAR(30)," +DBStructure.GIAMUA+" VARCHAR(8))";
    private static final String createTable_PHIEUMUA = "CREATE TABLE IF NOT EXISTS "+ DBStructure.TABLE_PHIEUMUA+"("+DBStructure.MAPM+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DBStructure.MAKH_PM+" NVARCHAR(30),  FOREIGN KEY ("+DBStructure.MAKH_PM+")"+" REFERENCES "+DBStructure.TABLE_KH+"("+DBStructure.MAKH+"))";
    private static final String createTable_CTMUA = "CREATE TABLE IF NOT EXISTS "+DBStructure.TABLE_CTMUA+"("
            +DBStructure.MAPM_CTPM+" INTEGER, "
            +DBStructure.MAKH_CTPM+" INTEGER, "
            +DBStructure.MATS_CTPM+" INTEGER, "
            +DBStructure.DVT+" TEXT, "
            +DBStructure.SOKG+" TEXT, " +
            "FOREIGN KEY ("+DBStructure.MAKH_CTPM+") "+" REFERENCES "+DBStructure.TABLE_PHIEUMUA+"("+DBStructure.MAKH_PM+"),"+
            "FOREIGN KEY ("+DBStructure.MAPM_CTPM+") "+" REFERENCES "+DBStructure.TABLE_PHIEUMUA+"("+DBStructure.MAPM+")," +
            "FOREIGN KEY ("+DBStructure.MATS_CTPM+") "+" REFERENCES "+DBStructure.TABLE_TS+"("+DBStructure.MATS+"))";
    private static final String createTable_TK = "CREATE TABLE IF NOT EXISTS "+DBStructure.TABLE_THONGKE+"("
            +DBStructure.SOPHIEUTK+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +DBStructure.MAPM_TK+" INTEGER, "
            +DBStructure.MAKH_TK+" INTEGER, "
            +DBStructure.MATS_TK+" INTEGER, "
            +DBStructure.GIAMUA_TK+" VARCHAR(8), "
            +DBStructure.TONGKG+" TEXT,"
            +DBStructure.THANHTIEN+" TEXT, " +
            "FOREIGN KEY ("+DBStructure.MAPM_TK+") "+" REFERENCES "+DBStructure.TABLE_CTMUA+"("+DBStructure.MAPM_CTPM+"),"+
            "FOREIGN KEY ("+DBStructure.MAKH_TK+") "+" REFERENCES "+DBStructure.TABLE_CTMUA+"("+DBStructure.MAKH_CTPM+"),"+
            "FOREIGN KEY ("+DBStructure.MATS_TK+") "+" REFERENCES "+DBStructure.TABLE_CTMUA+"("+DBStructure.MATS_CTPM+"))";
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
        int makh = bundle.getInt("maKH");
        int mapm = bundle.getInt("maPM");
        int maTS = bundle.getInt("maTS");
        String tenKH = bundle.getString("tenKH");
        String loaiTS = bundle.getString("loai");
        double giaMua = bundle.getDouble("gia");
        String sdt = bundle.getString("sdt");
        String diaChi = bundle.getString("diachi");
        int conKg = bundle.getInt("conkg");

        database = new Database(getApplicationContext(), DBStructure.DB_NAME, null,DBStructure.DB_VERSION);

//        database.QueryData("DROP TABLE "+DBStructure.TABLE_KH);
//        database.QueryData("DROP TABLE "+DBStructure.TABLE_TS);
//        database.QueryData("DROP TABLE "+DBStructure.TABLE_PHIEUMUA);
//        database.QueryData("DROP TABLE "+DBStructure.TABLE_CTMUA);
//        database.QueryData("DROP TABLE "+DBStructure.TABLE_THONGKE);


        database.QueryData(createTable_KH);
        database.QueryData(createTable_TS);
        database.QueryData(createTable_PHIEUMUA);
        database.QueryData(createTable_CTMUA);
        database.QueryData(createTable_TK);
        String insertTable_KH = "INSERT INTO "+DBStructure.TABLE_KH + "(" +DBStructure.MAKH+","+DBStructure.TENKH+","+DBStructure.SDT+","+DBStructure.DIACHI+ ")"+
                " VALUES("+makh+", '"+tenKH+"', '"+sdt+"', '"+diaChi+"')";
        String insertTable_TS = "INSERT INTO "+DBStructure.TABLE_TS+"("+DBStructure.MATS+", "+DBStructure.TENTS+", "+DBStructure.GIAMUA+")" +
                "VALUES( "+maTS+", '"+loaiTS+"', '"+giaMua+"')";

        database.QueryData(insertTable_KH);
        database.QueryData(insertTable_TS);

        getSQLKH = database.getData("SELECT * FROM "+DBStructure.TABLE_KH);
        getSQLTS = database.getData("SELECT * FROM "+DBStructure.TABLE_TS);
        while (getSQLKH.moveToNext()) {
            int maKH = getSQLKH.getInt(0);
            String insertTable_PM = "INSERT INTO " + DBStructure.TABLE_PHIEUMUA + "(" + DBStructure.MAPM + "," + DBStructure.MAKH_PM + ")" +
                    "VALUES (" + mapm + "," + maKH + ")";
            database.QueryData(insertTable_PM);
        }
        getSQLPM = database.getData("SELECT * FROM "+DBStructure.TABLE_PHIEUMUA);


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
                    String sokg = edtSokg.getText().toString();
                    chiTietcanAdapter = new ChiTietcanAdapter(context);
                    listcan.add(new ChiTietCan(id, Float.parseFloat(edtSokg.getText().toString())));
                    chiTietcanAdapter.setData(listcan);
                    txtTongKg.setText(caculateKhoiLuong().toString());
                    id++;

                    String insertTable_CTMUA = "INSERT INTO "+DBStructure.TABLE_CTMUA+"("+DBStructure.MAPM_CTPM+", "+DBStructure.MAKH_CTPM+", "+DBStructure.MATS_CTPM+", "+DBStructure.DVT+", "+DBStructure.SOKG+")"+
                            "VALUES("+mapm+", "+makh+", "+maTS+", "+null+","+sokg+")";
                    getSQLCTMUA = database.getData("SELECT * FROM "+DBStructure.TABLE_CTMUA);
                    database.QueryData(insertTable_CTMUA);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                    rcvChiTietCan.setLayoutManager(linearLayoutManager);

                    rcvChiTietCan.setHasFixedSize(true);
                    rcvChiTietCan.setAdapter(chiTietcanAdapter);
                    edtSokg.setText("");
                    edtSokg.setHint("Nhập số kg");
                    Toast.makeText(getApplicationContext(), getSQLCTMUA.getString(4), Toast.LENGTH_SHORT).show();
                }else {
                    new customDialog(getApplicationContext()).createDialogThongbaoDienThongTin();
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
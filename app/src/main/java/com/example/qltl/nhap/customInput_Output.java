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
    private Button btnCancel;
    private  Button btnYes;
    Context context;


    public customInput_Output(Context context) {
        super(context);
    }

    public customInput_Output(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        IntializeUILayout();
        createPopupMenu();

        btnList.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupMenu();
            }
        });
    }

    private void IntializeUILayout(){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_input_output,this);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);
        btnList = view.findViewById(R.id.btnList);

    }
    private void createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(context, btnList);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tom:
                        createDialog();
                        edtLoai.setHint("Loại "+item.getTitle());
                        break;
                    case R.id.cua:
                        createDialog();
                        edtLoai.setHint("Loại "+item.getTitle());
                        break;
                    case R.id.ca:
                        createDialog();
                        edtLoai.setHint("Loại "+item.getTitle());
                        break;
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
   
}

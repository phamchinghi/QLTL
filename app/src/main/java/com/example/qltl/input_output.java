package com.example.qltl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.qltl.IconThuySan;
import com.example.qltl.R;
import com.example.qltl.ThuySan;
import com.example.qltl.adapter.IconThuySanAdapter;

import com.example.qltl.adapter.ThuySanAdapter;
//import com.example.qltl.adapter.nhapViewPagerAdapter;
import com.example.qltl.nhap.customDialog;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class input_output extends Fragment {

    Context context;
    private TabLayout tabLayout;
    private customViewPager viewPager;
    private RecyclerView rcvThuySan;
    ThuySanAdapter thuySanAdapter;
    private Button btnList;
    ThuySan ts;
    Intent intent;
    customDialog customDialog;
    Bundle bundle;
    private RecyclerView rcv_icon;
    private IconThuySanAdapter iconThuySanAdapter;
    List<ThuySan> list = new ArrayList<>();
    View view;
    public input_output() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_output, container, false);

        btnList = view.findViewById(R.id.btnList);
        rcvThuySan = view.findViewById(R.id.recycle_view_thu);
        rcv_icon = view.findViewById(R.id.rcv_ds_icon_thuysan);

        iconThuySanAdapter = new IconThuySanAdapter(context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        rcv_icon.setLayoutManager(gridLayoutManager);
        iconThuySanAdapter.setData(setDataIcon());
        rcv_icon.setAdapter(iconThuySanAdapter);

        thuySanAdapter = new ThuySanAdapter(getContext());

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initUI();
                if (bundle == null){
                    new customDialog(getContext()).createDialogThongbaoDienThongTin();
                }
            }
        });
        return view;
    }
    private void initUI(){
        intent = getActivity().getIntent();
        bundle = intent.getBundleExtra("objdata");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);

        if(bundle != null){
            ts = (ThuySan) bundle.getSerializable("objTS");
            list.add(ts);
            thuySanAdapter.setData(list);
            rcvThuySan.setLayoutManager(linearLayoutManager);
            rcvThuySan.setAdapter(thuySanAdapter);
            bundle.remove("objTS");
        }else{
            new customDialog(getContext()).createDialogThongbaoDienThongTin();
        }

    }

    private List<IconThuySan> setDataIcon(){
        List<IconThuySan> listIcon = new ArrayList<>();
        listIcon.add(new IconThuySan(R.drawable.ic_shrimp, "Tôm"));
        listIcon.add(new IconThuySan(R.drawable.ic_crab, "Cua"));
        listIcon.add(new IconThuySan(R.drawable.ic_fish, "Cá"));
        listIcon.add(new IconThuySan(R.drawable.ic_clam, "Nghêu"));
        listIcon.add(new IconThuySan(R.drawable.ic_shell, "Sò"));
        listIcon.add(new IconThuySan(R.drawable.ic_octopus, "Mực"));
        return listIcon;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        int soTien = requireArguments().get
    }
//    public void setDataa(){
//        Intent intent1 = getIntent();
//        ThuySan ts1 = (ThuySan) intent1.getSerializableExtra("objTS");
//
//        list.add(ts1);
//        thuySanAdapter = new ThuySanAdapter(getContext());
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
//        rcvThuySan.setLayoutManager(linearLayoutManager);
//        thuySanAdapter.setData(list);
//        rcvThuySan.setAdapter(thuySanAdapter);
//
//    }

}
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
import com.example.qltl.adapter.nhapViewPagerAdapter;
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

    List<ThuySan> list = new ArrayList<>();
    public input_output() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_output, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);
        btnList = view.findViewById(R.id.btnList);
        rcvThuySan = view.findViewById(R.id.recycle_view_thu);
        nhapViewPagerAdapter adapterViewPager = new nhapViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initUI();
            }
        });

        return view;
    }
    private void initUI(){
        intent = getActivity().getIntent();

        Bundle bundle = intent.getBundleExtra("objdata");
        if(bundle != null){
            ts = (ThuySan) bundle.getSerializable("objTS");
            thuySanAdapter = new ThuySanAdapter(getContext());
            list.add(ts);
            thuySanAdapter.setData(list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
            rcvThuySan.setLayoutManager(linearLayoutManager);
            rcvThuySan.setAdapter(thuySanAdapter);
//            bundle.clear();
        }else{
            new customDialog(getContext()).createDialogThongbaoDienThongTin();
        }

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
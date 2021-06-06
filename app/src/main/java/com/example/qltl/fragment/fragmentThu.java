package com.example.qltl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.IconThuySan;
import com.example.qltl.MainActivity;
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


public class fragmentThu extends Fragment {
    Context context;
    private TabLayout tabLayout;
    private customViewPager viewPager;
    private RecyclerView rcv_icon;
    private IconThuySanAdapter iconThuySanAdapter;

    List<ThuySan> list = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thu, container, false);
        // Inflate the layout for this fragment
//        intent1 = getActivity().getIntent();
//
        initUI();

        return view;
    }
    private void initUI(){

        rcv_icon = view.findViewById(R.id.rcv_ds_icon_thuysan);

        iconThuySanAdapter = new IconThuySanAdapter(context);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        rcv_icon.setLayoutManager(gridLayoutManager);

        iconThuySanAdapter.setData(setDataIcon());
        rcv_icon.setAdapter(iconThuySanAdapter);
//
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

//    public void setDataa(){
//        Intent intent1 = getActivity().getIntent();
//        ThuySan ts1 = (ThuySan) intent1.getSerializableExtra("objTS");
//
//        list.add(ts1);
//        thuySanAdapter = new ThuySanAdapter(getContext());
////        rcvThuySan = findViewById(R.id.recycle_view_thu);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
//        rcvThuySan.setLayoutManager(linearLayoutManager);
//        thuySanAdapter.setData(list);
//        rcvThuySan.setAdapter(thuySanAdapter);
//
//    }

}
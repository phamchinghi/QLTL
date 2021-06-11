package com.example.qltl.Khac;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qltl.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 */
public class khac extends Fragment {
    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;


    public khac() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khac, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataholder = new ArrayList<>();

        datamodel ob1= new datamodel(R.drawable.color,"Thay đổi màu sắc");
        dataholder.add(ob1);
        datamodel ob2 = new datamodel(R.drawable.save,"Sao lưu dữ liệu");
        dataholder.add(ob2);
        datamodel ob3= new datamodel(R.drawable.info,"Giới thiệu phần mềm");
        dataholder.add(ob3);
        datamodel ob4= new datamodel(R.drawable.set,"Cài đặt cơ bản");
        dataholder.add(ob4);



        recyclerView.setAdapter(new com.example.qltl.Khac.myAdapter(dataholder));

        // Inflate the layout for this fragment
        return view;
    }
}
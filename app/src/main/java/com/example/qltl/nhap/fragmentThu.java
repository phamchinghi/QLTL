package com.example.qltl.nhap;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qltl.R;

public class fragmentThu extends input_output {

    public fragmentThu() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}
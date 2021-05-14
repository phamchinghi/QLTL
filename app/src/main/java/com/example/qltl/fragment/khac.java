package com.example.qltl.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qltl.R;

/**
 * A simple {@link Fragment} subclass.

 */
public class khac extends Fragment {



    public khac() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khac, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
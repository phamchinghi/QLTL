package com.example.qltl.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.qltl.R;
import com.example.qltl.nhap.nhapViewPagerAdapter;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.

 */
public class input_output extends Fragment {

    private TabLayout tabLayout;
    private customViewPager viewPager;
    private Button btnList;

    public input_output() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_output, container, false);
        btnList = view.findViewById(R.id.btn_list);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(),"ok",Toast.LENGTH_SHORT ).show();
            }
        });
        nhapViewPagerAdapter adapter = new nhapViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }

}
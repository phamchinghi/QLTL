package com.example.qltl.nhap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.qltl.fragment.input_output;
import com.example.qltl.fragment.khac;
import com.example.qltl.fragment.lich;

public class nhapViewPagerAdapter extends FragmentStatePagerAdapter {
    public nhapViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragmentThu();
            case 1:
                return new fragmentChi();
            default:
                return new fragmentThu();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Thu";
            case 1:
                return "Chi";
            default:
                return "Thu";
        }
    }
}


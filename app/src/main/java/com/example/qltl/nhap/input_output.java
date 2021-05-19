package com.example.qltl.nhap;

import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qltl.R;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 */
public class input_output extends Fragment {

    private static final String TAG = "inoutputFragment";


    public input_output() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_output, container, false);


        return view;
    }
//    private void dropDownSpinner(){
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                openDetailDialog(Gravity.CENTER);
////                setHint(spin.getSelectedItem().toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }

//    private void openDetailDialog(int gravity){
////        final Dialog dialog = new Dialog(getContext().getApplicationContext());
////        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
////        dialog.setContentView(R.layout.custom_dialog_input);
////        Window window = dialog.getWindow();
////        if(window == null){
////            return;
////        }
////        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
////        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////
////        WindowManager.LayoutParams windowAttributes = window.getAttributes();
////        windowAttributes.gravity = gravity;
////        window.setAttributes(windowAttributes);
////
//        customDialog dialog = new customDialog();
//        if(Gravity.BOTTOM == gravity){
//            dialog.setCancelable(true);
//        }else {
//            dialog.setCancelable(false);
//        }
//        dialog.setTargetFragment(input_output.this, 1);
//        dialog.show(getFragmentManager(), "customDialog");
//    }

}
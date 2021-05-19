package com.example.qltl.nhap;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.qltl.R;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class customInput_Output extends RelativeLayout {

    TabLayout tabLayout;
    customViewPager viewPager;
    Spinner spin;
    final ArrayList<String> names =new ArrayList<String>();
    final ArrayList<Integer> icons = new ArrayList<Integer>();
    Context context;

    public customInput_Output(Context context) {
        super(context);
    }

    public customInput_Output(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void IntializeUILayout(){

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_input_output,this);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);

        spin = (Spinner) view.findViewById(R.id.spin_thu_chi);
        nhapViewPagerAdapter adapterViewPager = new nhapViewPagerAdapter(, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);
        dropDownSpinner();

        customAdapterSpinner adapterSpinner = new customAdapterSpinner(getContext().getApplicationContext(),
                setItemIconSpinner(),setItemNameSpinner());
        spin.setAdapter(adapterSpinner);
    }

    private void openDetailDialog(int gravity){
        final Dialog dialog = new Dialog(getContext().getApplicationContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_input);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        customDialog dialog = new customDialog();
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }
        dialog.setTargetFragment(input_output.this, 1);
        dialog.show(getFragmentManager(), "customDialog");
    }
    private void dropDownSpinner(){
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                openDetailDialog(Gravity.CENTER);
//                setHint(spin.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private ArrayList<String> setItemNameSpinner(){
        names.add("Tôm");
        names.add("Cua");
        names.add("Cá");
        names.add("Sò");
        names.add("Nghêu");
        names.add("Lươn");
        names.add("Bạch tuộc");
        return names;
    }
    private ArrayList<Integer> setItemIconSpinner(){
        icons.add(R.drawable.ic_shrimp);
        icons.add(R.drawable.ic_crab);
        icons.add(R.drawable.ic_fish);
        icons.add(R.drawable.ic_shell);
        icons.add(R.drawable.ic_clam);
        icons.add(R.drawable.ic_eel);
        icons.add(R.drawable.ic_octopus);
        return icons;
    }
}

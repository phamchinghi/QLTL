package com.example.qltl.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qltl.R;
import com.example.qltl.nhap.customAdapterSpinner;
import com.example.qltl.nhap.nhapViewPagerAdapter;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.

 */
public class input_output extends Fragment {

    private TabLayout tabLayout;
    private customViewPager viewPager;
    private Button btnList;
    private Spinner spin;
    private TextView tet;

    public input_output() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_output, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.nhap_view_pager);
        spin = (Spinner) view.findViewById(R.id.spin_thu_chi);
        tet = (TextView) view.findViewById(R.id.test);
        nhapViewPagerAdapter adapterViewPager = new nhapViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);

        dropDownSpinner();


        return view;
    }
    private void dropDownSpinner(){
        String [] names = new String[]{"Tôm","Cua","Cá","Hàu","Lươn"};
        ArrayAdapter<String> customAdapterSpinner = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, names);
        spin.setAdapter(customAdapterSpinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        tet.setText(names[0]);
//                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Tôm", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        tet.setText(names[1]);
//                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Cua", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Ca", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Hàu", Toast.LENGTH_SHORT).show();
                        break;
                    default:

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity().getApplicationContext(), "nothing click", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
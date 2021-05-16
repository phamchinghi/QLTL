package com.example.qltl.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
import android.widget.ImageView;
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
    private Spinner spin;
    String [] names = new String[]{"Tôm","Cua","Cá","Sò","Nghêu","Lươn","Mực"};
    int[] icon = new int[] {R.drawable.ic_shrimp,
            R.drawable.ic_crab,
            R.drawable.ic_fish,
            R.drawable.ic_shell,
            R.drawable.ic_clam,
            R.drawable.ic_eel,
            R.drawable.ic_octopus};

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
        nhapViewPagerAdapter adapterViewPager = new nhapViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setPagingEnable(false);
        tabLayout.setupWithViewPager(viewPager);

        dropDownSpinner();

        customAdapterSpinner adapterSpinner = new customAdapterSpinner(getContext().getApplicationContext(),
                icon,names);
        spin.setAdapter(adapterSpinner);
        return view;
    }
    private void dropDownSpinner(){
//        ArrayAdapter<String> customAdapterSpinner = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, names);
//        spin.setAdapter(customAdapterSpinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity().getApplicationContext());
                        break;
                    case 1:
//                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Cua", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Ca", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Sò", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Nghêu", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Lươn", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getActivity().getApplicationContext(), "you clicked Mực", Toast.LENGTH_SHORT).show();
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
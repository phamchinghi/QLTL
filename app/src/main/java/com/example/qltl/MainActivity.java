package com.example.qltl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.qltl.fragment.viewPagerAdapter;
import com.example.qltl.nhap.input_output;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private customViewPager viewPager;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);


        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnable(false);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.getMenu().findItem(R.id.nhap).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.lich).setChecked(true);
                        break;
                    case 2:
                        bottomNav.getMenu().findItem(R.id.khac).setChecked(true);
                        break;
                    default:
                        bottomNav.getMenu().findItem(R.id.nhap).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nhap:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.lich:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.khac:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        viewPager.setCurrentItem(0);
                }
                return true;
            }
        });
//
//        input_output fragment = new input_output();
//
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, fragment, "inoutputFragment");
//        transaction.commit();
    }
}
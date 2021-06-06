package com.example.qltl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.qltl.adapter.ThuySanAdapter;
import com.example.qltl.adapter.viewPagerAdapter;
import com.example.qltl.widget.customViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private customViewPager viewPager;
    private BottomNavigationView bottomNav;
    List<ThuySan> list = new ArrayList<>();
    private RecyclerView rcvThuySan;
    private ThuySanAdapter thuySanAdapter;

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
    }
    public void setDataa(){
        Intent intent1 = getIntent();
        ThuySan ts1 = (ThuySan) intent1.getSerializableExtra("objTS");

        list.add(ts1);
        thuySanAdapter = new ThuySanAdapter(this);
        rcvThuySan = findViewById(R.id.recycle_view_thu);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvThuySan.setLayoutManager(linearLayoutManager);
        thuySanAdapter.setData(list);
        rcvThuySan.setAdapter(thuySanAdapter);

    }
}
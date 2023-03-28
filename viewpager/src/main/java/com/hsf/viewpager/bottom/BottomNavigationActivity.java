package com.hsf.viewpager.bottom;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hsf.viewpager.R;
import com.hsf.viewpager.base.LogActivity;
import com.hsf.viewpager.radio_group.HomeFragment;
import com.hsf.viewpager.radio_group.MessageFragment;
import com.hsf.viewpager.radio_group.MyFragment;
import com.hsf.viewpager.radio_group.VpAndRgAdapter;

public class BottomNavigationActivity extends LogActivity {
    private ViewPager2 vp;
    private BottomNavigationView bnv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        vp = findViewById(R.id.vp_body);
        bnv = findViewById(R.id.bnv_bottom);

        VpAndRgAdapter vpAndRgAdapter = new VpAndRgAdapter(this);
        vpAndRgAdapter.addFragment(new HomeFragment());
        vpAndRgAdapter.addFragment(new MessageFragment());
        vpAndRgAdapter.addFragment(new OtherFragment());
        vpAndRgAdapter.addFragment(new MyFragment());
        vp.setAdapter(vpAndRgAdapter);
        vp.setCurrentItem(0);

        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bnv.setSelectedItemId(bnv.getMenu().getItem(position).getItemId());
            }
        });

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int index = 0;
                switch (item.getItemId()) {
                    case R.id.homeBottom:
                        index = 0;
                        break;
                    case R.id.first:
                        index = 1;
                        break;
                    case R.id.bluetooth:
                        index = 2;
                        break;
                    case R.id.second:
                        index = 3;
                        break;
                }

                if (vp.getCurrentItem() != index) {
                    vp.setCurrentItem(index, false);
                }

                return true;
            }
        });
    }
}

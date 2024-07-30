package com.hsf.viewpager.withtab;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.hsf.viewpager.R;
import com.hsf.viewpager.base.BaseActivity;

/**
 * ViewPage2 和 TabLayout 的结合使用
 *
 * 适配器使用了官方的 FragmentStateAdapter，因此内容就是一个个的Fragment
 * ViewPager2 和 TabLayout 可以相互影响
 */
public class WithTabActivity extends BaseActivity {

    private ViewPager2 vp2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //这里使用的是FragmentStateAdapter适配器
        TabAdapter tabAdapter = new TabAdapter(this);

        tabLayout = findViewById(R.id.tl_head);
        vp2 = findViewById(R.id.vp_body);
        vp2.setAdapter(tabAdapter);

        tabAdapter.addColor(android.R.color.darker_gray);
        tabAdapter.addColor(android.R.color.holo_red_dark);
        tabAdapter.addColor(android.R.color.holo_green_dark);
        tabAdapter.addColor(android.R.color.holo_blue_dark);
        tabAdapter.addColor(android.R.color.holo_purple);
        tabAdapter.addColor(android.R.color.holo_orange_dark);

        tabLayout.addTab(tabLayout.newTab().setText("第一个界面").setIcon(R.drawable.two));
        tabLayout.addTab(tabLayout.newTab().setText("第二个界面"));
        tabLayout.addTab(tabLayout.newTab().setText("第三个界面"));
        tabLayout.addTab(tabLayout.newTab().setText("第四个界面"));
        tabLayout.addTab(tabLayout.newTab().setText("第五个界面"));
        tabLayout.addTab(tabLayout.newTab().setText("第六个界面"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp2.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.setScrollPosition(position, 0, true);
            }
        });


    }
}

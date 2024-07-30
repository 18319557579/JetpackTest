package com.hsf.viewpager.normal;

import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.hsf.viewpager.R;
import com.hsf.viewpager.base.LogActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager2的简单使用
 *
 * 适配器使用自定义RecyclerView.Adapter
 */
public class MainActivity extends LogActivity {

    private List<ViewPagerModel> viewPagerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        ViewPager2 viewPager2 = findViewById(R.id.vp_main);

        //这里使用的RecyclerView.Adapter的适配器
        VpAdapter vpAdapter = new VpAdapter(viewPagerList);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(vpAdapter);



    }

    private void initData() {
//        for (int i=0; i<2; i++) {
            viewPagerList.add(new ViewPagerModel("123", R.drawable.one));
            viewPagerList.add(new ViewPagerModel("222", R.drawable.two));
            viewPagerList.add(new ViewPagerModel("333", R.drawable.three));
//        }
    }
}
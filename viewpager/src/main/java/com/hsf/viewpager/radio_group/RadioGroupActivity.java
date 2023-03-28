package com.hsf.viewpager.radio_group;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.hsf.viewpager.R;
import com.hsf.viewpager.base.LogActivity;

public class RadioGroupActivity extends LogActivity implements RadioGroup.OnCheckedChangeListener{
    private ViewPager2 vpBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);

        VpAndRgAdapter vpAndRgAdapter = new VpAndRgAdapter(this);

        vpBody = findViewById(R.id.vp_body);
        vpBody.setAdapter(vpAndRgAdapter);
        vpAndRgAdapter.addFragment(new HomeFragment());
        vpAndRgAdapter.addFragment(new MessageFragment());
        vpAndRgAdapter.addFragment(new MyFragment());
        vpBody.setCurrentItem(0);

        RadioGroup radioGroup = findViewById(R.id.rg_bottom);
        radioGroup.setOnCheckedChangeListener(this);

        vpBody.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("Daisy", "页面已经滚动" + position);
                switch (position) {
                    case 0:
                        ((RadioButton)findViewById(R.id.rb_home)).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton)findViewById(R.id.rb_msg)).setChecked(true);
                        break;
                    case 2:
                        ((RadioButton)findViewById(R.id.rb_my)).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.d("Daisy", new StringBuilder().append("已经改变, 当前：").append(checkedId).toString());
        int vpIndex = 0;
        switch (checkedId) {
            case R.id.rb_home:
                vpIndex = 0;
                break;
            case R.id.rb_msg:
                vpIndex = 1;
                break;
            case R.id.rb_my:
                vpIndex = 2;
                break;
        }

        if (vpBody.getCurrentItem() == vpIndex) {
            return;
        }
        Log.d("Daisy", "和原来不同" + vpIndex);
        vpBody.setCurrentItem(vpIndex, false);
    }
}

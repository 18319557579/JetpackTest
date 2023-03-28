package com.hsf.viewpager.radio_group;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class VpAndRgAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments;

    public VpAndRgAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        if (fragments == null) {
            fragments = new ArrayList<>();
        }
    }

    public void addFragment(Fragment fragment) {
        if (fragments != null) {
            fragments.add(fragment);
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}

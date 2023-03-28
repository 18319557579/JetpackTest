package com.hsf.viewpager.withtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hsf.viewpager.R;

import java.util.ArrayList;
import java.util.List;

public class ShowFragment extends Fragment {

    private ShowFragment(){};

    static ShowFragment newInstance(List<Integer> colors, int item) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("color", (ArrayList<Integer>)colors);
        bundle.putInt("item", item);
        ShowFragment showFragment = new ShowFragment();
        showFragment.setArguments(bundle);
        return showFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        ArrayList<Integer> colors = (ArrayList<Integer>)arguments.getSerializable("color");
        Integer item = arguments.getInt("item");

        view.findViewById(R.id.fl_show).setBackgroundResource(colors.get(item));
        view.<TextView>findViewById(R.id.tv_show).setText("第" + item + "个界面");
    }
}

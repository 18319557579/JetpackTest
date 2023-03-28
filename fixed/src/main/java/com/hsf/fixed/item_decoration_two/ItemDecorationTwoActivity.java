package com.hsf.fixed.item_decoration_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hsf.fixed.LogActivity;
import com.hsf.fixed.R;
import com.hsf.fixed.adapter.NormalAdapter;
import com.hsf.fixed.item_decoration.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDecorationTwoActivity extends LogActivity {

    @BindView(R.id.rv_content)
    RecyclerView rvContent;

    private List<String> list;
    private NormalAdapter normalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        ButterKnife.bind(this);
        initList();
        initView();
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "");
        }
    }

    private void initView() {
        normalAdapter = new NormalAdapter(list);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvContent.setLayoutManager(layoutManager);
        rvContent.setAdapter(normalAdapter);

        rvContent.addItemDecoration(new MyItemDecorationTwo(this));
    }
}
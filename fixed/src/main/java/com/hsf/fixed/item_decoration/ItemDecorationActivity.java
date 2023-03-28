package com.hsf.fixed.item_decoration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hsf.fixed.LogActivity;
import com.hsf.fixed.R;
import com.hsf.fixed.adapter.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDecorationActivity extends LogActivity {

    @BindView(R.id.rv_content)
    RecyclerView rvContent;

    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;

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
        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);

        rvContent.setLayoutManager(linearLayoutManager);
        rvContent.setAdapter(normalAdapter);

        rvContent.addItemDecoration(new MyItemDecoration(RecyclerView.VERTICAL, this));
    }
}
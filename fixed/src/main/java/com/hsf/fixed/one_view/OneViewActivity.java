package com.hsf.fixed.one_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hsf.fixed.LogActivity;
import com.hsf.fixed.R;
import com.hsf.fixed.adapter.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneViewActivity extends LogActivity {

    @BindView(R.id.inside_fixed_bar)
    ViewGroup insideFixedBar;

    @BindView(R.id.ll_outside_fixed)
    ViewGroup llOutsideFixed;

    @BindView(R.id.include_hover_view)
    View includeHoverView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.rl_head)
    RelativeLayout rlHead;

    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int topHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_view);

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
        rlHead.post(new Runnable() {
            @Override
            public void run() {
                Log.d("Daisy", rlHead.getHeight() + " / " + rlHead.getMeasuredHeight());
                topHeight = rlHead.getHeight();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                        @Override
                        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                            Log.d("test", "当前x：" + scrollX + "当前y:" + scrollY);
                            if (scrollY >= topHeight) {
                                if (includeHoverView.getParent() != llOutsideFixed) {

                                    //现在设置了insideFixedBar有高度撑着，所以remove后，该空间还是有高度
                                    insideFixedBar.removeView(includeHoverView);
                                    llOutsideFixed.addView(includeHoverView);
                                }

                            }
                            else {
                                if (includeHoverView.getParent() != insideFixedBar) {
                                    llOutsideFixed.removeView(includeHoverView);
                                    insideFixedBar.addView(includeHoverView);
                                }
                            }
                        }
                    });
                }
            }
        });


        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(normalAdapter);
    }
}
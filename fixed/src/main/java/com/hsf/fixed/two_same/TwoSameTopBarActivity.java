package com.hsf.fixed.two_same;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hsf.fixed.LogActivity;
import com.hsf.fixed.R;
import com.hsf.fixed.adapter.NormalAdapter;
import com.hsf.fixed.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoSameTopBarActivity extends LogActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    @BindView(R.id.ll_outside_fixed)
    LinearLayout llOutsideFixed;
    @BindView(R.id.inside_fixed_bar)
    LinearLayout insideFixedBar;

    @BindView(R.id.rl_head)
    RelativeLayout rlHead;

    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int topHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_same_top_bar);

        ButterKnife.bind(this);

        initList();
        initView();
    }

    private void initView() {
//        topHeight = ViewUtils.dip2px(this, 200);
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
                                llOutsideFixed.setVisibility(View.VISIBLE);
                                insideFixedBar.setVisibility(View.INVISIBLE);
                            } else {
                                llOutsideFixed.setVisibility(View.INVISIBLE);
                                insideFixedBar.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        });


        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(normalAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

//        recyclerView.addOnScrollListener();
//        recyclerView.addOnChildAttachStateChangeListener();
//        recyclerView.addOnItemTouchListener();
//        recyclerView.setRecyclerListener();
//        recyclerView.addOnLayoutChangeListener();
//        recyclerView.setOnFlingListener();
//        recyclerView.setLayoutAnimationListener();
//        recyclerView.setOnFocusChangeListener();
//        recyclerView.setOnSystemUiVisibilityChangeListener();
//        recyclerView.setRecyclerListener();

    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "");
        }
    }
}
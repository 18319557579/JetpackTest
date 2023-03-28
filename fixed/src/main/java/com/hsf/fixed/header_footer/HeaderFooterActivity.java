package com.hsf.fixed.header_footer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.hsf.fixed.LogActivity;
import com.hsf.fixed.R;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderFooterActivity extends LogActivity {

    @BindView(R.id.rv_header_footer)
    RecyclerView rv_header_footer;

    @BindView(R.id.fl_outside_fixed)
    View fl_outside_fixed;

    @BindView(R.id.nsv)
    NestedScrollView nsv;

    @BindView(R.id.rl_head)
    RelativeLayout rlHead;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_footer);
        ButterKnife.bind(this);

        List<String> dataList = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            dataList.add("Data:" + i);
        }

        HeaderFooterAdapter adapter = new HeaderFooterAdapter(dataList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_header_footer.setAdapter(adapter);
        rv_header_footer.setLayoutManager(manager);

        rlHead.post(new Runnable() {
            @Override
            public void run() {
                int topHeight = rlHead.getHeight();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    nsv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                        @Override
                        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                            Log.d("test", "当前x：" + scrollX + "当前y:" + scrollY);
                            if (scrollY >= topHeight) {
                                fl_outside_fixed.setVisibility(View.VISIBLE);
                            } else {
                                fl_outside_fixed.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

        /*本来ScrollView可以用这种方法，回调查看当前第一个显示的是哪一个Item，但是用NestedScrollView就不行了，onScrolled一直不回调。
        * 因此改用了上面的方法*/
        rv_header_footer.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("Daisy", "onScrollStateChanged回调：" + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("Daisy", "onScrolled回调：" + dx + " / " + dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                Log.d("Daisy", "findFirstVisibleItemPosition：" + layoutManager.findFirstVisibleItemPosition());
                Log.d("Daisy", "findFirstCompletelyVisibleItemPosition：" + layoutManager.findFirstCompletelyVisibleItemPosition());
            }
        });

        rv_header_footer.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
                Log.d("Daisy", "回调了");
            }
        });

        nsv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("Daisy", "滑动也" + scrollX);
                LinearLayoutManager layoutManager = (LinearLayoutManager)rv_header_footer.getLayoutManager();
                Log.d("Daisy", "findFirstVisibleItemPosition：" + layoutManager.findFirstVisibleItemPosition());
            }
        });

    }
}
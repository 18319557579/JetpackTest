package com.hsf.fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hsf.fixed.header_footer.HeaderFooterActivity;
import com.hsf.fixed.item_decoration.ItemDecorationActivity;
import com.hsf.fixed.item_decoration_two.ItemDecorationTwoActivity;
import com.hsf.fixed.one_view.OneViewActivity;
import com.hsf.fixed.two_same.TwoSameTopBarActivity;
import com.hsf.fixed.use_material.UseMaterialActivity;

public class MainActivity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTwoTopBar(View view) {
        Intent intent = new Intent(MainActivity.this, TwoSameTopBarActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onClickToHeaderFooter(View view) {
        Intent intent = new Intent(MainActivity.this, HeaderFooterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void onClickOneTopBar(View view) {
        Intent intent = new Intent(MainActivity.this, OneViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickMaterialDesign(View view) {
        Intent intent = new Intent(MainActivity.this, UseMaterialActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void onClickItemDecoration(View view) {
        Intent intent = new Intent(MainActivity.this, ItemDecorationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onClickIemDecoration2(View view) {
        Intent intent = new Intent(MainActivity.this, ItemDecorationTwoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
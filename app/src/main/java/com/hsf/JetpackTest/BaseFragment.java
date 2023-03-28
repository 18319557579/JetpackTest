package com.hsf.JetpackTest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Daisy", getClass().getSimpleName() + " 回调了onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Daisy", getClass().getSimpleName() + " 回调了onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onCreateViewLog() {
        Log.d("Daisy", getClass().getSimpleName() + " 回调了onCreateView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Daisy", getClass().getSimpleName() + " 回调了onDestroy");
    }
}

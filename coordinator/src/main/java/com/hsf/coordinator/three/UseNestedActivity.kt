package com.hsf.coordinator.three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.hsf.coordinator.R

class UseNestedActivity : AppCompatActivity() {
    private val llContent: LinearLayout by lazy {
        findViewById(R.id.ll_content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_nested)

        supportActionBar?.hide()


    }
}
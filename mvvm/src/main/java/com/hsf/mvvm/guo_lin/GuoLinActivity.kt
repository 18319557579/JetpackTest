package com.hsf.mvvm.guo_lin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hsf.mvvm.R
import com.hsf.mvvm.databinding.ActivityGuoLinBinding

class GuoLinActivity : AppCompatActivity() {

    private val plusOneBtn: Button by lazy {
        findViewById(R.id.plusOneBtn)
    }
    private val infoText: TextView by lazy {
        findViewById(R.id.infoText)
    }

    lateinit var viewModel: GuoLinViewModel

    lateinit var binding: ActivityGuoLinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guo_lin)

        viewModel = ViewModelProvider(this, GuoLinViewModelFactory(6)).get(GuoLinViewModel::class.java)

        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }

        viewModel.counter.observe(this) {
            infoText.text = it.toString()
        }
    }

}
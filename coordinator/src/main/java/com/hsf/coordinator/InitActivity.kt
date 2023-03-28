package com.hsf.coordinator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hsf.coordinator.four.CollapsingActivity
import com.hsf.coordinator.one.MainActivity
import com.hsf.coordinator.three.UseNestedActivity
import com.hsf.coordinator.two.JustRecyActivity

class InitActivity : AppCompatActivity() {

    private val btnSkip : Button by lazy {
        findViewById(R.id.btn_skip)
    }
    private val btnTwo : Button by lazy {
        findViewById(R.id.btn_two)
    }
    private val btnThree: Button by lazy {
        findViewById(R.id.btn_three)
    }
    private val btnFour: Button by lazy {
        findViewById(R.id.btn_four)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        btnSkip.setOnClickListener {
            val intent = Intent(this@InitActivity, MainActivity::class.java)
            startActivity(intent)
        }
        btnTwo.setOnClickListener {
            val intent = Intent(this@InitActivity, JustRecyActivity::class.java)
            startActivity(intent)
        }
        btnThree.setOnClickListener {
            val intent = Intent(this@InitActivity, UseNestedActivity::class.java)
            startActivity(intent)
        }
        btnFour.setOnClickListener {
            val intent = Intent(this@InitActivity, CollapsingActivity::class.java)
            startActivity(intent)
        }
    }
}
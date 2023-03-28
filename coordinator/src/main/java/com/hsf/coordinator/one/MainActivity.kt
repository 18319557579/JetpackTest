package com.hsf.coordinator.one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hsf.coordinator.ItemEntity
import com.hsf.coordinator.R
import com.hsf.coordinator.SubjectAdapter

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val itemList = ArrayList<ItemEntity>()
        val strings = arrayOf("Android", "后端", "前端", "iOS", "人工智能", "产品", "工具资源", "阅读", "设计", "Android", "后端", "前端", "iOS", "人工智能", "产品", "工具资源", "阅读", "设计")
        strings.forEach {
            itemList.add(ItemEntity(it))
        }

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val subjectAdapter = SubjectAdapter(itemList)

        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = subjectAdapter
        }
    }
}
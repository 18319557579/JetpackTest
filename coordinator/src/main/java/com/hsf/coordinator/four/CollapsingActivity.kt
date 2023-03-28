package com.hsf.coordinator.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hsf.coordinator.ItemEntity
import com.hsf.coordinator.R
import com.hsf.coordinator.SubjectAdapter
import com.hsf.coordinator.databinding.ActivityCollapsingBinding
/*这个的效果怪怪的，Toolbar好像一直在显示*/
class CollapsingActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    private val binding : ActivityCollapsingBinding by lazy {
        ActivityCollapsingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)  //可以获得一个返回键

        binding.collapsingTooBar.title = "标题在此2"  //居然要在这里设置标题
        Glide.with(this).load(R.drawable.banana).into(binding.fruitImageView)

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
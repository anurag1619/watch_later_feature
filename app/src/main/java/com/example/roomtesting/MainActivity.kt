package com.example.roomtesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtesting.Interfaces.OnItemClickListener
import com.example.roomtesting.databinding.ActivityMainBinding
import com.tutomoney.by.roomtesting.Boxes.video_box
import java.util.*
import kotlin.collections.ArrayList
import com.example.roomtesting.EnableDragRecyclerView as EnableDragRecyclerView


class MainActivity : AppCompatActivity(), OnItemClickListener{

    lateinit var binding: ActivityMainBinding
    val list = ArrayList<video_box>()
    private val itemTouchHelper by lazy{
        EnableDragRecyclerView(this)
    }

    val adapter = MainAdapter(this,itemTouchHelper)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list.add(video_box(0,
            "https://i.ytimg.com/vi/K-5EdHZ0hBs/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(1,
            "https://i.ytimg.com/vi/e1USmgeerbE/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(2,
            "https://i.ytimg.com/vi/FVJy5tytTH0/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(3,
            "https://i.ytimg.com/vi/oMuPBHKQpU4/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(4,
            "https://i.ytimg.com/vi/5BA6U6i5zl4/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(5,
            "https://i.ytimg.com/vi/lddMNsptDcA/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(6,
            "https://i.ytimg.com/vi/blv92mipsP4/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(7,
            "https://i.ytimg.com/vi/eCQrJsxw9qk/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(8,
            "https://i.ytimg.com/vi/he8v_wiQVMs/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))
        list.add(video_box(9,
            "https://i.ytimg.com/vi/ba7JNTI17uo/hq720.jpg",
            "xyz",
            "Need for Speed Most Wanted (Final Boss Razor/all 5 races + Final Pursuit)",
            "31.26",
            "10:10"))

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
        adapter.submitList(list)
    }

    fun moveItem(from: Int, to: Int) {
        Collections.swap(list, from, to)
    }

    override fun onItemClicked(position: Long, item: video_box) {
    
    }
}
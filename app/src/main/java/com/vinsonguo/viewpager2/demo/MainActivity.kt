package com.vinsonguo.viewpager2.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.vinsonguo.viewpager2.R
import com.vinsonguo.viewpager2.adapter.FragmentStateAdapter
import com.vinsonguo.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
//        viewPager2.isUserInputEnabled = false
//        viewPager2.offscreenPageLimit = 3
        viewPager2.adapter = object :FragmentStateAdapter(this) {
            override fun getItemCount() = 10
            override fun createFragment(position: Int) = TestFragment.newInstance(position)

        }
    }
}
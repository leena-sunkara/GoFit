package com.masai.gofit.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.masai.gofit.R

class HomeActivity : AppCompatActivity() {

    private var viewPager2: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        setViewPagerAdapter()
    }

    private fun initViews() {
        viewPager2 = findViewById(R.id.homeViewPager)
        tabLayout = findViewById(R.id.homeTabLayout)
    }

    private fun setViewPagerAdapter() {
        val fragmentAdapter = HomeViewPagerAdapter(supportFragmentManager, lifecycle)
        (viewPager2 ?: return).adapter = fragmentAdapter
        TabLayoutMediator(
            tabLayout ?: return, viewPager2 ?: return
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_home)
                    tab.text = "Home"
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_nearby)
                    tab.text = "Nearby"
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_programs)
                    tab.text = "Programs"
                }
                3 -> {
                    tab.setIcon(R.drawable.ic_guild)
                    tab.text = "Guild"
                }
                4 -> {
                    tab.setIcon(R.drawable.ic_store)
                    tab.text = "Store"
                }
            }
        }.attach()
    }
}
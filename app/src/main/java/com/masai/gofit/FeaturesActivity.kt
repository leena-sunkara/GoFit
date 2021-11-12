package com.masai.gofit

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout

import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_features.*

class FeaturesActivity : AppCompatActivity() {

    private var viewPager2: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_features)

        initViews()
        setViewPagerAdapter()

        val tabs: ViewGroup = (tabLayout ?: return).getChildAt(0) as ViewGroup
        for (i in 0 until tabs.childCount) {
            val tab = tabs.getChildAt(i)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 0f
            layoutParams.marginEnd = dpToPx(10)
            layoutParams.marginStart = dpToPx(10)
            layoutParams.width = dpToPx(16)
            tab.layoutParams = layoutParams
            tabLayout?.requestLayout()
        }

        btnSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun dpToPx(dp: Int) = (dp * Resources.getSystem().displayMetrics.density).toInt()

    private fun initViews() {
        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
    }

    private fun setViewPagerAdapter() {
        val fragmentAdapter = FeaturesImageSliderAdapter(supportFragmentManager, lifecycle)
        (viewPager2 ?: return).adapter = fragmentAdapter
        TabLayoutMediator(
            tabLayout ?: return, viewPager2 ?: return
        ) { _, _ -> }.attach()
    }
}
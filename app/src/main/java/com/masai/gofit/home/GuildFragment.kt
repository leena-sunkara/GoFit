package com.masai.gofit.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.masai.gofit.R
import com.masai.gofit.guild.GuildAdapter
import com.masai.gofit.programs.sessionAdapter

class GuildFragment : Fragment() {

    private var viewPager2: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guild, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getActivity()?.getSupportFragmentManager()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setViewPagerAdapter()
    }

    private fun setViewPagerAdapter() {
        val fragmentAdapter = getFragmentManager()?.let { GuildAdapter(it, lifecycle) }
        (viewPager2 ?: return).adapter = fragmentAdapter
        TabLayoutMediator(
            tabLayout ?: return, viewPager2 ?: return
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "My Feed"
                }
                1 -> {
                    tab.text = "My gallery"
                }
            }
        }.attach()
    }

    private fun initViews(view: View) {
        viewPager2 = view.findViewById(R.id.GuidviewPager)
        tabLayout = view.findViewById(R.id.Guidtablayout)
    }

}
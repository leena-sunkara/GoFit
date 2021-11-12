package com.masai.gofit

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

class FeaturesImageSliderAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SearchNearbyFragment()
            1 -> LiveClassesFragment()
            2 -> BuildCommunityFragment()
            3 -> RewardPointsFragment()
            else -> createFragment(position)
        }
    }
}
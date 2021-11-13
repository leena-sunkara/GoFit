package com.masai.gofit.guild

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.masai.gofit.programs.Live_SessionFragment
import com.masai.gofit.programs.Recorded_SessionFragment

class GuildAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyFeedFragment()
            1 -> MyGalleryFragment()

            else -> createFragment(position)
        }
    }
}

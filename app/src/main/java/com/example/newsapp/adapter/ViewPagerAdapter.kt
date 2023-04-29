package com.example.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.fragment.BusinessFragment
import com.example.newsapp.fragment.EntertainmentFragment
import com.example.newsapp.fragment.HealtFragment
import com.example.newsapp.fragment.ScienceFragment
import com.example.newsapp.fragment.SportFragment
import com.example.newsapp.fragment.TechnologyFragment

private const val NUM_TABS = 6
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return BusinessFragment()
            1 -> return HealtFragment()
            2-> return SportFragment()
            3->return  EntertainmentFragment()
            4->return ScienceFragment()
            5->return TechnologyFragment()
        }
        return BusinessFragment()
    }

}
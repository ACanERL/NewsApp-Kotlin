package com.example.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.adapter.ViewPagerAdapter
import com.example.newsapp.databinding.FragmentCategoryBinding
import com.example.newsapp.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

val animalsArray = arrayOf(
    "Business",
    "Healt",
    "Sport",
    "Entertainment",
    "Science",
    "Technology"
)
class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding= FragmentCategoryBinding.inflate(inflater,container,false)


        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()


        return binding.root
    }

}
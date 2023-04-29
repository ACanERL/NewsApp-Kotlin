package com.example.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.databinding.FragmentDiscoverBinding
import com.example.newsapp.databinding.FragmentEntertainmentBinding
import com.example.newsapp.viewmodel.NewsViewModel


class EntertainmentFragment : Fragment() {
    private var _binding: FragmentEntertainmentBinding?=null
    private val binding get() = _binding!!
    lateinit var viewModel: NewsViewModel
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entertainment, container, false)
    }
}
package com.example.newsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentDiscoverBinding
import com.example.newsapp.viewmodel.NewsViewModel


class DiscoverFragment : Fragment() {
    private var _binding:FragmentDiscoverBinding ?=null
    private val binding get() = _binding!!
   lateinit var viewModel: NewsViewModel
   lateinit var adapter:NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentDiscoverBinding.inflate(inflater,container,false)

        viewModel=ViewModelProvider(requireActivity())[NewsViewModel::class.java]

        viewModel.newsResponse.observe(viewLifecycleOwner, Observer {
            val articles=it.articles
            binding.newsRecycler.layoutManager= LinearLayoutManager(requireContext())
            adapter= NewsAdapter(articles)
            binding.newsRecycler.adapter=adapter

            adapter.onItemClick={
                val bundle = bundleOf(
                    "title" to it.title,
                    "descp" to it.description,
                    "image" to it.urlToImage,
                    "time" to it.publishedAt
                )
                findNavController().navigate(R.id.action_discoverFragment_to_detailFragment,bundle)
            }

        })

        viewModel.loadingProgressBar.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.progressBar.visibility=View.VISIBLE
            }
            else{
                binding.progressBar.visibility=View.GONE
            }
        })





        return binding.root
    }


}
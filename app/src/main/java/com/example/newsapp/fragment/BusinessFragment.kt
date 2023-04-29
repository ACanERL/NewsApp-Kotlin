package com.example.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.viewmodel.NewsViewModel


class BusinessFragment : Fragment() {
    private var _binding: FragmentBusinessBinding?=null
    private val binding get() = _binding!!

    lateinit var viewModel: NewsViewModel
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding= FragmentBusinessBinding.inflate(inflater,container,false)
        viewModel= ViewModelProvider(requireActivity())[NewsViewModel::class.java]

        viewModel.businessResponse.observe(viewLifecycleOwner, Observer {
            val articles=it.articles
            binding.businessRecycler.layoutManager= LinearLayoutManager(requireContext())
            adapter= NewsAdapter(articles)
            binding.businessRecycler.adapter=adapter

            adapter.onItemClick={
                val bundle = bundleOf(
                    "title" to it.title,
                    "descp" to it.description,
                    "image" to it.urlToImage,
                    "time" to it.publishedAt
                )
                findNavController().navigate(R.id.action_categoryFragment_to_detailFragment,bundle)
            }
        })

        viewModel.loadingProgressBar.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.progressBar2.visibility=View.VISIBLE
            }
            else{
                binding.progressBar2.visibility=View.GONE
            }
        })
        return binding.root
    }

}
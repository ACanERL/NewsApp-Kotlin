package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsGeneralItemBinding
import com.example.newsapp.model.Articles

class NewsAdapter(private var newsList:List<Articles>) :RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    var onItemClick: ((Articles) -> Unit)? = null
    inner class ViewHolder(val binding: NewsGeneralItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        return ViewHolder(NewsGeneralItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val currnewList=newsList[position]

        holder.binding.generalTitle.text=currnewList.title
        holder.binding.generalsDescp.text=currnewList.description
       //Picasso.get().load(newsList[position].urlToImage).into(holder.binding.generalsImage)
        holder.binding.generalsImage.load(currnewList.urlToImage){
            crossfade(true)
            crossfade(1000)
        }
        holder.binding.generalsImage.setOnClickListener {
            onItemClick?.invoke(currnewList)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}
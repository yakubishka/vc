package com.yakubishka.vc.activities.fragments.news

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.databinding.NewsListItemBinding

class NewsListAdapter(private val items: ArrayList<RssItem>) :
  RecyclerView.Adapter<NewsListAdapter.RssItemViewHolder>() {

  class RssItemViewHolder(private val binding: NewsListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: RssItem) {
      binding.rssItem = item
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssItemViewHolder {
    val binding = DataBindingUtil.inflate<NewsListItemBinding>(
      LayoutInflater.from(parent.context),
      R.layout.news_list_item,
      parent,
      false
    )
    return RssItemViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RssItemViewHolder, position: Int) {
    holder.onBind(items[holder.adapterPosition])
  }

  override fun getItemCount(): Int = items.size

  fun reloadList(list: List<RssItem>) {
    items.run {
      clear()
      addAll(list)
    }
    notifyDataSetChanged()
  }

}
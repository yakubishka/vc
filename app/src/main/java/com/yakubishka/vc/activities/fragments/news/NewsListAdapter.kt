package com.yakubishka.vc.activities.fragments.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.databinding.NewsListItemBinding

class NewsListAdapter(
  private val items: ArrayList<RssItem>,
  private val onItemClick: (item: RssItem) -> Unit) :
  RecyclerView.Adapter<NewsListAdapter.RssItemViewHolder>() {

  class RssItemViewHolder(private val binding: NewsListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: RssItem, onClick: (item: RssItem) -> Unit) {
      binding.rssItem = item
      binding.openDetailsButton.setOnClickListener { onClick(item) }
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
    holder.onBind(items[holder.adapterPosition], onItemClick)
  }

  override fun getItemCount(): Int = items.size

  fun reloadList(list: List<RssItem>) {
    items.clear()
    items.addAll(list)
    notifyDataSetChanged()
  }

}
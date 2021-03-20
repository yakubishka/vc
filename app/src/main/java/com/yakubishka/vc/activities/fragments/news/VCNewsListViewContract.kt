package com.yakubishka.vc.activities.fragments.news

import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.architecture.view.BaseViewContract

interface VCNewsListViewContract: BaseViewContract {
  fun updateList(items: List<RssItem>)
}
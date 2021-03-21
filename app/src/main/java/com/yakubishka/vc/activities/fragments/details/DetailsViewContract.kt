package com.yakubishka.vc.activities.fragments.details

import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.architecture.view.BaseViewContract

interface DetailsViewContract: BaseViewContract {
  fun setModel(model: RssItem)
}
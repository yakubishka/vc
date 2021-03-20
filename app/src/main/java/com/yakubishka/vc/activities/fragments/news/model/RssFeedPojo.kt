package com.yakubishka.vc.activities.fragments.news.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RssFeed(
  @field:Element var channel: RssChanel = RssChanel()
)

@Root(strict = false)
data class RssChanel(
  @field:Element var title: String = "",
  @field:ElementList(inline = true, required = false) var item: List<RssItem> = arrayListOf()
)
package com.yakubishka.vc.activities.fragments.news.model

import com.yakubishka.vc.common.xmlconverters.DescriptionConverter
import org.simpleframework.xml.*
import org.simpleframework.xml.convert.Convert

@Root(strict = false)
data class Enclosure(@field:Attribute(name = "url") var imageUrl: String? = "")


@Root(name = "item", strict = false)
@Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc")
data class RssItem(
  @field:Element(data = true) var title: String = "",
  @field:Element(required = false) var pubDate: String = "",
  @field:ElementList(inline = true, required = false) var enclosure: List<Enclosure> = arrayListOf(),

  @field:Element( required = false)
  @field:Namespace(reference = "http://purl.org/dc/elements/1.1/")
  var creator: String = "",

  @field:Element(required = false)
  @field:Convert(DescriptionConverter::class)
  var description: Description = Description(null)

) {

  fun getImageLink(): String? = if (enclosure.isEmpty())
    null
  else
    enclosure[0].imageUrl

}

data class Description(val text: String? = "") {
  fun getDescriptionContent(): String? = text?.trim()
}

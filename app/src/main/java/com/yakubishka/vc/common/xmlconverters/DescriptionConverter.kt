package com.yakubishka.vc.common.xmlconverters

import com.yakubishka.vc.activities.fragments.news.model.Description
import org.simpleframework.xml.convert.Converter
import org.simpleframework.xml.stream.InputNode
import org.simpleframework.xml.stream.OutputNode
import java.util.regex.Pattern

class DescriptionConverter: Converter<Description> {

  override fun read(node: InputNode?): Description {
    val nodeText = node?.value
    return if (nodeText != null) {
      val htmlTagRegex = "</?[^>]+>"

      val text = nodeText
        .replace(Regex(htmlTagRegex), "")

      Description(text)
    } else {
      Description(null)
    }
  }

  override fun write(node: OutputNode?, value: Description?) = Unit
}
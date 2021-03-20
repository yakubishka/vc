package com.yakubishka.vc.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {

  @JvmStatic
  fun changeDateFormat(date: String, requiredFormat: String): String? {
    val timestamp = convertFromStringToTimestamp(date, "EEE, dd MMM yyyy HH:mm:ss Z")
    return convertTimestampToString(timestamp, requiredFormat)
  }

  @JvmStatic
  fun convertFromStringToTimestamp(text: String, format: String): Long? {
    return try {
      val sdf = SimpleDateFormat(format, Locale.ROOT)
      val date = sdf.parse(text) as Date
      date.time
    } catch (e: ParseException) {
      null
    }
  }

  @JvmStatic
  fun convertTimestampToString(timeStamp: Long?, format: String): String? = try {
    val sdf = SimpleDateFormat(format, Locale("ru"))
    if (timeStamp != null) {
      val netDate = Date(timeStamp)
      if (netDate.compareTo(Date(0)) != 0) sdf.format(netDate) else null
    } else null
  } catch (e: Exception) {
    e.printStackTrace()
    null
  }
}
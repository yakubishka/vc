package com.yakubishka.vc.services.api

import com.yakubishka.vc.activities.fragments.news.model.RssFeed
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface RssService {

  @GET("/rss/all")
  fun getNews(): Observable<Response<RssFeed>>

}

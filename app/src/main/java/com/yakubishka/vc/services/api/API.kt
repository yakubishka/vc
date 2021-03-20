package com.yakubishka.vc.services.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object API {

  private const val BASE_URL = "https://vc.ru/"

  private val retrofit: Retrofit

  init {

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
      .addInterceptor(httpLoggingInterceptor)
      .build()

    retrofit = Retrofit.Builder()
      .client(client)
      .baseUrl(BASE_URL)
      .addConverterFactory(SimpleXmlConverterFactory.create(Persister(AnnotationStrategy())))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }


  fun getRssService(): RssService = retrofit.create(RssService::class.java)

}
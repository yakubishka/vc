package com.yakubishka.vc.services

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class App: Application() {

  companion object {
    lateinit var INSTANCE: App
      private set
  }

  override fun onCreate() {
    super.onCreate()
    INSTANCE = this
  }

  override fun attachBaseContext(base: Context?) {
    super.attachBaseContext(base)
    MultiDex.install(base)
  }
}
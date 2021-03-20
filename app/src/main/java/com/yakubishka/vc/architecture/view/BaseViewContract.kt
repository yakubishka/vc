package com.yakubishka.vc.architecture.view

interface BaseViewContract {
  fun showMessage(message: String)
  fun showLoading()
  fun hideLoading()
}
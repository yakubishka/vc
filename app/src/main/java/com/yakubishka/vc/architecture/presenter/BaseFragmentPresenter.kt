package com.yakubishka.vc.architecture.presenter

import com.yakubishka.vc.architecture.view.BaseViewContract
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragmentPresenter<V: BaseViewContract>: Presenter<V> {

  protected val subscriptions = CompositeDisposable()

  override fun onStop() {
    subscriptions.clear()
  }

  override fun onDestroy() {
    subscriptions.dispose()
  }

}
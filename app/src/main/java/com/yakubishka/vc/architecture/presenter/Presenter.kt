package com.yakubishka.vc.architecture.presenter

import android.os.Bundle
import com.yakubishka.vc.architecture.view.BaseViewContract

interface Presenter<V: BaseViewContract> {

  fun onCreate(savedInstanceState: Bundle?) = Unit

  fun onViewAttached(view: V) = Unit

  fun onStop() = Unit

  fun onDestroy() = Unit

}
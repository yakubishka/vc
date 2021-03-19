package com.yakubishka.vc.architecture.presenter

import android.os.Bundle
import com.yakubishka.vc.architecture.view.BaseViewContract

interface Presenter<V: BaseViewContract> {

  fun onCreate(savedInstanceState: Bundle?)

  fun onViewAttached(view: V)

  fun onStop()

  fun onDestroy()

}
package com.yakubishka.vc.activities.fragments.details

import com.yakubishka.vc.architecture.presenter.BaseFragmentPresenter

class DetailsPresenter: BaseFragmentPresenter<DetailsViewContract>() {

  lateinit var viewContract: DetailsViewContract

  override fun onViewAttached(view: DetailsViewContract) {
    viewContract = view
  }

}
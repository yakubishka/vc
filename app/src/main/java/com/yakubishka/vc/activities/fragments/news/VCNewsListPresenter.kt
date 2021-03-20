package com.yakubishka.vc.activities.fragments.news

import com.yakubishka.vc.architecture.presenter.BaseFragmentPresenter
import com.yakubishka.vc.services.api.API
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class VCNewsListPresenter : BaseFragmentPresenter<VCNewsListViewContract>() {

  private lateinit var viewContract: VCNewsListViewContract

  override fun onViewAttached(view: VCNewsListViewContract) {
    viewContract = view
    viewContract.showLoading()
    fullListReload()
  }

  fun fullListReload() {
    subscriptions.add(
      API.getRssService().getNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          { response ->

            if (response.isSuccessful)
              response.body()?.channel?.item?.let(viewContract::updateList)

          }, Throwable::printStackTrace, viewContract::hideLoading
        )
    )
  }

}
package com.yakubishka.vc.activities.fragments.details

import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.architecture.view.BaseFragment
import com.yakubishka.vc.databinding.FragmentDetailsBinding

class DetailsFragment:
  BaseFragment<FragmentDetailsBinding, DetailsViewContract, DetailsPresenter>() {

  override fun onBindingCreated(binding: FragmentDetailsBinding) {
  }

  override fun createViewContract(): DetailsViewContract = object : DetailsViewContract {

    override fun setModel(model: RssItem) {

    }

    override fun showMessage(message: String) = Unit
    override fun showLoading() = Unit
    override fun hideLoading() = Unit
  }

  override fun getLayoutId(): Int = R.layout.fragment_details

  override fun createPresenter(): DetailsPresenter = DetailsPresenter()
}
package com.yakubishka.vc.activities.fragments.details

import android.os.Bundle
import android.util.Log
import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.architecture.view.BaseFragment
import com.yakubishka.vc.architecture.view.BaseViewContract
import com.yakubishka.vc.databinding.FragmentDetailsBinding

class DetailsFragment private constructor():
  BaseFragment<FragmentDetailsBinding, BaseViewContract, DetailsPresenter>() {

  companion object {

    fun getInstance(item: RssItem): DetailsFragment {
      val fragment = DetailsFragment()
      val args = Bundle().apply { putParcelable(RssItem.BUNDLE_KEY, item) }
      fragment.arguments = args
      return fragment
    }

  }

  override fun onBindingCreated(binding: FragmentDetailsBinding) {
    binding.run {
      collapsing.setExpandedTitleTextAppearance(R.style.ExpandedAppBar)
      collapsing.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar)
      toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24)
      toolbar.setNavigationOnClickListener { getDestinationManageable().popFragment() }
      model = arguments?.getParcelable(RssItem.BUNDLE_KEY)
    }
  }

  override fun createViewContract(): BaseViewContract = object : BaseViewContract {
    override fun showMessage(message: String) = Unit
    override fun showLoading() = Unit
    override fun hideLoading() = Unit
  }

  override fun getLayoutId(): Int = R.layout.fragment_details

  override fun createPresenter(): DetailsPresenter = DetailsPresenter()

}
package com.yakubishka.vc.activities.fragments.news

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.details.DetailsFragment
import com.yakubishka.vc.activities.fragments.news.model.RssItem
import com.yakubishka.vc.architecture.view.BaseFragment
import com.yakubishka.vc.databinding.FragmentVcNewsBinding

class VCNewsListFragment:
  BaseFragment<FragmentVcNewsBinding, VCNewsListViewContract, VCNewsListPresenter>() {

  lateinit var binding: FragmentVcNewsBinding

  private val listAdapter = NewsListAdapter(arrayListOf(), ::openDetailsFragment)

  override fun onBindingCreated(binding: FragmentVcNewsBinding) {
    this.binding = binding

    binding.newsListView.let {
      it.layoutManager = LinearLayoutManager(it.context, LinearLayoutManager.VERTICAL, false)
      it.adapter = listAdapter
    }

    binding.swipeRefreshLayout.setOnRefreshListener {
      presenter.fullListReload()
    }
  }

  private fun openDetailsFragment(item: RssItem) {
    getDestinationManageable().pushFragment(DetailsFragment.getInstance(item))
  }

  override fun createPresenter(): VCNewsListPresenter = VCNewsListPresenter()

  override fun createViewContract(): VCNewsListViewContract = object : VCNewsListViewContract {

    override fun showMessage(message: String) {
      Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
    }

    override fun showLoading() {
      binding.swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
      binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun updateList(items: List<RssItem>) {
      listAdapter.reloadList(items)
    }
  }

  override fun getLayoutId(): Int = R.layout.fragment_vc_news

}
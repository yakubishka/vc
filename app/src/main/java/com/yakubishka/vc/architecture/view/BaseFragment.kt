package com.yakubishka.vc.architecture.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.yakubishka.vc.activities.DestinationManageable
import com.yakubishka.vc.architecture.presenter.Presenter
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<T: ViewDataBinding, V: BaseViewContract, P: Presenter<V>>: Fragment() {

  protected val presenter: P by lazy { return@lazy createPresenter() }
  protected val viewContract: V by lazy { return@lazy createViewContract() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)
    onBindingCreated(binding)
    presenter.onViewAttached(viewContract)
    return binding.root
  }

  override fun onStop() {
    super.onStop()
    presenter.onStop()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  fun getDestinationManageable(): DestinationManageable = (activity) as DestinationManageable

  abstract fun getLayoutId(): Int

  abstract fun onBindingCreated(binding: T)

  abstract fun createPresenter(): P

  abstract fun createViewContract(): V

}
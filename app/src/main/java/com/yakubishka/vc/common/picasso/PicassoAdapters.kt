package com.yakubishka.vc.common.picasso

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso.*
import com.yakubishka.vc.R
import com.yakubishka.vc.services.App

object PicassoAdapters {

  @JvmStatic
  @BindingAdapter("bind:image")
  fun image(view: ImageView?, photo: String?) {
    get().load(photo)
      .placeholder(R.drawable.logo)
      .centerCrop()
      .fit()
      .into(view)
  }

}
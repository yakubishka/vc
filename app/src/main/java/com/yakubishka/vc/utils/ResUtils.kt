package com.yakubishka.vc.utils

import androidx.annotation.StringRes
import com.yakubishka.vc.services.App

fun getString(@StringRes resId: Int): String = App.INSTANCE.getString(resId)
package com.yakubishka.vc.activities

import androidx.fragment.app.Fragment

interface DestinationManageable {
  fun pushFragment(fragment: Fragment)
  fun popFragment()
  fun replace(fragment: Fragment)
}
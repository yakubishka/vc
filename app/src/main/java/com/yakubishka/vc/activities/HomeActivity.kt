package com.yakubishka.vc.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.yakubishka.vc.R
import com.yakubishka.vc.activities.fragments.news.VCNewsListFragment
import com.yakubishka.vc.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity(), DestinationManageable {

  lateinit var binding: ActivityHomeBinding
    private set

  private val containerId = R.id.nav_host_fragment_container

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    replace(VCNewsListFragment())
  }

  override fun pushFragment(fragment: Fragment) {
    supportFragmentManager.commit {
      setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in, R.anim.slide_out)
      addToBackStack(null)
      add(containerId, fragment)
    }
  }

  override fun popFragment() {
    supportFragmentManager.popBackStack()
  }

  override fun replace(fragment: Fragment) {
    supportFragmentManager.commit {
      replace(containerId, fragment)
    }
  }

}
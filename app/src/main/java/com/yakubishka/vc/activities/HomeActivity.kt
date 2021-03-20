package com.yakubishka.vc.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yakubishka.vc.R
import com.yakubishka.vc.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

  lateinit var navController: NavController
    private set

  lateinit var binding: ActivityHomeBinding
    private set

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
    navController = navHostFragment.navController
  }

}
package com.yakubishka.vc.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yakubishka.vc.R
import com.yakubishka.vc.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

  lateinit var navController: NavController
    private set

  lateinit var binding: ActivityHomeBinding
    private set

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
  }

}
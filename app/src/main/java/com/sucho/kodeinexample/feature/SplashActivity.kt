package com.sucho.kodeinexample.feature

import android.os.Bundle
import android.os.Handler
import com.sucho.kodeinexample.R
import com.sucho.kodeinexample.databinding.SplashActivityBinding
import com.sucho.kodeinexample.feature.base.BaseActivity
import com.sucho.kodeinexample.feature.base.BaseViewModel
import com.sucho.kodeinexample.feature.base.navigator.Navigator
import com.sucho.kodeinexample.feature.main.MainActivity
import org.kodein.di.generic.instance

class SplashActivity : BaseActivity<SplashActivityBinding, BaseViewModel>() {
  override fun layoutId(): Int = R.layout.activity_splash

  private val navigator: Navigator by instance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Handler().postDelayed({
      navigator.startActivity(MainActivity::class.java)
    }, 2000)
  }
}
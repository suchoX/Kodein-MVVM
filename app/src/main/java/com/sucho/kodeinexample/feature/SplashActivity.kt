package com.sucho.kodeinexample.feature

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
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
    fullScreen()
    super.onCreate(savedInstanceState)

    Handler().postDelayed({
      navigator.startActivity(MainActivity::class.java)
      finish()
    }, 2000)
  }

  private fun fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
  }
}
package com.sucho.kodeinexample.feature.splash

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.sucho.kodeinexample.R
import com.sucho.kodeinexample.databinding.SplashActivityBinding
import com.sucho.kodeinexample.feature.base.BaseActivity

class SplashActivity : BaseActivity<SplashActivityBinding, SplashViewModel>() {
  override fun getViewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

  override fun layoutId(): Int = R.layout.activity_splash

  override fun onCreate(savedInstanceState: Bundle?) {
    fullScreen()
    super.onCreate(savedInstanceState)
    viewModel.gotoMainActivity()
  }

  private fun fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
  }
}
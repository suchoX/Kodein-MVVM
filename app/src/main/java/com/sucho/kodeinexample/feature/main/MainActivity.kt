package com.sucho.kodeinexample.feature.main

import android.os.Bundle
import com.sucho.kodeinexample.R
import com.sucho.kodeinexample.databinding.MainActivityBinding
import com.sucho.kodeinexample.feature.base.BaseActivity

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {
  override fun layoutId(): Int = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }
}

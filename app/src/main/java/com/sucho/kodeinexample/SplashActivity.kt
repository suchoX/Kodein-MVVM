package com.sucho.kodeinexample

import android.os.Bundle
import android.os.Handler
import com.sucho.kodeinexample.navigator.Navigator
import org.kodein.di.generic.instance

class SplashActivity : BaseActivity() {
  private val navigator: Navigator by instance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    Handler().postDelayed({
      navigator.startActivity(MainActivity::class.java)
    }, 2000)
  }
}
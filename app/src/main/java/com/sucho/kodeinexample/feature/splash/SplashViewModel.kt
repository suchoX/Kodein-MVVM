package com.sucho.kodeinexample.feature.splash

import android.content.Context
import android.os.Handler
import com.sucho.kodeinexample.feature.base.BaseViewModel
import com.sucho.kodeinexample.feature.base.navigator.Navigator
import com.sucho.kodeinexample.feature.main.MainActivity
import com.sucho.kodeinexample.utils.PrefsUtils
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class SplashViewModel constructor(context: Context) : BaseViewModel(), KodeinAware {
  override val kodein by closestKodein(context)
  override val kodeinContext = kcontext(context)

  private val navigator: Navigator by instance()

  fun gotoMainActivity() {
    Handler().postDelayed({
      navigator.startActivityAndFinish(MainActivity::class.java)
    }, 2000)
  }
}
package com.sucho.kodeinexample

import android.app.Application
import android.content.Context
import com.sucho.kodeinexample.di.appModule
import com.sucho.kodeinexample.di.networkModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class CustomApplication : Application(), KodeinAware {
  override val kodein = Kodein.lazy {
    bind<Context>() with singleton { this@CustomApplication.applicationContext }
    bind<CustomApplication>() with singleton { this@CustomApplication }
    import(appModule)
    import(networkModule)
  }
}
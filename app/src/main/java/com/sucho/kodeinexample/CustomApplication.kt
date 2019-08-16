package com.sucho.kodeinexample

import android.app.Application
import android.content.Context
import com.sucho.kodeinexample.di.appModule
import com.sucho.kodeinexample.di.networkModule
import com.sucho.kodeinexample.di.serviceModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber

class CustomApplication : Application(), KodeinAware {
  override val kodein = Kodein.lazy {
    bind<Context>("ApplicationContext") with singleton { this@CustomApplication.applicationContext }
    bind<CustomApplication>() with singleton { this@CustomApplication }
    import(appModule)
    import(networkModule)
    import(serviceModule)
  }

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
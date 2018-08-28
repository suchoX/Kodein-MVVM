package com.sucho.kodeinexample

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.sucho.kodeinexample.di.activityModule
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

open class BaseActivity: AppCompatActivity(), KodeinAware {
  private val _parentKodein by closestKodein()
  override val kodein: Kodein by retainedKodein {
    extend(_parentKodein, copy = Copy.All)
    bind<Activity>() with singleton { this@BaseActivity }
    import(activityModule)
  }
}
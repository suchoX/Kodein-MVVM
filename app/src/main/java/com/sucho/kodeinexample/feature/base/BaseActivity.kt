package com.sucho.kodeinexample.feature.base

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.sucho.kodeinexample.di.activityModule
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>: AppCompatActivity(), KodeinAware {
  protected lateinit var binding: B

  private val _parentKodein by closestKodein()
  override val kodein: Kodein by retainedKodein {
    extend(_parentKodein, copy = Copy.All)
    bind<Activity>() with singleton { this@BaseActivity }
    import(activityModule)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindContentView(layoutId())
  }

  fun bindContentView(layoutId: Int) {
    binding = DataBindingUtil.setContentView(this, layoutId)
  }

  @LayoutRes protected abstract fun layoutId(): Int
}
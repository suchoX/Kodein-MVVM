package com.sucho.kodeinexample.feature.base

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
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
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>: AppCompatActivity(), KodeinAware {
  protected lateinit var binding: B
  lateinit var viewModel: VM

  private val _parentKodein by closestKodein()
  override val kodein: Kodein by retainedKodein {
    extend(_parentKodein, copy = Copy.All)
    bind<Activity>() with singleton { this@BaseActivity }
    bind<Context>("ActivityContext") with singleton { this@BaseActivity }
    import(activityModule)
  }

  private val viewModelFactory: ViewModelProvider.Factory by instance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindContentView(layoutId())
  }

  private fun bindContentView(layoutId: Int) {
    binding = DataBindingUtil.setContentView(this, layoutId)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
  }

  abstract fun getViewModelClass(): Class<VM>

  @LayoutRes protected abstract fun layoutId(): Int
}
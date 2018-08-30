package com.sucho.kodeinexample.feature.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sucho.kodeinexample.di.fragmentModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

abstract class BaseDialogFragment<B : ViewDataBinding, VM : ViewModel> : DialogFragment(), KodeinAware {
  protected lateinit var binding: B
  lateinit var viewModel: VM

  override val kodeinContext: KodeinContext<*> get() = kcontext(activity)
  private val _parentKodein by closestKodein(activity as Context) //TODO: This is crashing

  override val kodein: Kodein = Kodein.lazy {
    extend(_parentKodein)
    import(fragmentModule)
  }

  private val viewModelFactory: ViewModelProvider.Factory by instance()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    bindContentView(inflater, layoutId(), container)
    return binding.root
  }

  private fun bindContentView(inflater: LayoutInflater, layoutId: Int, container: ViewGroup?) {
    binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
  }

  abstract fun getViewModelClass(): Class<VM>

  @LayoutRes protected abstract fun layoutId(): Int
}
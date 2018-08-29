package com.sucho.kodeinexample.feature.main

import android.content.Context
import com.sucho.kodeinexample.feature.base.BaseViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.kcontext

class MainViewModel constructor(context: Context) : BaseViewModel(), KodeinAware {
  override val kodein by closestKodein(context)
  override val kodeinContext = kcontext(context)
}
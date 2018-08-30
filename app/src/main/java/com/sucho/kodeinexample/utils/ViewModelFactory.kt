package com.sucho.kodeinexample.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.sucho.kodeinexample.feature.main.MainViewModel
import com.sucho.kodeinexample.feature.main.randomjoke.RandomJokeViewModel
import com.sucho.kodeinexample.feature.splash.SplashViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val context: Context): ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
      return MainViewModel(context) as T
    } else if(modelClass.isAssignableFrom(SplashViewModel::class.java)) {
      return SplashViewModel(context) as T
    }else if(modelClass.isAssignableFrom(RandomJokeViewModel::class.java)) {
      return RandomJokeViewModel(context) as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
package com.sucho.kodeinexample.feature.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.kcontext
import timber.log.Timber

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

  private var compositeDisposable: CompositeDisposable? = null

  override fun onCleared() {
    super.onCleared()
    Timber.d("unsubscribeFromDataStore(): ")
    if (compositeDisposable != null) {
      compositeDisposable!!.dispose()
      compositeDisposable!!.clear()
      compositeDisposable = null
    }
  }

  protected fun addDisposable(disposable: Disposable) {
    if (compositeDisposable == null) {
      compositeDisposable = CompositeDisposable()
    }
    compositeDisposable!!.add(disposable)
  }

}
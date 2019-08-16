package com.sucho.kodeinexample.feature.main

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.sucho.kodeinexample.data.services.ApiService
import com.sucho.kodeinexample.di.GithubService
import com.sucho.kodeinexample.di.IGithubService
import com.sucho.kodeinexample.feature.base.BaseViewModel
import com.sucho.kodeinexample.utils.IRxSchedulers
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import timber.log.Timber

class MainViewModel constructor(context: Context) : BaseViewModel(), KodeinAware {
  override val kodein by closestKodein(context)
  override val kodeinContext = kcontext(context)

  private val apiService: ApiService by instance()
  private val schedulers: IRxSchedulers by instance()

  private val githubService: IGithubService by instance()

  var dataLoading: MutableLiveData<Boolean> = MutableLiveData()
  var joke: MutableLiveData<String> = MutableLiveData()
  var stringLiveData: MutableLiveData<String> = MutableLiveData()

  fun fetchRandomJoke() {
    dataLoading.postValue(true)
    addDisposable(apiService.getRandomJoke()
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.main())
        .doFinally { dataLoading.postValue(false) }
        .subscribe({response -> joke.postValue(response.value.joke)}, {Timber.e(it)})
    )

    addDisposable(githubService.getUserProfile().observeOn(schedulers.main()).subscribe({
        Log.i("githubService","user $it")
      stringLiveData.postValue(it.company)
    },{

    }))

  }
}
package com.sucho.kodeinexample.di

import com.sucho.kodeinexample.data.model.GithubUser
import com.sucho.kodeinexample.data.services.ApiService
import com.sucho.kodeinexample.data.services.GithubApiService
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Service Module"

val serviceModule = Kodein.Module(MODULE_NAME, false) {
  bind<IGithubService>() with singleton { GithubService(instance(),instance()) }
}

interface IGithubService {
  fun getUserProfile(): Observable<GithubUser>
}

class GithubService(val apiService: ApiService, val githubApiService: GithubApiService): IGithubService{
  override fun getUserProfile(): Observable<GithubUser> {
    return githubApiService.getOctocatProfile().subscribeOn(Schedulers.io())
  }
}

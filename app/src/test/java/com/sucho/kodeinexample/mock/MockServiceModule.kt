package com.sucho.kodeinexample.mock

import com.sucho.kodeinexample.data.model.GithubUser
import com.sucho.kodeinexample.data.services.ApiService
import com.sucho.kodeinexample.data.services.GithubApiService
import com.sucho.kodeinexample.di.IGithubService
import io.reactivex.Observable
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Service Module"

val mockServiceModule = Kodein.Module(MODULE_NAME, false) {
    bind<IGithubService>() with singleton { GithubService(instance(), instance()) }
}

class GithubService(val apiService: ApiService,val githubApiService: GithubApiService) : IGithubService {
    override fun getUserProfile(): Observable<GithubUser> {
        return Observable.just(GithubUser("","","","Github","","",
                "",12,"",123,"","","","",
                "",123,"","","","","",123,
                123,"","",true,"","",
                "","",""))
    }
}

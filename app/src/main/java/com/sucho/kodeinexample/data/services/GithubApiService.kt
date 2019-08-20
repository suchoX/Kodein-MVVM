package com.sucho.kodeinexample.data.services

import com.sucho.kodeinexample.data.model.GithubUser
import io.reactivex.Observable
import retrofit2.http.GET

interface GithubApiService {
  @GET("/users/octocat") fun getOctocatProfile(): Observable<GithubUser>
}
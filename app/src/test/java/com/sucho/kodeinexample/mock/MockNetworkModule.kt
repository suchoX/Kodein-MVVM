package com.sucho.kodeinexample.mock

import com.sucho.kodeinexample.BuildConfig
import com.sucho.kodeinexample.data.services.ApiService
import com.sucho.kodeinexample.data.services.GithubApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val MODULE_NAME = "Network Module"

val mockNetworkModule = Module(MODULE_NAME, false) {
  bind<OkHttpClient>() with singleton { getOkHttpClient() }
  bind<Retrofit>() with singleton { getRetrofit(instance()) }
  bind<ApiService>() with singleton { getApiService(instance()) }
  bind<GithubApiService>() with singleton { getGithubApiService(instance()) }
}


private fun getOkHttpClient(): OkHttpClient {
  val httpBuilder = OkHttpClient.Builder()
  if (BuildConfig.ENABLE_LOGGING) {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    httpBuilder.interceptors()
        .add(httpLoggingInterceptor)
  }
  return httpBuilder.build()
}

private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

private fun getApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

private fun getGithubApiService(retrofit: Retrofit): GithubApiService = retrofit.newBuilder()
        .baseUrl("https://api.github.com").build().create(GithubApiService::class.java)
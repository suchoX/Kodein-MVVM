package com.sucho.kodeinexample.mock

import android.app.Application
import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.robolectric.TestLifecycleApplication
import java.lang.reflect.Method

class MockApplication : Application(), KodeinAware, TestLifecycleApplication {

    override val kodein = Kodein.lazy {
        bind<Context>("ApplicationContext") with singleton { this@MockApplication.applicationContext }
        bind<MockApplication>() with singleton { this@MockApplication }
        import(mockAppModule)
        import(mockNetworkModule)
        import(mockServiceModule)
    }


    override fun beforeTest(method: Method) {}
    override fun prepareTest(o: Any) {}
    override fun afterTest(method: Method) {}
}

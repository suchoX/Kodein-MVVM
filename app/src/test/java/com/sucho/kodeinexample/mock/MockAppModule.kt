package com.sucho.kodeinexample.mock

import android.content.Context
import android.content.res.Resources
import android.preference.PreferenceManager
import com.sucho.kodeinexample.DataObject
import com.sucho.kodeinexample.utils.IRxSchedulers
import com.sucho.kodeinexample.utils.PrefsUtils
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "App Module"

val mockAppModule = Module(MODULE_NAME, false) {
  bind<DataObject>() with singleton { injectDataObject() }
  bind<PrefsUtils>() with singleton { getPrefsUtils(instance("ApplicationContext")) }
  bind<Resources>() with singleton { instance<MockApplication>().resources }
  bind<IRxSchedulers>() with singleton { getIRxSchedulers() }
}

private fun injectDataObject(): DataObject = DataObject("Name", 100L)

private fun getPrefsUtils(context: Context): PrefsUtils = PrefsUtils(PreferenceManager.getDefaultSharedPreferences(context))

private fun getIRxSchedulers(): IRxSchedulers = object : IRxSchedulers {
  override fun main(): Scheduler = AndroidSchedulers.mainThread()
  override fun io(): Scheduler = Schedulers.io()

}
package com.sucho.kodeinexample.di

import com.sucho.kodeinexample.navigator.ActivityNavigator
import com.sucho.kodeinexample.navigator.Navigator
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Activity Module"

val activityModule = Module(MODULE_NAME, false) {
  bind<Navigator>() with singleton { ActivityNavigator(instance()) }
}
package com.sucho.kodeinexample.feature.base.navigator

import android.app.Activity
import com.sucho.kodeinexample.feature.base.navigator.Navigator

class ActivityNavigator constructor(private val activity: Activity) : Navigator() {

  override fun getActivity(): Activity = activity

}
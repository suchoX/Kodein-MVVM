package com.sucho.kodeinexample.navigator

import android.app.Activity
import com.sucho.kodeinexample.navigator.Navigator

class ActivityNavigator constructor(private val activity: Activity) : Navigator() {

  override fun getActivity(): Activity = activity

}
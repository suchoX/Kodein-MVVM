package com.sucho.kodeinexample.navigator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class Navigator {
  abstract fun getActivity(): Activity

  fun startActivity(activityClass: Class<out AppCompatActivity>) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    activity.startActivity(intent)
  }
  fun startActivityWithAnimation(activityClass: Class<out AppCompatActivity>,
      inAnimation: Int, outAnimation: Int) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    activity.startActivity(intent)
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }

  fun startActivityWithAnimation(activityClass: Class<out AppCompatActivity>,
      inAnimation: Int, outAnimation: Int, args: Bundle) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    intent.putExtras(args)
    activity.startActivity(intent)
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }

  fun startActivityWithAnimationForResult(activityClass: Class<out AppCompatActivity>,
      inAnimation: Int, outAnimation: Int, args: Bundle, requestCode: Int) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    intent.putExtras(args)
    getActivity().startActivityForResult(intent, requestCode)
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }

  fun finishActivityWithAnimation(inAnimation: Int, outAnimation: Int) {
    getActivity().finish()
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }

  fun finishActivityWithAnimationForResult(inAnimation: Int, outAnimation: Int, resultCode: Int) {
    val returnIntent = Intent()
    getActivity().setResult(resultCode, returnIntent)
    getActivity().finish()
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }
}
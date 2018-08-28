package com.sucho.kodeinexample.utils

import android.content.SharedPreferences

class PrefsUtils constructor(private val prefs: SharedPreferences) {
  companion object {
    private const val PREFS_LOCATION_PERMISSION_REQUESTED = "Location permission requested"
    private const val PREFS_STORAGE_PERMISSION_REQUESTED = "Storage permission requested"
  }

  fun getLocationPermissionRequested(): Boolean {
    return prefs.getBoolean(PREFS_LOCATION_PERMISSION_REQUESTED, false)
  }

  fun setLocationPermissionRequested(b: Boolean) {
    prefs.edit().putBoolean(PREFS_LOCATION_PERMISSION_REQUESTED, b).apply()
  }

  fun getStoragePermissionRequested(): Boolean {
    return prefs.getBoolean(PREFS_STORAGE_PERMISSION_REQUESTED, false)
  }

  fun setStoragePermissionRequested(b: Boolean) {
    prefs.edit().putBoolean(PREFS_STORAGE_PERMISSION_REQUESTED, b).apply()
  }
}

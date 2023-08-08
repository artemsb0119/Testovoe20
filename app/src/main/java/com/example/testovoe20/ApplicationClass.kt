package com.example.testovoe20

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "43fc7ce2-a03f-45fd-8234-8b0cf4032611"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}
package com.example.myapplication_mardan_tmt.firebase.analitics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
object AnalyticsManager {
    private const val EVENT_APP_LAUNCH = "app_launch"
    private const val EVENT_SCREEN_OPEN = "screen_open"
    private const val PARAM_SCREEN_NAME = "screen_name"

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    fun initialize(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun logAppLaunch() {
        firebaseAnalytics.logEvent(EVENT_APP_LAUNCH, null)
    }

    fun logScreenOpen(screenName: String) {
        firebaseAnalytics.logEvent(EVENT_SCREEN_OPEN, Bundle().apply {
            putString(PARAM_SCREEN_NAME, screenName)
        })
    }
}
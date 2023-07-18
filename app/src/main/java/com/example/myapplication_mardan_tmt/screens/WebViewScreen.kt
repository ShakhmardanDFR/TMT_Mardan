package com.example.myapplication_mardan_tmt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.LaunchedEffect
import com.example.myapplication_mardan_tmt.firebase.analitics.AnalyticsManager

@Composable
fun WebViewScreen() {
    LaunchedEffect(Unit) {
        AnalyticsManager.logScreenOpen("WebView Screen")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    settings.apply {
                        javaScriptEnabled = true
                        loadWithOverviewMode = true
                        useWideViewPort = true
                        domStorageEnabled = true
                        cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                    }
                    webViewClient = WebViewClient()
                    loadUrl("https://habr.com/ru/articles/312516/")
                }
            }
        )
    }
}


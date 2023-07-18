package com.example.myapplication_mardan_tmt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect
import com.example.myapplication_mardan_tmt.firebase.analitics.AnalyticsManager
import com.example.myapplication_mardan_tmt.model.MainViewModel
import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : ComponentActivity()
{
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnalyticsManager.initialize(this)
        AnalyticsManager.logAppLaunch()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        setContent {
            MaterialTheme(colors = darkColors()) {
                val navController = rememberNavController()
                var currentScreen by remember { mutableStateOf("splash") }
                val viewModel: MainViewModel = viewModel()

                LaunchedEffect(Unit) {
                    delay(500)
                    val nextScreen = viewModel.getNextScreen()
                    navController.navigate(nextScreen)

                    logScreenOpen(nextScreen)
                }


                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen(viewModel)
                    }
                    composable("webview") {
                        WebViewScreen()
                    }
                    composable("test") {
                        TestScreen()
                    }
                }

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    currentScreen = destination.route ?: ""
                }
            }
        }
    }
    private fun logScreenOpen(screenName: String) {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        })
    }
}
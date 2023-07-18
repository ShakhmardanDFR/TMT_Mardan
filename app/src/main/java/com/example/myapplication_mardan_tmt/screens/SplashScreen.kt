package com.example.myapplication_mardan_tmt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.myapplication_mardan_tmt.firebase.analitics.AnalyticsManager
import com.example.myapplication_mardan_tmt.model.MainViewModel

@Composable
fun SplashScreen(viewModel: MainViewModel) {
    LaunchedEffect(Unit) {
        AnalyticsManager.logScreenOpen("Splash Screen")
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Splash Screen", fontSize = 50.sp, color = Color.Blue)
    }
}

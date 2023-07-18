package com.example.myapplication_mardan_tmt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication_mardan_tmt.firebase.analitics.AnalyticsManager

@Composable
fun TestScreen() {
    LaunchedEffect(Unit) {
        AnalyticsManager.logScreenOpen("Test Screen")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var isHelloVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isHelloVisible) {
                Text("Hello")
            }
            Image(
                painter = painterResource(R.drawable.q),
                contentDescription = "Image 1",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.w),
                contentDescription = "Image 2",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.e),
                contentDescription = "Image 3",
                modifier = Modifier.size(100.dp)
            )
            Button(onClick = { isHelloVisible = !isHelloVisible }) {
                Text("Hello")
            }
        }
    }
}






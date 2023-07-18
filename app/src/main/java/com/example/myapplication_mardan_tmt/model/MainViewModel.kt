package com.example.myapplication_mardan_tmt.model


import androidx.lifecycle.ViewModel
import java.time.LocalTime

class MainViewModel() : ViewModel() {
    fun getNextScreen(): String {
        val currentTime = LocalTime.now()
        return if (currentTime.isAfter(LocalTime.of(9, 0)) && currentTime.isBefore(LocalTime.of(12, 0))) {
            "webview"
        } else {
            "test"
        }
    }
}
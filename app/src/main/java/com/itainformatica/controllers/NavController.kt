package com.itainformatica.controllers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class Screen { HOME, LOCATION, INSTITUTIONAL }

class NavController {
    companion object{
        var currentNavigatorIndex by mutableStateOf(Screen.HOME)

        fun setNavState(newState: Screen) {
            currentNavigatorIndex = newState
        }
    }

}
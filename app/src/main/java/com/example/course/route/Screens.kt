package com.example.course.route

import kotlinx.serialization.Serializable


sealed class ScreenKey {

    @Serializable
    data object StartScreen : ScreenKey()

    @Serializable
    data object AuthScreen: ScreenKey()

    @Serializable
    data object RegisterScreen: ScreenKey()

}
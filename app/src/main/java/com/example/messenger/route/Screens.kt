package com.example.messenger.route

enum class Screen {
    AUTH,
    REGISTRATION
}

sealed class NavigationItem(val route: String) {

    data object Auth : NavigationItem(Screen.AUTH.name)
    data object Registration : NavigationItem(Screen.REGISTRATION.name)

}
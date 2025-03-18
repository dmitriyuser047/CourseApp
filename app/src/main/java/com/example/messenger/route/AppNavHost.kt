package com.example.messenger.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messenger.ui.sign.auth.Auth
import com.example.messenger.ui.sign.registration.Registration

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItem.Auth.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Auth.route) {
            Auth(navController)
        }
        composable(NavigationItem.Registration.route) {
            Registration(navController)
        }
    }
}
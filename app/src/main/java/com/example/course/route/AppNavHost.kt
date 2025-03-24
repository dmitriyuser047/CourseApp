package com.example.course.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.course.presentation.auth.AuthScreen
import com.example.course.presentation.register.RegisterScreen
import com.example.course.presentation.start.StartScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: ScreenKey = ScreenKey.StartScreen
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<ScreenKey.StartScreen> {
            StartScreen(navController)
        }
        composable<ScreenKey.RegisterScreen> {
            RegisterScreen(navController)
        }
        composable<ScreenKey.AuthScreen> {
            AuthScreen(navController)
        }
    }
}
package com.marketplace.gettako.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marketplace.gettako.ui.screens.splashscreen.SplashScreen
import com.marketplace.gettako.ui.screens.splashscreen.ViewPagerSplashScreen

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.ViewPagerSplashScreen.route) {
            ViewPagerSplashScreen(navController = navController)
        }
    }
}
package com.marketplace.gettako.ui.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen(SPLASH_SCREEN_ROUTER)
    object ViewPagerSplashScreen : Screen(VIEW_PAGER_SPLASH_SCREEN_ROUTER)
}
